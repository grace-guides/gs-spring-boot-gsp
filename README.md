[![Main branch build status](https://github.com/grace-guides/gs-spring-boot-gorm/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-spring-boot-gorm/actions?query=workflow%3A%Grace+CI%22)

# Spring Boot with GSP

This guide show you how to use GSP as view templates with Spring Boot.

## Grace Version

- Grace Framework **2023.0.0**

## Usage

### Add dependency `grace-plugin-gsp`

Adding `grace-plugin-gsp` plugin to the `build.gradle`,

```gradle
dependencies {
	implementation 'org.graceframework:grace-boot'
	implementation 'org.graceframework:grace-core'
	implementation 'org.graceframework:grace-plugin-core'
	implementation 'org.graceframework:grace-plugin-i18n'
	implementation 'org.graceframework:grace-plugin-gsp'
}
```

### Using GSP and Tags

Creating a Tag in `app/taglib`,

```groovy
class GreetingTagLib {

    GrailsApplication grailsApplication

    def welcome = { args, body ->
        out << "Welcome to Grace " << grailsApplication.metadata.getGrailsVersion()
    }
}
```

Now we can use this tag in the GSP `app/views/greeting/index.gsp`,

```html
<!DOCTYPE HTML>
<html>
<head>
    <title>Spring Boot with GSP</title>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <h1><g:welcome/></h1>
    Hello, <b>${name}</b>
</body>
</html>
```

### Running app

```bash
./gradlew bootRun
```

```bash
gs-spring-boot-gsp  ./gradlew bootRun

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.2)

2024-08-21T20:55:45.457+08:00  INFO 97713 --- [  restartedMain] grace.guides.GraceBootApplication        : Starting GraceBootApplication using Java 17.0.12 with PID 97713 (/Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp/build/classes/groovy/main started by rain in /Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp)
2024-08-21T20:55:45.458+08:00  INFO 97713 --- [  restartedMain] grace.guides.GraceBootApplication        : No active profile set, falling back to 1 default profile: "default"
2024-08-21T20:55:45.476+08:00  INFO 97713 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-08-21T20:55:45.477+08:00  INFO 97713 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-08-21T20:55:45.870+08:00  INFO 97713 --- [  restartedMain] g.plugins.DefaultGrailsPluginManager     : Total 4 plugins loaded successfully, take in 48 ms
2024-08-21T20:55:46.145+08:00  INFO 97713 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-08-21T20:55:46.151+08:00  INFO 97713 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-08-21T20:55:46.151+08:00  INFO 97713 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.28]
2024-08-21T20:55:46.169+08:00  INFO 97713 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-08-21T20:55:46.170+08:00  INFO 97713 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 692 ms
2024-08-21T20:55:46.512+08:00  INFO 97713 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-08-21T20:55:46.515+08:00  INFO 97713 --- [  restartedMain] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2024-08-21T20:55:46.625+08:00  INFO 97713 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-08-21T20:55:46.657+08:00  INFO 97713 --- [  restartedMain] grace.guides.GraceBootApplication        : Started GraceBootApplication in 1.328 seconds (process running for 1.64)
2024-08-21T20:55:46.666+08:00 DEBUG 97713 --- [  restartedMain] PluginsInfoApplicationContextInitializer :
----------------------------------------------------------------------------------------------
Order      Plugin Name                              Plugin Version                     Enabled
----------------------------------------------------------------------------------------------
    1      Core                                     2023.0.0                                 Y
    2      I18n                                     2023.0.0                                 Y
    3      Codecs                                   2023.0.0                                 Y
    4      GroovyPages                              2023.0.0                                 Y
----------------------------------------------------------------------------------------------
```

then open your browser, `http://localhost:8080/greeting`

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Spring Boot with GORM](https://github.com/grace-guides/gs-spring-boot-gorm)
