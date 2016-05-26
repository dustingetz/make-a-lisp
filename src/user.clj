(ns user
  (:refer-clojure :exclude [test])
  (:require [repl]
            [clojure.pprint :as pprint]))


(def tests
  {"1" 1
   "+" +
   "(+ 1 2)" 3
   })


(defn test []
  (pprint/pprint
    (map (fn [[input expected]]
           (let [result (repl/rep input)
                 pass? (= result expected)]
             [pass? input expected result]))
         tests))

  ;; (repl/repl-loop)
  )


(comment
  (repl/READ "(+ 1 2)")
  (repl/EVAL + repl/default-env)
  (repl/EVAL 1 repl/default-env)
  (repl/EVAL 2 repl/default-env)
  (map #(repl/EVAL % repl/default-env) '(+ 1 2))
  (repl/EVAL (repl/READ "(+ 1 2)") repl/default-env)
  )