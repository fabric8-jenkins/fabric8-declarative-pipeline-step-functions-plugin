#!/usr/bin/env bash
echo "Rebuilding plugin and installing into the local Jenkins install"

mvn -Dtest=false -DfailIfNoTests=false clean install -Pnochecks $*
rm -rf  ~/.jenkins/plugins/fabric8-declarative-pipeline-step-function-plugin/
cp target/fabric8-declarative-pipeline-step-function-plugin.hpi ~/.jenkins/plugins/fabric8-declarative-pipeline-step-function-plugin.jpi

echo ""
echo "Done - Restarting Jenkins!"

curl -X POST -u $JENKINS_USER:$JENKINS_PASSWORD http://localhost:8080/restart