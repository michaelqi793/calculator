#!/bin/bash
test $(curl http://${CONTAINER_IP}:8081/sum?a=1\&b=2) -eq 4