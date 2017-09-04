# SAP HCP Spring Boot demo

Just an spring boot application could run on sap cloud platform

## usage

clone and import project as maven project, run as web application in SAP jvm8 (default).

entry is `/rest`, with spring data rest APIs

> run as application with `dev` maven profile in IDE

## build

build with `production` profile in maven

```bash
mvn clean package -Pproduction
```

## deploy

### neo

package and upload `.war` file to SCP

start with VM parameter

```text
-Dspring.profiles.active=production
```

### cloud foundry

with cloud foundry, just use `cf push` command to deploy is ok

please note the **path** defined in `manifest.yml` 

## other

In simple terms, only need to exclude sf4j lib, application could run correctly on SCP.
