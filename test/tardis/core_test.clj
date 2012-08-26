(ns tardis.core-test
  (:use clojure.test
        tardis.core)
  (:import [java.util Date]))

(def u (non-unique-time-uuid))

(deftest test-non-unique
  (is (= u (non-unique-time-uuid (get-time u)))))

(deftest test-unique
  (is (not= u (unique-time-uuid (get-time u)))))

(deftest coerce
  (is (non-unique-time-uuid (Date. (get-time u))))
  (is (non-unique-time-uuid (.getDate (Date. (get-time u)))))
  (is (= (to-uuid (str u)) u))

  ;; broken but will do for now
  (is (not= nil (get-time u)))
  (is (= (get-time u) (get-time (str u)))))
