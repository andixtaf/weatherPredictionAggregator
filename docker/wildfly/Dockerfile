FROM jboss/wildfly

ENV JBOSS_HOME /opt/jboss/wildfly

RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent

ADD modules/module.xml /opt/jboss/wildfly/modules/org/postgres/main/module.xml
ADD modules/module.xml /opt/jboss/wildfly/modules/org/postgres/main/postgresql-9.4.1211.jar

ADD ../build/libs/exploded/weather-1.0.war /opt/jboss/wildfly/standalone/deployment


# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
