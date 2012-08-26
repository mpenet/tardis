(ns tardis.core
  (:import [com.eaio.uuid UUID UUIDGen]))

(def clockseq-and-node (UUIDGen/getClockSeqAndNode))

(defprotocol PTimeConverter
  (to-time [v]))

(extend-protocol PTimeConverter

  java.util.Date
  (to-time [d]
    (.getTime d))

  Object
  (to-time [v] v))

(defn non-unique-time-uuid
  "Non unique as in composted of timestamp + node without added uniquess, so collisions could happen"
  ([time clockseq-and-node]
     (UUID. (to-time time) clockseq-and-node))
  ([time]
     (non-unique-time-uuid time clockseq-and-node))
  ([]
     (non-unique-time-uuid (.getTime (java.util.Date.)))))

(defn unique-time-uuid
  "No collisions possible"
  ([time clockseq-and-node]
     (UUID. (UUIDGen/createTime (to-time time)) clockseq-and-node))
  ([time]
     (unique-time-uuid time clockseq-and-node))
  ([]
     (unique-time-uuid (.getTime (java.util.Date.)))))

(defn get-time [^UUID uuid]
  (.getTime uuid))

(defn get-node [^UUID uuid]
  (.getClockSeqAndNode uuid))

(defn from-string [^String s]
  (UUID. s))
