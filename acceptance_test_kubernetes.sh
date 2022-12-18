#!/bin/bash
set -x
ifconfig
NODE_IP=$(kubectl --kubeconfig=/home/kubernetes/.kube/config get nodes -o jsonpath='{ $.items[0].status.addresses[?(@.type=="ExternalIP")].address }')
NODE_PORT=$(kubectl --kubeconfig=/home/kubernetes/.kube/config get svc calculator-service -o=jsonpath='{.spec.ports[0].nodePort}')
echo http://${NODE_IP}:${NODE_PORT}
mvn failsafe:integration-test failsafe:verify -Dcalculator.url=http://${NODE_IP}:${NODE_PORT}