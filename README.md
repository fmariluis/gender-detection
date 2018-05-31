# gender-detection

[![Clojars Project](https://img.shields.io/clojars/v/gender-detection.svg)](https://clojars.org/gender-detection)

[![Build Status](https://travis-ci.org/fmariluis/gender-detection.svg?branch=master)](https://travis-ci.org/fmariluis/gender-detection)

Simple library to detect the gender of a name. The current version supports English and Spanish names.

## Install

`[gender-detection "0.1.1"]` in  your `project.clj`.

## Usage

```clj
(ns example
  (:require [gender-detection.core :as gd]))
```

You can try to find the gender of a name:
```clj
(gd/find-gender "Susana" :es)
;;=> :F

(gd/find-gender "Beth" :en)
;;=> :F

(gd/find-gender "Carlos" :es)
;;=> :M

(gd/find-gender "Peter" :en)
;;=> :M

(gd/find-gender "Vorplax" :en)
;;=> nil
```

Case doesn't matter, accents are stripped.

There are two simple boolean functions too:
```clj
(gd/male? "Carlos" :es)
;;=> t

(gd/female? "Susana" :es)
;;=> :F

(gd/female? "Vorplax2" :es)
;;=> nil
```

## License

Copyright © 2018 Franco Mariluis

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
