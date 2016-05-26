(ns repl
  (:require [clojure.repl]
            [readline]
            [reader]
            [printer])
  (:gen-class))


;; read
(defn READ [& [strng]]
  (let [line (if strng strng (read-line))]
    (reader/read-string strng)))

;; eval
(defn EVAL [ast env]
  (cond
    (symbol? ast) (get env ast)
    (seq? ast) (let [[f & args] (map #(EVAL % env) ast)]
                 (apply f args))
    :else ast))

;; print
(defn PRINT [exp]
  exp)


(def default-env
  {'+ +
   '- -
   '* *
   '/ /})

(defn rep [strng] (PRINT (EVAL (READ strng), default-env)))


;; repl loop
(defn repl-loop []
  (let [line (readline/readline "user> ")]
    (when line
      (println (rep line))
      (recur))))
