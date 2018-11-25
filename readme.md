Run tests: `./gradlew test`
Build Docker: `./gradlew docker`

run application: `docker run --name demo -p 8080:8080 mfarsikov/greeter:1.0.0`

curl localhost:8080/greeting?name=Joe

kubectl run greeter --image=mfarsikov/greeter:1.0.0
kubectl apply -f src/pod.yml
kubectl port-forward greeter 8080:8080 // secure tunnel from localhost through master to pod
kubectl logs greeter
kubectl exec greeter date
kubectl exec -it greeter ash
kubectl cp greeter:/app/application.yml ./app.yml.txt
