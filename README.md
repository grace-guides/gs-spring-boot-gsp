[![Main branch build status](https://github.com/grace-guides/gs-spring-boot-gorm/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-spring-boot-gorm/actions?query=workflow%3A%Grace+CI%22)

# Spring Boot with GSP

This guide show you how to use GSP as view templates with Spring Boot.

## Grace Version

- Grace Framework **2023.0.0-M7**

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

Grace will only load 3 plugins that are dependent on `gsp`,

```bash
----------------------------------------------------------------------------------------------
Order      Plugin Name                              Plugin Version                     Enabled
----------------------------------------------------------------------------------------------
    1      Core                                     2023.0.0-M5                              Y
    2      I18n                                     2023.0.0-M5                              Y
    3      Codecs                                   2023.0.0-M5                              Y
    4      GroovyPages                              2023.0.0-M5                              Y
----------------------------------------------------------------------------------------------
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

then open your browser, `http://localhost:8080/greeting`

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Spring Boot with GORM](https://github.com/grace-guides/gs-spring-boot-gorm)
