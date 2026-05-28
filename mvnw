#!/bin/sh
# Maven Wrapper script

MAVEN_VERSION="3.9.6"
MAVEN_DIST_URL="https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${MAVEN_VERSION}/apache-maven-${MAVEN_VERSION}-bin.tar.gz"
MAVEN_HOME="${HOME}/.m2/wrapper/dists/apache-maven-${MAVEN_VERSION}"
MAVEN_BIN="${MAVEN_HOME}/bin/mvn"

if [ ! -f "$MAVEN_BIN" ]; then
    echo "[mvnw] Maven ${MAVEN_VERSION} not found, downloading..."
    mkdir -p "$MAVEN_HOME"
    curl -sL "$MAVEN_DIST_URL" | tar xz -C "$MAVEN_HOME" --strip-components=1
    echo "[mvnw] Maven downloaded to $MAVEN_HOME"
fi

exec "$MAVEN_BIN" "$@"
