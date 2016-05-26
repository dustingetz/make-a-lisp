(set-env!
 :resource-paths #{"src"}
 :dependencies '[[net.n01se/clojure-jna "1.0.0"]])

(task-options!
 pom {:project 'my-project
      :version "0.1.0"}
 jar {:manifest {"Foo" "bar"}})
