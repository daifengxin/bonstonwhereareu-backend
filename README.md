# Boston Where are U Backend

## Clone

```shell

```

## Build

java version: jdk 17.

```shell
mvn clean package
```

## How to Run

### Run MySQL & Create Schema

#### Docker installation & Run MySQL

1. Get the Release from official website https://docs.docker.com/get-docker/
2. (Linux) Start docker service `sudo systemctl start docker.serivce`
3. Pull mysql and create password `root` for user `root`.

```shell
docker pull mysql:8.2
docker run -itd --name mysql8 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:8.2
```

#### Create Schema

First enter the docker container.

```shell
sudo docker exec -it mysql8 bash
```

Enter the MySQL server.

```shell
mysql -uroot -p
Enter password: root
mysql> CREATE SCHEMA bostonwhereareu;
mysql> exit
```

### Run Backend

Find the `jar` in the `target` directory

```shell
cd target
java -jar bostonwhereareu-0.0.1-SNAPSHOT.jar
```

### API Docs

```
http://localhost:8080/docs.html
```

### Expose to the public internet

Since Android client can't access internal network API services, we use Ngrok to expose local API service endpoint to the public internet for cloud-based debugging of local service. The steps are:

- Visit the Ngrok official website at https://ngrok.com, register, and download the Ngrok file. 
- After downloading, go to the download directory. Unzip the package and run the initialization script as instructed:

```shell
unzip /path/to/ngrok.zip
./ngrok config add-authtoken yourToken
```

- Run the following command to start:

```shell
./ngrok http 8080
```

Upon successful startup, you'll see the url expose to public like the following:

```shell
Forwarding                    https://7d68-222-129-54-23.ngrok-free.app -> http://localhost:8080
```

Now you can call the API or see the API document in public Internet.

```shell
https://7d68-222-129-54-23.ngrok-free.app/docs.html
```
