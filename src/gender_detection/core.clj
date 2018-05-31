(ns gender-detection.core
  (:require [superstring.core :as str]
            [clojure.java.io :as io]
            [clojure.java.jdbc :as j])
  (:gen-class))

;; we have to build the conn string like this to load the resource
(def db-conn {:connection-uri (str "jdbc:sqlite::resource:" (str (io/resource "names.db")))})

(defn- clean-name
  [name]
  (-> name
      (str/strip-accents)
      (str/lower-case)))

(defn- filter-names [name language]
  (let [cleaned-name (clean-name name)
        cleaned-language (clojure.core/name language)
        result (j/query db-conn ["SELECT gender FROM names WHERE name LIKE ? AND language = ?" cleaned-name cleaned-language])
        ]
    (first result)))

(defn find-gender [name language]
  (let [result (filter-names name language)]
    (cond
      (nil? result) nil
      (= (:gender result) "M") :M
      (= (:gender result) "F") :F)))

(defn female? [name language]
  (let [result (find-gender name language)]
    (cond
      (nil? result) nil
      (= result :M) false
      (= result :F) true)
    ))

(defn male? [name language]
  (let [result (find-gender name language)]
    (cond
      (nil? result) nil
      (= result :F) false
      (= result :M) true)
    ))
