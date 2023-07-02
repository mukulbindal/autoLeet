FROM openjdk:11
LABEL maintainer="seagreenapps.click"
ADD target/leetcode-0.0.1-SNAPSHOT.jar leetcode.jar
ENTRYPOINT ["java", "-jar", "leetcode.jar"]