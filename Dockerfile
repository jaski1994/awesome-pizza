FROM mysql

COPY ./scriptInitDb.sql /docker-entrypoint-initdb.d

EXPOSE 3306
