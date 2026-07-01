(ns atproto.sdk
  "EDN-first AT Protocol SDK coverage map for kotoba-lang/atproto."
  (:require [clojure.edn :as edn]
            #?(:clj [clojure.java.io :as io])))

(defn coverage
  "Read the SDK coverage EDN resource. CLJS runtimes should consume this data
  through a build-time EDN load or an application-provided copy."
  []
  #?(:clj (some-> "atproto/sdk_coverage.edn" io/resource slurp edn/read-string)
     :cljs nil))

(defn features []
  (:atproto.sdk/features (coverage)))

(defn feature [id]
  (first (filter #(= id (:id %)) (features))))

(defn planned-features []
  (filter #(= :planned (:kotoba.status %)) (features)))

(defn partial-features []
  (filter #(= :partial (:kotoba.status %)) (features)))

(defn extraction-order []
  (get-in (coverage) [:atproto.sdk/recommendation :next-extraction-order]))
