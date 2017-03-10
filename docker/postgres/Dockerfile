FROM debian:jessie

RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ jessie-pgdg main" > /etc/apt/sources.list.d/pgdg.list
RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ jessie-pgdg main" > /etc/apt/sources.list.d/pgdg.list

ADD keys /tmp/
RUN apt-key add /tmp/keys

RUN apt-get -y update
RUN apt-get -y upgrade

RUN apt-get --no-install-recommends -y install locales apt-utils sudo postgresql-client-9.6 postgresql-client-common

RUN localedef -i de_DE -c -f UTF-8 -A /usr/share/locale/locale.alias de_DE.UTF-8
ENV LANG de_DE.utf8


RUN apt-get --no-install-recommends -y install postgresql-9.6 postgresql-client-9.6 postgresql-client-common postgresql-common
RUN mkdir /etc/ssl/private-copy; mv /etc/ssl/private/* /etc/ssl/private-copy/; rm -r /etc/ssl/private; mv /etc/ssl/private-copy /etc/ssl/private; chmod 0700 /etc/ssl/private; chmod 0600 /etc/ssl/private/*; chown -R postgres /etc/ssl/private
ADD run.sh /usr/local/bin/run.sh
RUN chmod +x /usr/local/bin/run.sh

CMD ["/usr/local/bin/run.sh"]

