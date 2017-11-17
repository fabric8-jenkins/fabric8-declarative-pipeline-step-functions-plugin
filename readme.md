Jenkins plugin for the [fabric8-declarative-pipeline-step-functions](https://github.com/fabric8-jenkins/fabric8-declarative-pipeline-step-functions) so they can be used in scripted or declarative pipelines.


## Building

```bash
git clone https://github.com/fabric8-jenkins/declarative-step-functions-api.git
git clone https://github.com/fabric8-jenkins/fabric8-declarative-pipeline-step-functions.git
git clone https://github.com/fabric8-jenkins/fabric8-declarative-pipeline-step-functions-plugin.git


cd declarative-step-functions-api
mvn install
cd ../fabric8-declarative-pipeline-step-functions
mvn install
cd ../fabric8-declarative-pipeline-step-functions-plugin
mvn install
```


