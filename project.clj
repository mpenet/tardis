(defproject cc.qbits/tardis "1.1.0"
  :description "Simple library to manage Type 1 UUIDs (time based)"
  :url "https://github.com/mpenet/tardis"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.github.stephenc.eaio-uuid/uuid "3.4.0"]]
  :profiles {:1.4  {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5  {:dependencies [[org.clojure/clojure "1.6.0-master-SNAPSHOT"]]}
             :dev  {:dependencies []}
             :test {:dependencies []}}
  :min-lein-version "2.0.0")
