# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY bookmymovie.jar /bmm.jar
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/bmm.jar"]
# Running the docker
# docker container run -d --name catalog_db -e MYSQL_ROOT_PASSWORD=simple -e MYSQL_DATABASE=bmm -e MYSQL_USER=bmm -e MYSQL_PASSWORD=1qazZAQ mysql