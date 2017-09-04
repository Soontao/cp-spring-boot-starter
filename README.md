# SAP HCP Spring Boot demo

Just an spring boot application could run on the SAP cloud platform

## usage

### neo

clone and import project as maven project, run as web application in SAP jvm8 (default).

entry is `/rest`, with spring data rest APIs

### cloud foundry

> run as application with `dev,standalone` maven profile in IDE

![](https://res.cloudinary.com/digf90pwi/image/upload/v1504528297/2017-09-04_20-28-17_tafrnh.gif)

## build

build with `production` profile in maven

```bash
# with neo
mvn clean package
# with cf
mvn clean package -Pstandalone
```

## deploy

### neo

package and upload `.war` file to SCP

start with VM parameter

```text
-Dspring.profiles.active=neo-production
```

### cloud foundry

run "cf create-service hanatrial hdi-shared hana" to create service instance before first push

with cloud foundry, just use `cf push` command to deploy

please note the **path** defined in `manifest.yml`

## other

In simple terms, only need to exclude sf4j lib, application could run correctly on SCP.
