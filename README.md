# SAP SCP Spring Boot demo

Just an spring boot application could run on the SAP cloud platform

## development

clone and import project as maven project, run as web application in SAP tomcat 8 (default).

entry is `/rest`, with spring data rest APIs, swagger-ui.html will enable in `http://localhost:8080/swagger-ui.html`

before run locally, pls enable maven `h2` and `log` profile in IDE

```bash
-Dspring.profiles.active=dev
```

enable spring profile `dev` to use local embedded h2 db in project directory

h2 will generate localdb file, and in `dev` profile, spring will show a web management UI in `http://localhost:8080/h2-console`

* login path `/login`
* swagger ui `/swagger-ui.html`

## test

test with dev profile (local h2 db & logger)

```bash
mvn test -Dspring.profiles.active=dev -Ph2,log
```

and code coverage report will be generated in `cp-spring-boot-starter/target/jacoco-report-ui/index.html`


## build package

build war package, skip test

```bash
mvn clean package -Dmaven.test.skip=true
```

## deploy

package and upload `.war` file to SCP

start with VM parameter

```text
-Dspring.profiles.active=production
```

## sentry log

if you want run application with sentry, just enable `sentry` profile in environment, and edit the `DSN` link in `sentry.property`

## other

In simple terms, only need to exclude *sf4j* lib, application could run correctly on SCP.
