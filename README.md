# SAP HCP Spring Boot demo

Just an spring boot application could run on the SAP cloud platform

## development

### neo

clone and import project as maven project, run as web application in SAP tomcat 8 (default).

entry is `/rest`, with spring data rest APIs

run as web application `h2` maven profile in IDE

### cloud foundry

run as application with `h2,log` maven profile in IDE

## build package

build war package

```bash
# for neo
mvn clean package
# for cf
mvn clean package -Plog
```

## deploy

### neo

package and upload `.war` file to SCP

start with VM parameter

```text
-Dspring.profiles.active=neo-production
```

### cloud foundry

run **cf create-service postgresql  v9.4-dev psql** to create `psql` instance before first push

`cf` command is provided by [cf cli](https://github.com/cloudfoundry/cli)

just use `cf push` command to deploy

please note the **path** defined in `manifest.yml`.

## other

In simple terms, only need to exclude *sf4j* lib, application could run correctly on SCP.
