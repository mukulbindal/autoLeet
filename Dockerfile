FROM openjdk:11
LABEL maintainer="seagreenapps.click"
ADD target/leetcode-0.0.1-SNAPSHOT.jar leetcode.jar

RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
RUN apt-get update && apt-get install -y google-chrome-stable && apt-get install vim -y
RUN apt-get update && apt-get install vim -y

ENTRYPOINT ["java", "-jar", "leetcode.jar"]
