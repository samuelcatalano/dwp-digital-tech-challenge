FROM openjdk:11.0.5-jre-slim

MAINTAINER Samuel Catalano <samuel.catalano@gmail.com>

RUN mkdir -p /usr/share/bpdts && \
mkdir /var/run/bpdts && \
mkdir /var/log/bpdts

COPY /target/challenge-0.0.1-SNAPSHOT.jar /usr/share/bpdts/challenge-0.0.1-SNAPSHOT.jar

WORKDIR /usr/share/bpdts/
EXPOSE 8080 8787

ENV TZ=Europe/London
ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US.UTF-8
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF-8", "-jar","challenge-0.0.1-SNAPSHOT.jar"]