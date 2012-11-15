(ns qbits.tardis
  (:import [com.eaio.uuid UUID UUIDGen]))

(def clockseq+node (UUIDGen/getClockSeqAndNode))

;; internal
(defprotocol PTimeConverter
  (to-uuid [v])
  (to-time [v]))

(extend-protocol PTimeConverter

  String
  (to-uuid [s]
    (UUID. s))

  UUID
  (to-uuid [s] s)

  java.util.Date
  (to-time [d]
    (.getTime d))

  Object
  (to-time [v] v))

(defn non-unique-time-uuid
  "Non unique as in composted of timestamp + node without added uniquess, so collisions could happen"
  ([time clockseq+node]
     (UUID. (to-time time) clockseq+node))
  ([time]
     (non-unique-time-uuid time clockseq+node))
  ([]
     (non-unique-time-uuid (.getTime (java.util.Date.)))))

(defn unique-time-uuid
  "No collisions possible"
  ([time clockseq+node]
     (UUID. (UUIDGen/createTime (to-time time)) clockseq+node))
  ([time]
     (unique-time-uuid time clockseq+node))
  ([]
     (unique-time-uuid (.getTime (java.util.Date.)))))

(defn uuid->time [v]
  (.getTime ^UUID (to-uuid v)))

(defn uuid->clockseq+node [v]
  (.getClockSeqAndNode ^UUID (to-uuid v)))

(defmethod print-method UUID [uuid ^java.io.Writer w]
  (.write w (str "#tardis/time-uuid \"" (str uuid) "\"")))
