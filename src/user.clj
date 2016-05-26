(ns user
  (:refer-clojure :exclude [test])
  (:require [repl]
            [clojure.pprint :as pprint]))


(def tests
  {
   "abcABC123" "abcABC123"
   "hello mal world" "hello mal world"
   "[]{}\"'* ;:()" "[]{}\"'* ;:()"
   })



(defn test []
  (pprint/pprint
    (map (fn [[input expected]]
           (let [result (repl/rep input)
                 pass? (= result expected)]
             [pass? input expected]))
         tests))

  ;; (repl/repl-loop)
  )
