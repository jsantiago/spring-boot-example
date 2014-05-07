#!/bin/bash

usage() {
    echo "Usage: $0 [ --spring-boot | --war ]"
    exit 1
}

if [[ $# == 0 ]]; then
    usage
fi

while [[ -n "$1" ]]; do
    case $1 in
        --spring-boot ) shift
            PORT="8080"
            CONTEXT=""
            ;;
        --war ) shift
            PORT="9000"
            CONTEXT="spring-boot-example"
            ;;
        * ) usage
            ;;
    esac
    shift
done

echo "/hello   -> $(curl -s -X GET http://localhost:$PORT/$CONTEXT/hello)"
echo "/reverse -> $(curl -s -X POST -H "Content-Type: application/json" -d '{"title": "hello", "value": "world"}' http://localhost:$PORT/$CONTEXT/reverse)"
