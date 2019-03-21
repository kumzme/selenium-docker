FROM openjdk:8u191-jre-alpine3.8
Run apk add curl jq
# Workspace
  WORKDIR /usr/share/udemy

# ADD .jar under target from host
#into this image
ADD target/selenium-docker.jar         selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs                        libs

# in caase of any other dependency like .csv/.json/.xls
#please ADD that as well

# ADD suite files
ADD bookflightModule.xml              flight-module.xml
ADD searchModule.xml                  search-module.xml

# ADD health check script
ADD healthcheck.sh                   healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT  sh healthcheck.sh