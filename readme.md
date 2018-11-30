# Kubernetes up and running
## Build application
### Build with com.palantir.docker Plugin

Run tests: `./gradlew test`

Build Docker: `./gradlew docker`

### Build with com.google.cloud.tools.jib.gradle.JibPlugin

Build and push to DockerRegistry: `./gradlew jib`

Build and publish on local docker host: `./gradlew jibDockerBuild`

### Run container

Run app: `docker run --name demo -p 8080:8080 mfarsikov/greeter:1.0.0`

Check: `curl localhost:8080/greeting?name=Joe`

## K8S interaction

### Pods

`kubectl run greeter --image=mfarsikov/greeter:1.0.0`

`kubectl apply -f pod.yml`

`kubectl port-forward greeter 8080:8080 // secure tunnel from localhost through master to pod`

`kubectl logs greeter`

`kubectl exec greeter date`

`kubectl exec -it greeter ash`

`kubectl cp greeter:/app/application.yml ./app.yml.txt`

### Labels

`kubectl label pods greeter canary=true` add label to currently deployed pod

`kubectl get pods -L canary` add column "canary" with label value for each pod

`kubectl get pods --show-labels`

`kubectl get pods --selector="canary=true"`

kubectl get pods --selector="canary in (false,true)"


### Services

`kubectl run greeter --image="mfarsikov/greeter:1.1.1" --replicas=1 --port=8080`
`kubectl expose deployment greeter`
`kubectl get services`

kubectl proxy
curl localhost:8001/api/v1/namespaces/default/greeter/ping
