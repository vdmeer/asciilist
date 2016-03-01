<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-scm-publish-plugin</artifactId>
	<version>1.1</version>
	<configuration>
		<checkoutDirectory>${project.build.directory}/scmpublish</checkoutDirectory>
		<checkinComment>Publishing javadoc for ${project.artifactId}:${project.version}</checkinComment>
		<content>${project.reporting.outputDirectory}</content>
		<skipDeletedFiles>true</skipDeletedFiles>
		<pubScmUrl>scm:git:git@github.com:vdmeer/asciilist.git</pubScmUrl>
		<!-- 1.0 seems to ignore scmBranch and use master
			<tryUpdate>true</tryUpdate>
		-->
		<!-- to debug, see target/scmpublish
			<skipCheckin>true</skipCheckin>
		-->
	</configuration>
</plugin>