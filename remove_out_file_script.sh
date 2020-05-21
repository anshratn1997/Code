#!bin/bash
for file in $(find . -name '*.class' -mindepth 0 -maxdepth 8); do
    rm $file
done

for file in $(find . -name '*.exe' -mindepth 0 -maxdepth 8); do
    rm $file
done