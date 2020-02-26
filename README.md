# SAP SCP Spring Boot demo

Just a spring boot application could run on the SAP cloud platform

## development

clone and import project as maven project, run as web application in SAP tomcat 8 (default).

entry is `/rest`, with spring data rest APIs, swagger-ui.html will enable in `http://localhost:9999/swagger-ui.html`

before run locally, pls enable maven `h2` and `log` profile in IDE.

default user is `admin/password`, project disabled csrf token & set option frame as same origin.

**PLEASE REMEMBER** enable spring profile `-Dspring.profiles.active=dev` to use local embedded h2 db in project directory

* h2 db management `http://localhost:9999/h2-console`, jdbc url: `jdbc:h2:file:./local;DB_CLOSE_ON_EXIT=FALSE`
* login path `http://localhost:9999/login`
* swagger ui `http://localhost:9999/swagger-ui.html`
* simple api `localhost:9999/api/v1/available`

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

if you want run application with sentry, just enable `sentry` profile in environment, and 

## Profiles

### spring profiles 

enable by `-Dspring.profiles.active=p1,p2`

* security - enable spring security with user/role and basic auth
* sentry - enable sentry log platform, edit the `DSN` link in `sentry.property`
* neo - enable neo platform features (key store/HANA Connection)
* cors_all - enable cors for all requests

### maven profile 

* h2 - embedded database for local development
* log - slf4j api for standalone deployment 

