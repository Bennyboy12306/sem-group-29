# Accessing the Database

run the docker-compose for MariaDB
open the terminal in IntelliJ
run `cmd`
run `docker exec -it sem-group-29-mariadb-1 /bin/bash`
run `mariadb -u root -p`
enter password `rootpassword` be aware it will look like nothing is being entered, this is fine type it in and press enter

# Set up and Populate the Database
once inside the mariadb database:
run `CREATE DATABASE world;`
run `exit` x2
copy the database .sql to a temp.sql by running `docker cp <path/to/world.sql> <container_name_or_id>:/tmp/file.sql` replacing the required fields with the correct value
run `docker exec -it sem-group-29-mariadb-1 /bin/bash`
run `mariadb -u root -p world < /tmp.file.sql`
now log back into the database with `mariadb -u root -p` enter the password again
run `USE world`
run `SHOW TABLES;` to confirm that it has worked
if everything has worked you can now run queries

TODO
CONNECT JAVA FILE TO DATABASE SO QUERIES CAN BE RAN FROM THERE