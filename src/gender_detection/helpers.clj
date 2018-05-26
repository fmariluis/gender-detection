(ns gender-detection.helpers
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]
            [taoensso.nippy :as nippy]))

;; library development helpers, not really useful to final users


(defn- read-csv [name]
  (with-open [reader (io/reader (str "resources/" name ".csv"))]
    (doall
     (csv/read-csv reader))))

(defn- csv-to-nippy [name]
  (let [data (read-csv name)]
    (nippy/freeze-to-file "resources/db.npy" data)))
