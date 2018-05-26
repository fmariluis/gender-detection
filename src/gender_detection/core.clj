(ns gender-detection.core
  (:require [taoensso.nippy :as nippy]
            [superstring.core :as str]
            [clojure.java.io :as io]))

(def npy-file (io/resource "db.npy"))

(defn clean-name
  [name]
  (-> name
      (str/strip-accents)
      (str/lower-case)))

(defn- filter-names [name]
  (let [names (nippy/thaw-from-file npy-file)]
    (first (filter #(= (str/lower-case (first %)) (clean-name name)) names))))

(defn find-gender [name]
  (let [result (filter-names name)]
    (cond
      (nil? result) nil
      (= (nth result 1) "M") :M
      (= (nth result 1) "F") :F)))

(defn female? [name]
  (let [result (find-gender name)]
    (= :F result)))

(defn male? [name]
  (let [result (find-gender name)]
    (= :M result)))
