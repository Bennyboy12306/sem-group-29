In order for the application and the database to interact with each-other, they must be started from one docker compose file.
Starting separate containers will not work, even for development purposes.

Another note for development is that when building locally, docker-compose seems to use old images, even if a new one has just been built.
In order to fix this, run 'docker-compose down --rmi all' in the command line, this removes all old images.

The application accesses the data from the 'Database' class where a connection can be accessed statically using Database#getConnection.
