(ns gender-detection.core-test
  (:require [clojure.test :refer :all]
            [gender-detection.core :refer :all]))

(deftest testing-female-es
  (testing "Female spanish name"
    (is (= (female? "Julia" :es) true))))

(deftest testing-male-es
  (testing "Male spanish name"
    (is (= (male? "Juan" :es) true))))

(deftest testing-find-gender-male-es
  (testing "Find male spanish gender"
    (is (= (find-gender "Pedro" :es) :M))))

(deftest testing-find-gender-female-es
  (testing "Find female spanish gender"
    (is (= (find-gender "Lucia" :es) :F))))

(deftest testing-find-gender-undefined
  (testing "Undefined gender returns nil"
    (is (= (find-gender "Vorplax" :es) nil))))

(deftest testing-find-language-undefined
  (testing "Undefined language returns nil"
    (is (= (find-gender "John" :ch) nil))))

(deftest testing-female-en
  (testing "Female English name"
    (is (= (female? "Emma" :en) true))))

(deftest testing-male-en
  (testing "Male English name"
    (is (= (male? "Peter" :en) true))))

(deftest testing-find-gender-male-en
  (testing "Find male English gender"
    (is (= (find-gender "Clyde" :en) :M))))

(deftest testing-find-gender-female-en
  (testing "Find female spanish gender"
    (is (= (find-gender "Beth" :en) :F))))
