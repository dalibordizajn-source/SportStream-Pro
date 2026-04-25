#!/usr/bin/env bash

# Glavna skripta za pokretanje gradnje
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Dodajemo potrebne funkcije
warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# Pronalaženje Jave
if [ -n "$JAVA_HOME" ] ; then
    JAVACMD="$JAVA_HOME/bin/java"
else
    JAVACMD="java"
fi

if [ ! -x "$JAVACMD" ] ; then
    die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
fi

# Pokretanje
exec "$JAVACMD" "-Xmx64m" "-Xms64m" -classpath "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
