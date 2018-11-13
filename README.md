# SAP SCP Spring Boot demo

Just an spring boot application could run on the SAP cloud platform

## development

clone and import project as maven project, run as web application in SAP tomcat 8 (default).

entry is `/rest`, with spring data rest APIs, swagger-ui.html will enable in `http://localhost:8080/swagger-ui.html`

before run locally, pls enable maven `h2` and `log` profile in IDE.

default user is `admin/password`, project disabled csrf token & set option frame as same origin.

enable spring profile `-Dspring.profiles.active=dev` to use local embedded h2 db in project directory

* h2 db management `http://localhost:8080/h2-console`, jdbc url: `jdbc:h2:file:./local;DB_CLOSE_ON_EXIT=FALSE`
* login path `http://localhost:8080/login`
* swagger ui `http://localhost:8080/swagger-ui.html`

## test

test with dev profile (local h2 db & logger)

```bash
mvn test -Dspring.profiles.active=dev -Ph2,log
```

and code coverage report will be generated in `cp-spring-boot-starter/target/jacoco-report-ui/index.html`


## build package

build war package, skip tests

```bash
mvn clean package -Dmaven.test.skip=true
```

## deploy

package and upload `.war` file to SCP

start with VM parameter

```text
-Dspring.profiles.active=neo
```

## sentry log

if you want run application with sentry, just enable `sentry` profile in environment, and edit the `DSN` link in `sentry.property`

## other

In simple terms, only need to exclude *sf4j* lib, application could run correctly on SCP.
