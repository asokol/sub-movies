sub-movies
==========

Movies subtitles analysis.


# Preface: #
Once upon a time, I was bored about long dialog in 199x movie. Eventually, I want to check whether movie dialogues become shorter nowadays comparing with past.

# Progress: #
1.  *Parse phrases from movie subtitles.*
2.  *Build fancy plots to visualise distribution of phrases.*
3.  *Retrive dialogues from movie subtitles.*
4.  Find average dialogue length of movie for specific year.
	
# Deployment: #
	0.  Install JDK 1.5+.
	1.  Install Maven http://maven.apache.org/.
	2.  Download JChart2D http://jchart2d.sourceforge.net/.
		Unpack and manually add these jars jide-oss-2.9.7.jar, jchart2d-3.2.2.jar, xmlgraphics-commons-1.3.1.jar to maven local repository using such command:
			mvn install:install-file -Dfile=AAA-X.Y.Z.jar -DgroupId=jchart2d -DartifactId=AAA -Dversion=X.Y.Z -Dpackaging=jar
			AAA - the name of jar, X.Y.Z - version
	2.  Clone repository.
	3.  Run and see plots of subtitles and dialogues:
			mvn exec:java -Dexec.mainClass="org.asokol.submovies.EntryPoint" -Dexec.args="-file=./src/test/resources/subtitles/TheMatrix.srt"


# Test: #
	1. Run "mvn test"
	2. Verify tests.

	
# Future plans: #
Find other relations between dialogues characteristics in movie and it's genre/country of production/acting persons/etc.