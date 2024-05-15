# RUEL.LI

## Start the project
### Prerequirements
1. Having Docker installed (at least a docker deamon runnning, maybe Docker Desktop if on windows).
2. Have JDK (duh 🙄)
### How to run
Start the RuelliApplication.

This will invoke the DockerComposeLifecycleManager
> INFO 20484 --- [ruel.li.2] [           main] .s.b.d.c.l.DockerComposeLifecycleManager : Using Docker Compose file 'C:\dev\workspace\ruel.li.2\compose.yml'

This will start a docker image of MySQL (version 8+) in docker, and automatically configure it for your application.

Subsequently, the schema in the database will be created via Hibernate (looking at the annotations and auto-detecting the model).

Plus, a DataLoader class will create a minimal amount of Data (i.e. a user with username : piroxxi).


## If you need to connect to the database
Via the compose.yml, a mysql instance is started. It doesn't have to be started manually, 
as the spring-boot-docker-compose package automatically starts all docker dependencies.
Moreover, it assigns a free port to the docker container and binds spring to the mysql instance.

### To connect
Simply use 'docker inspect' on the mysql instance :
> docker inspect ruelli2-db-1

This should display something like : 
>       ...
>       "NetworkSettings": {
>           [...]
>           "Ports": {
>               "3306/tcp": [
>                   {
>                       "HostIp": "0.0.0.0",
>                       "HostPort": "49275"
>                   }
>               ],
>               "33060/tcp": null
>           },
>       ...

The value you need is 49275. Maybe there is not so much advantages to having a dynamic local 
database (compared to a docker-configured one). If the config is made obvious, it's simpler
to bind other services to mysql (e.g. having intellij database inspector, or mysql-workbench, etc.)

