# kunekune
[![Build Status](https://travis-ci.org/anekos/kunekune.svg?branch=master)](https://travis-ci.org/anekos/kunekune)
[![codecov](https://codecov.io/gh/anekos/kunekune/branch/master/graph/badge.svg)](https://codecov.io/gh/anekos/kunekune)
[![Clojars Project](https://img.shields.io/clojars/v/net.snca/kunekune.svg)](https://clojars.org/net.snca/kunekune)

A Clojure library designed to ... well, that part is up to you.

```clj
[net.snca/kunekune "0.1.1"]
```

## Usage

```
($-> \"hal\"
     .getBytes
     (map inc $)
     (concat $ $)
     byte-array
     String.
     (str \"!\")
     .toUpperCase)
; IBMIBM!
```

## License

Copyright © 2019 anekos

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
