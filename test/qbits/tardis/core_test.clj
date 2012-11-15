(ns qbits.tardis.core-test
  (:use clojure.test
        qbits.tardis)
  (:import [java.util Date]))

(def u (non-unique-time-uuid))

(deftest test-non-unique
  (is (= u (non-unique-time-uuid (uuid->time u)))))

(deftest test-unique
  (is (not= u (unique-time-uuid (uuid->time u)))))

(deftest coerce
  (is (non-unique-time-uuid (Date. (uuid->time u))))
  (is (non-unique-time-uuid (.getDate (Date. (uuid->time u)))))
  (is (= (to-uuid (str u)) u))

  ;; broken but will do for now
  (is (not= nil (uuid->time u)))
  (is (= (uuid->time u) (uuid->time (str u)))))
