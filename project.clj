(defproject cc.qbits/tardis "1.0.0"
  :description "Simple library to manage Type 1 UUIDs (time based)"
  :url "https://github.com/mpenet/tardis"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["eaio.com" {:url "http://eaio.com/maven2/"
                              :checksum :ignore}]]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.eaio.uuid/uuid "3.3"]]
  :profiles {:1.4  {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5  {:dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]}
             :dev  {:dependencies [[codox "0.6.1"]]}
             :test {:dependencies []}}
  :min-lein-version "2.0.0")