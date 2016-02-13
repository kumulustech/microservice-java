VERSION=$1

if [ -z "$VERSION" ]; then
    echo "usage: deploy.sh version"
    exit 1
fi

JAVA_PID=`ps -ef | grep java | grep -v grep | awk '{print $2}'`

if [ -n "$JAVA_PID" ]; then
    echo "Stopping process $JAVA_PID"
    kill -9 $JAVA_PID
fi

if [ -a microservice-*.jar ]; then
    echo "Removing old microservice jar"
    rm microservice-*.jar
fi

echo "Downloading microservice-$VERSION.jar"
wget http://192.241.247.252/nexus/service/local/repositories/releases/content/com/kumulus/microservice/$VERSION/microservice-$VERSION.jar

echo "starting up microservice-$VERSION.jar"
nohup java -jar microservice-*.jar >/dev/null 2>&1 &

echo deployed version: microservice-$VERSION.jar PID $!