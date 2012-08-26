# tardis

Clojure library to manage Type 1 UUIDs (time based), wrapping
com.eaio.uuid (meaning it is fast and reliable).

Handles "unique" and "non-unique" uuids.

## Usage

```clojure
(use 'tardis.core)

user> (non-unique-time-uuid)
#<UUID 00000139-64f1-0aa2-8a9b-0024d70cf6c4>

user> (non-unique-time-uuid (java.util.Date.))
#<UUID 00000139-64f1-df3b-8a9b-0024d70cf6c4>

;; it can take Long also
user> (non-unique-time-uuid (.getTime (java.util.Date.)))
#<UUID 00000139-64f2-6dc8-8a9b-0024d70cf6c4>

;; or supply the clockseq-and-node yourself
user> (non-unique-time-uuid (java.util.Date.) -8459167316858571068)

```

The API is identical for `unique-time-uuid`.

Some helpers:

```clojure

;; Convert from uuid instances

user> (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
#<UUID 7feaa500-efc7-11e1-8a9b-0024d70cf6c4>

user> (get-time (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"))
9217361010808525281

user> (get-time "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
9217361010808525281

(get-node "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
-8459167316858571068

user> (get-node (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"))
-8459167316858571068

```

## License

Copyright © 2012 Max Penet

Distributed under the Eclipse Public License, the same as Clojure.
