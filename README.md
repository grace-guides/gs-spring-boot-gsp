[![Main branch build status](https://github.com/grace-guides/gs-spring-boot-gsp/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-spring-boot-gsp/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://twitter.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-4.0.33-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-4.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2024.1.2-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2024.1.2)
[![Spring Boot Version](https://img.shields.io/badge/Spring_Boot-3.5.16-blue?style=flat&color=6db33f)](https://github.com/spring-projects/spring-boot/releases/tag/v3.5.16)


# Spring Boot with GSP

This guide show you how to use GSP as view templates with Spring Boot.

## Versions

* Spring Boot 3.5.16
* Grace Framework 2024.1.2
* Groovy 4.0.33

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

In the following example, `GreetingController` is a Spring Controller, handles GET requests for `/greeting` by returning the name of a View (in this case, `greeting/index`).
A `View` is responsible for rendering the HTML content. The implementation of the method body relies on a view technology (in this case, `GSP`) to perform server-side rendering of the HTML. 

```groovy
@Controller
class GreetingController {

	@GetMapping("/greeting")
	String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name)
		return "greeting/index"
	}

}
```

Groovy Servers Pages (or `GSP` for short) is Grails' view technology. It is designed to be familiar for users of technologies such as ASP and JSP, but to be far more flexible and intuitive.

The following listing (from `app/views/greeting/index.gsp`) shows the `index.gsp` template:

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
    <p>Hello, <b>${name}</b> from GSP!</p>
</body>
</html>
```

All built-in GSP tags start with the prefix `g:`. Unlike JSP, you don’t specify any tag library imports. If a tag starts with `g:` it is automatically assumed to be a GSP tag. In this example (from `app/taglib/grace/guides/GreetingTagLib.groovy`) `GreetingTagLib` tag would look like:

```groovy
class GreetingTagLib {

    GrailsApplication grailsApplication

    def welcome = { args, body ->
        out << "Welcome to Grace " << grailsApplication.metadata.getGrailsVersion()
    }
}
```

A tag library is a simple Groovy class that ends with the convention `TagLib` and place it within the `app/taglib` directory.

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

 :: Spring Boot ::               (v3.5.16)

2026-08-30T23:46:37.119+08:00  INFO 86918 --- [  restartedMain] grace.guides.GraceBootApplication        : Starting GraceBootApplication using Java 17.0.20 with PID 86918 (/Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp/build/classes/groovy/main started by rain in /Users/rain/Development/github/grace/grace-guides/gs-spring-boot-gsp)
2026-08-30T23:46:37.120+08:00  INFO 86918 --- [  restartedMain] grace.guides.GraceBootApplication        : No active profile set, falling back to 1 default profile: "default"
2026-08-30T23:46:37.138+08:00  INFO 86918 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2026-08-30T23:46:37.138+08:00  INFO 86918 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2026-08-30T23:46:37.596+08:00  INFO 86918 --- [  restartedMain] g.plugins.DefaultGrailsPluginManager     : Total 4 plugins loaded successfully, take in 69 ms
2026-08-30T23:46:37.794+08:00  INFO 86918 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2026-08-30T23:46:37.801+08:00  INFO 86918 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2026-08-30T23:46:37.801+08:00  INFO 86918 --- [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.57]
2026-08-30T23:46:37.817+08:00  INFO 86918 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2026-08-30T23:46:37.818+08:00  INFO 86918 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 679 ms
2026-08-30T23:46:38.197+08:00  INFO 86918 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2026-08-30T23:46:38.204+08:00  INFO 86918 --- [  restartedMain] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 15 endpoints beneath base path '/actuator'
2026-08-30T23:46:38.317+08:00  INFO 86918 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2026-08-30T23:46:38.345+08:00  INFO 86918 --- [  restartedMain] grace.guides.GraceBootApplication        : Started GraceBootApplication in 1.368 seconds (process running for 1.694)
2026-08-30T23:46:38.349+08:00 DEBUG 86918 --- [  restartedMain] PluginsInfoApplicationContextInitializer :
----------------------------------------------------------------------------------------------------------
Order      Plugin Name                        Plugin Version                                       Enabled
----------------------------------------------------------------------------------------------------------
    1      Core                               2024.1.2                                                   Y
    2      Codecs                             2024.1.2                                                   Y
    3      GroovyPages                        2024.1.2                                                   Y
    4      Taglibs                            2024.1.2                                                   Y
----------------------------------------------------------------------------------------------------------
```

then open your browser, `http://localhost:8080/greeting`
You will see it works!

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Spring Boot with GORM](https://github.com/grace-guides/gs-spring-boot-gorm)
