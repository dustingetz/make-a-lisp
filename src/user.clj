(ns user
  (:require [repl]))


(defn -main [& args]
  (repl/repl-loop))
