#!/usr/bin/env sh

# Ponovno postavljanje Gradle-a
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Dodajemo standardne Gradle komande
warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# Provjera sustava
[ -z "$JAVA_HOME" ] && JAVA_HOME=$(type -p java | xargs readlink -f | xargs dirname | xargs dirname)
if [ -z "$JAVA_HOME" ]; then
    die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
fi

exec java -version
