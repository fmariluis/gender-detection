(ns gender-detection.core-test
  (:require [clojure.test :refer :all]
            [gender-detection.core :refer :all]))

(deftest testing-female
  (testing "Female spanish name"
    (is (= (female? "Julia") true))))

(deftest testing-male
  (testing "Male spanish name"
    (is (= (male? "Juan") true))))

(deftest testing-find-gender-male
  (testing "Find male spanish gender"
    (is (= (find-gender "Pedro") :M))))

(deftest testing-find-gender-female
  (testing "Find female spanish gender"
    (is (= (find-gender "Lucia") :F))))
