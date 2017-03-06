#!/bin/bash
set -e

POSTGRESQL_USER=${POSTGRESQL_USER:-"weather"}
POSTGRESQL_PASS=${POSTGRESQL_PASS:-"weather"}
POSTGRESQL_DB=${POSTGRESQL_DB:-"weather"}
POSTGRESQL_TEMPLATE=${POSTGRESQL_TEMPLATE:-"DEFAULT"}

POSTGRESQL_BIN=/usr/lib/postgresql/9.6/bin/postgres
POSTGRESQL_CONFIG_DIR=/etc/postgresql/9.6/main
POSTGRESQL_CONFIG_FILE=$POSTGRESQL_CONFIG_DIR/postgresql.conf
POSTGRESQL_DATA_DIR=/etc/postgresql/9.6/data
POSTGRESQL_DATA=/var/lib/postgresql/9.6/main
POSTGRESQL_SCHEMA=/etc/postgresql/9.6/data/schema.sql

POSTGRESQL_SINGLE="sudo -u postgres $POSTGRESQL_BIN --single --config-file=$POSTGRESQL_CONFIG_FILE"

if [ ! -d $POSTGRESQL_DATA ]; then
    mkdir -p $POSTGRESQL_DATA
    chown -R postgres:postgres $POSTGRESQL_DATA
    sudo -u postgres /usr/lib/postgresql/9.6/bin/initdb -D $POSTGRESQL_DATA -E 'UTF-8'
fi

$POSTGRESQL_SINGLE <<< "CREATE USER $POSTGRESQL_USER WITH SUPERUSER;" > /dev/null
$POSTGRESQL_SINGLE <<< "ALTER USER $POSTGRESQL_USER WITH PASSWORD '$POSTGRESQL_PASS';" > /dev/null
$POSTGRESQL_SINGLE <<< "CREATE DATABASE $POSTGRESQL_DB OWNER $POSTGRESQL_USER TEMPLATE $POSTGRESQL_TEMPLATE;" > /dev/null


echo "" > $POSTGRESQL_DATA_DIR/allAlter.sql
echo "" > $POSTGRESQL_DATA_DIR/allData.sql

if ls $POSTGRESQL_DATA_DIR/alter_*.sql 1> /dev/null 2>&1;
	then
		cat $POSTGRESQL_DATA_DIR/alter_*.sql > $POSTGRESQL_DATA_DIR/allAlter.sql
fi

cat $POSTGRESQL_DATA_DIR/data_*.sql > $POSTGRESQL_DATA_DIR/allData.sql

sudo -u postgres $POSTGRESQL_BIN --config-file=$POSTGRESQL_CONFIG_FILE &
dropdb --username=weather --host=weather.postgres --if-exists weather &&
createdb --username=weather --host=weather.postgres weather &&
psql --username=weather --host=weather.postgres < $POSTGRESQL_DATA_DIR/schema.sql &&
psql --username=weather --host=weather.postgres < $POSTGRESQL_DATA_DIR/allAlter.sql &&
psql --username=weather --host=weather.test.postgres < $POSTGRESQL_DATA_DIR/allData.sql


/bin/bash -c "trap : TERM INT; sleep infinity & wait"
