(ns core
  (:gen-class)
  (:require [repl]))


(defn -main [& args]
  (repl/repl-loop))
