#!/bin/bash
test $(curl http://${SERVER_IP}:${SERVER_PORT}/sum?a=1\&b=2) -eq 3