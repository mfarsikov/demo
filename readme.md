Run tests: `./gradlew test`
Build Docker: `./gradlew docker`

run DB: `docker run --name postgres-db -p 5432:5432 postgres`
run application: `docker run --name demo --link postgres-db:postgres -p 8080:8080 mfarsikov/demo:1.0.0`
