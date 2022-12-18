#!/bin/bash
set -x
NODE_IP=$(kubectl --kubeconfig=/home/kubernetes/.kube/config get nodes -o jsonpath='{ $.items[0].status.addresses[?(@.type=="ExternalIP")].address }')
NODE_PORT=$(kubectl --kubeconfig=/home/kubernetes/.kube/config get svc calculator-service -o=jsonpath='{.spec.ports[0].nodePort}')
echo http://172.17.0.1:${NODE_PORT}
test $(curl http://172.17.0.1:${NODE_PORT}/sum?a=1\&b=2) -eq 3
mvn failsafe:integration-test failsafe:verify -Dcalculator.url=http://172.17.0.1:${NODE_PORT}