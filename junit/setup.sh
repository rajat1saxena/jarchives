# This scripts sets up JUnit environment for running the programs
# contained in this directory.
#
# Pre-requisite: Download and save junit.jar in this directory.
# Run: . setup.sh (or source.sh)
junit="junit.jar"
hamcrest="hamcrest.jar"
if [ -f "$junit" -a -f "$hamcrest" ]
then
	export JUNIT_HOME=`pwd`
	export CLASSPATH=`echo $CLASSPATH`:$JUNIT_HOME/$junit:$JUNIT_HOME/$hamcrest:.
	echo "Setup complete"
else
	echo "Either junit or hamcrest or both is(are) missing"
fi
