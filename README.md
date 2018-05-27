# gender-detection

Simple library to detect the gender of a name. The current version only support spanish names.

## Install

`[gender-detection "0.1.0"]` in  your `project.clj`.

## Usage

```clj
(ns example
  (:require [gender-detection.core :as gd]))
```

You can try to find the gender of a name:
```clj
(gd/find-gender "Susana")
;;=> :F

(gd/find-gender "Carlos")
;;=> :M

(gd/find-gender "Vorplax")
;;=> nil
```

Case doesn't matter, accents are stripped.

There are two simple boolean functions too:
```clj
(gd/male? "Carlos")
;;=> t

(gd/female? "Susana")
;;=> :F

(gd/female? "Vorplax2")
;;=> nil
```

## License

Copyright © 2018 Franco Mariluis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
