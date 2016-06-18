# This scripts sets up JUnit environment for running the programs
# contained in this directory.
#
# Pre-requisite: Download and save junit.jar in this directory.
file="junit.jar"
if [ -f "$file" ]
then
	export JUNIT_HOME=`pwd`
	export CLASSPATH=`echo $CLASSPATH`:$JUNIT_HOME/$file:.
	echo "Setup complete"
else
	echo "No junit.jar found in this directory"
fi
