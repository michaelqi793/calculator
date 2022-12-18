#!/bin/bash
set -x

NODE_IP=$(kubectl get nodes -o jsonpath='{ $.items[0].status.addresses[?(@.type=="ExternalIP")].address }')
NODE_PORT=$(kubectl get svc calculator-service -o=jsonpath='{.spec.ports[0].nodePort}')
echo http://${NODE_IP}:${NODE_PORT}
mvn failsafe:integration-test failsafe:verify -Dcalculator.url=http://${NODE_IP}:${NODE_PORT}