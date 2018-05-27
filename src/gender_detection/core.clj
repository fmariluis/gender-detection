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

(defn- filter-names [name]
  (let [cleaned-name (clean-name name)
        result (j/query db-conn ["SELECT sex FROM names WHERE name LIKE ?" cleaned-name])]
    (first result)))

(defn find-gender [name]
  (let [result (filter-names name)]
    (cond
      (nil? result) nil
      (= (:sex result) "M") :M
      (= (:sex result) "F") :F)))

(defn female? [name]
  (let [result (find-gender name)]
    (= :F result)))

(defn male? [name]
  (let [result (find-gender name)]
    (= :M result)))
