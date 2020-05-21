#!bin/bash
for file in $(find . -name '*.class'  -mindepth 1 -maxdepth 8); do
    echo $file
done