(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.8.0"]
                 [adzerk/bootlaces "0.1.13" :scope "test"]
                 [net.n01se/clojure-jna "1.0.0"]])


(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.0-SNAPSHOT")

(bootlaces! +version+)

(task-options!
 pom {:project 'org.dgetz/mal
      :version +version+}
 aot {:namespace '#{core}}
 jar {:main 'core})
