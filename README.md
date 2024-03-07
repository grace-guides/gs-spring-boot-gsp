# Spring Boot with GSP

This guide show you how to use GSP as view templates with Spring Boot.

## Grace Version

- Grace Framework **2022.2.0**

## Usage

### Add dependency `grace-plugin-gsp`

Adding `grace-plugin-gsp` plugin to the `build.gradle`,

```gradle
dependencies {
	implementation "org.graceframework:grace-boot"
	implementation "org.graceframework:grace-core"
	implementation "org.graceframework:grace-plugin-core"
	implementation "org.graceframework:grace-plugin-i18n"
	implementation "org.graceframework:grace-plugin-gsp", {
		exclude module: 'grace-plugin-url-mappings'
	}
	implementation "org.graceframework:grace-web-url-mappings"
}

```

### Using GSP template


```html
<!DOCTYPE HTML>
<html>
<head>
    <title>Spring Boot with GSP</title>
    <meta name="layout" content="main"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    Hello, <b>${name}</b>
</body>
</html>
```

### Running app

```bash
./gradlew bootRun
```

then open your browser, `http://localhost:8080`

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Guides](https://github.com/grace-guides)
- [Grace GSP with Spring Boot](https://github.com/grace-guides/gs-spring-boot-gsp)
