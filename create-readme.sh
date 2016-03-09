#!/usr/bin/env bash

version=`cat src/bundle/pm/project.properties |grep "mvn.version"|sed -e 's/mvn.version=//'`

files="
	src/main/asciidoc/overview-start.adoc
	src/bundle/doc-fragments/resources.adoc
	src/bundle/doc-fragments/installation.adoc
	src/site/asciidoc/introduction.adoc
	src/site/asciidoc/getting-started.adoc
	src/bundle/doc-fragments/examples.adoc
	src/bundle/doc-fragments/styles.adoc
	src/site/asciidoc/user-guide/styles/itemize-nested.adoc
	src/site/asciidoc/user-guide/styles/enumerate.adoc
	src/site/asciidoc/user-guide/styles/enumerate-nested.adoc
	src/site/asciidoc/user-guide/styles/checklist.adoc
	src/site/asciidoc/user-guide/styles/checklist-nested.adoc
"

output_file=src/bundle/doc/README.adoc

echo > ${output_file}
cat src/bundle/doc-fragments/title.adoc >>${output_file}
echo ":release-version: ${version}" >> ${output_file}
echo "" >> ${output_file}

for file in ${files}
do
	cat $file >> ${output_file}
done
echo "" >> ${output_file}

#cat $output_file
