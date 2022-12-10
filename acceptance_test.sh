#!/bin/bash

#test $(curl http://172.17.0.5:8081/sum?a=1\&b=2) -eq 3
#test $(curl 'http://' || $CONTAINER_IP || ':8081/sum?a=1&b=2') -eq 3
curl http://${CONTAINER_IP}:8081/sum?a=1\&b=2
echo $CONTAINER_IP