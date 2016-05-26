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
  (repl/read "(+ 1 2)")
  (repl/eval + repl/default-env)
  (repl/eval 1 repl/default-env)
  (repl/eval 2 repl/default-env)
  (map #(repl/eval % repl/default-env) '(+ 1 2))
  (repl/eval (repl/read "(+ 1 2)") repl/default-env)
  )
