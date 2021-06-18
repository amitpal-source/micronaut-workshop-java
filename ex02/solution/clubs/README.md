## Get consul Docker image

docker run -d --name=dev-consul -e CONSUL_BIND_INTERFACE=eth0 -e CONSUL_UI_BETA=true -p 8500:8500 consul
---

## Run the application

$ ./gradlew run

