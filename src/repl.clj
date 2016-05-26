(ns repl
  (:refer-clojure :exclude [read eval print])
  (:require [clojure.repl]
            [readline]
            [reader]
            [printer]))


(defn read [& [strng]]
  (let [line (if strng strng (read-line))]
    (reader/read-string strng)))


(defn eval [ast env]
  (cond
    (symbol? ast) (get env ast)
    (seq? ast) (let [[f & args] (map #(eval % env) ast)]
                 (apply f args))
    :else ast))


(defn print [exp]
  exp)


(def default-env
  {'+ +
   '- -
   '* *
   '/ /})

(defn rep [line]
  (-> (read line)
      (eval default-env)
      print))


(defn repl-loop []
  (let [line (readline/readline "user> ")]
    (when line
      (println (rep line))
      (recur))))
