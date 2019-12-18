(ns kunekune-test
  (:require [clojure.test :refer [deftest is testing]]
            [kunekune :refer [$->]]))


(deftest $->-test
  (testing "Too simple"
    (is (= 123
           ($-> 123))))

  (testing "Simple"
    (is (= 123
           ($-> 123
                identity))))

  (testing "Without `$`"
    (is (= -2
           ($->
             1
             (+ 1)
             (- 4)))))

  (testing "With `$`"
    (is (= 2
           ($->
             1
             (+ 1)
             (- 4 $))))
    (is (= 2
           ($->
             inc
             ($ 1)))))

  (testing "Double `$`"
    (is (= '(1 2 3 1 2 3)
           ($->
             '(1 2 3)
             (concat $ $)))))

  #_(testing "Not supported"
      (is (= {:foo 2}
             ($->
               1
               (+ 1)
               {:foo $})))))
