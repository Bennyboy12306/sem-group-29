FROM mysql
WORKDIR /tmp

# Copy world.sql file in to container
COPY world.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD password