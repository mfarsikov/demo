**Build with com.palantir.docker Plugin**

Run tests: `./gradlew test`

Build Docker: `./gradlew docker`

**Build with com.google.cloud.tools.jib.gradle.JibPlugin**

Build and push to DockerRegistry: `./gradlew jib`

Build and publish on local docker host: `./gradlew jibDockerBuild`

**Run container**

Run app: `docker run --name demo -p 8080:8080 mfarsikov/greeter:1.0.0`

Check: `curl localhost:8080/greeting?name=Joe`

**K8S interaction**

`kubectl run greeter --image=mfarsikov/greeter:1.0.0`

`kubectl apply -f pod.yml`

`kubectl port-forward greeter 8080:8080 // secure tunnel from localhost through master to pod`

`kubectl logs greeter`

`kubectl exec greeter date`

`kubectl exec -it greeter ash`

`kubectl cp greeter:/app/application.yml ./app.yml.txt`

