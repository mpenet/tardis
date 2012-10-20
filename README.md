# tardis

Clojure library to manage Type 1 UUIDs (time based), wrapping
com.eaio.uuid (meaning it is fast and reliable).

Handles "unique", "non-unique" uuids and retrieval of composing values.

[![Build Status](https://secure.travis-ci.org/mpenet/tardis.png?branch=master)](http://travis-ci.org/mpenet/tardis)

## Usage

```clojure
(use 'tardis.core)

user> (non-unique-time-uuid)
#tardis/time-uuid "00000139-64f1-0aa2-8a9b-0024d70cf6c4"

user> (non-unique-time-uuid (java.util.Date.))
#tardis/time-uuid "00000139-64f1-df3b-8a9b-0024d70cf6c4"

;; it can take Longs also
user> (non-unique-time-uuid (.getTime (java.util.Date.)))
#tardis/time-uuid "00000139-64f2-6dc8-8a9b-0024d70cf6c4"

;; or supply the clockseq-and-node yourself
user> (non-unique-time-uuid (java.util.Date.) -8459167316858571068)

```

The API is identical for `unique-time-uuid`.

Some helpers:

```clojure

;; Convert from strings and retrieve time

user> #tardis/time-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"
#tardis/time-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"

;; the reader literal is aliased to this fn
user> (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
#tardis/time-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"

user> (uuid->time (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"))
9217361010808525281

user> (uuid->time "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
9217361010808525281

user> (uuid->clockseq+node "7feaa500-efc7-11e1-8a9b-0024d70cf6c4")
-8459167316858571068

user> (uuid->clockseq+node (to-uuid "7feaa500-efc7-11e1-8a9b-0024d70cf6c4"))
-8459167316858571068

```

## License

Copyright © 2012 Max Penet

Distributed under the Eclipse Public License, the same as Clojure.
