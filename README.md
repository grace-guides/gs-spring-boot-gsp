[![Main branch build status](https://github.com/grace-guides/gs-spring-boot-gsp/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-spring-boot-gsp/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://twitter.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-4.0.24-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-4.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2023.1.0-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2023.1.0)
[![Spring Boot Version](https://img.shields.io/badge/Spring_Boot-3.3.5-blue?style=flat&color=6db33f)](https://github.com/spring-projects/spring-boot/releases/tag/v3.3.5)


# Spring Boot with GSP

This guide show you how to use GSP as view templates with Spring Boot.

## Grace Version

- Grace Framework **2023.1.0-RC1**

## Usage

### Add dependency `grace-plugin-gsp`

Adding `grace-plugin-gsp` plugin to the `build.gradle`,

```gradle
dependencies {
	implementation 'org.graceframework:grace-boot'
	implementation 'org.graceframework:grace-plugin-core'
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

 :: Spring Boot ::                (v3.3.5)

2024-11-21T14:38:14.752+08:00  INFO 32708 --- [  restartedMain] grace.guides.GraceBootApplication        : Starting GraceBootApplication using Java 17.0.12 with PID 32708 (/Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp/build/classes/groovy/main started by rain in /Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp)
2024-11-21T14:38:14.753+08:00  INFO 32708 --- [  restartedMain] grace.guides.GraceBootApplication        : No active profile set, falling back to 1 default profile: "default"
2024-11-21T14:38:14.772+08:00  INFO 32708 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-11-21T14:38:14.772+08:00  INFO 32708 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-11-21T14:38:15.178+08:00  INFO 32708 --- [  restartedMain] g.plugins.DefaultGrailsPluginManager     : Total 3 plugins loaded successfully, take in 41 ms
2024-11-21T14:38:15.411+08:00  INFO 32708 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-11-21T14:38:15.417+08:00  INFO 32708 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-11-21T14:38:15.417+08:00  INFO 32708 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.33]
2024-11-21T14:38:15.439+08:00  INFO 32708 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-11-21T14:38:15.439+08:00  INFO 32708 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 667 ms
2024-11-21T14:38:15.807+08:00  INFO 32708 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-11-21T14:38:15.813+08:00  INFO 32708 --- [  restartedMain] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2024-11-21T14:38:15.928+08:00  INFO 32708 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-11-21T14:38:15.956+08:00  INFO 32708 --- [  restartedMain] grace.guides.GraceBootApplication        : Started GraceBootApplication in 1.33 seconds (process running for 1.668)
2024-11-21T14:38:15.966+08:00 DEBUG 32708 --- [  restartedMain] PluginsInfoApplicationContextInitializer :
----------------------------------------------------------------------------------------------
Order      Plugin Name                              Plugin Version                     Enabled
----------------------------------------------------------------------------------------------
    1      Core                                     2023.1.0                                 Y
    2      Codecs                                   2023.1.0                                 Y
    3      GroovyPages                              2023.1.0                                 Y
----------------------------------------------------------------------------------------------

2024-11-21T14:38:48.141+08:00  INFO 32708 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-11-21T14:38:48.141+08:00  INFO 32708 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-11-21T14:38:48.142+08:00  INFO 32708 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```

then open your browser, `http://localhost:8080/greeting`

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Spring Boot with GORM](https://github.com/grace-guides/gs-spring-boot-gorm)
