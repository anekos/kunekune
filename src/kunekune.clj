(ns kunekune)


(defmacro $->
  "Flexible threading macro
e.g.
  ($-> \"hal\"
       .getBytes
       (map inc $)
       (concat $ $)
       byte-array
       String.
       (str \"!\")
       .toUpperCase)
  ; IBMIBM!
  "
  [initial-val & clauses]
  (letfn [($->-replace [clause rep]
            (if (sequential? clause)
              (map #($->-replace % rep) clause)
              (if (= '$ clause)
                rep
                clause)))

          ($->-transform [init clause]
            (let [init-sym (gensym)
                  replaced ($->-replace clause init-sym)]
              (if (= replaced clause)
                (if (list? clause)
                  (let [[head & tail] clause]
                    `(~head ~init ~@tail))
                  `(~clause ~init))
                `(let [~init-sym ~init]
                   ~replaced))))

          ($->-wrap [init clauses]
            (if (empty? clauses)
              init
              (let [[fst & rst] clauses]
                ($->-wrap
                  ($->-transform
                    init
                    fst)
                  rst))))]
    ($->-wrap initial-val clauses)))
