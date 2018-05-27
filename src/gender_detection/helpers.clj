(ns gender-detection.helpers
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

;; library development helpers, not really useful to final users


(defn- read-csv [name]
  (with-open [reader (io/reader (str "resources/" name ".csv"))]
    (doall
     (csv/read-csv reader))))

(defn- csv-to-edn [name]
  (let [data (read-csv name)]
    (with-open [w (io/writer "resources/data.clj")]
      (binding [*out* w]
        (pr data)))))
