FROM dockerfile/java

ENV TOMCAT_VERSION 8.0.5
ENV CATALINA_HOME /opt/apache-tomcat
ENV PATH $PATH:$CATALINE_HOME/bin

RUN wget http://archive.apache.org/dist/tomcat/tomcat-8/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz -O /tmp/apache-tomcat-${TOMCAT_VERSION}.tar.gz
RUN tar xzf /tmp/apache-tomcat-${TOMCAT_VERSION}.tar.gz -C /opt
RUN rm /tmp/apache-tomcat-${TOMCAT_VERSION}.tar.gz
RUN ln -sf /opt/apache-tomcat-${TOMCAT_VERSION} /opt/apache-tomcat
RUN rm -rf /opt/apache-tomcat/webapps/docs
RUN rm -rf /opt/apache-tomcat/webapps/examples

ADD build/libs/spring-boot-example.war /tmp/
RUN mv /tmp/spring-boot-example.war /opt/apache-tomcat/webapps/spring-boot-example.war

EXPOSE 8080

CMD ["/opt/apache-tomcat/bin/catalina.sh", "run"]
