# ☕🎯 Hexagonal Architecture + DDD + CQRS Java example with SpringBoot

<img src="http://codely.tv/wp-content/uploads/2016/05/cropped-logo-codelyTV.png" align="left" width="192px" height="192px"/>
<img align="left" width="0" height="192px" hspace="10"/>

> You can do awesome stuff with Java 🙂

[![CodelyTV](https://img.shields.io/badge/codely-tv-green.svg?style=flat-square)](https://codely.tv)
[![Build Status](https://travis-ci.org/CodelyTV/cqrs-ddd-java-example.svg?branch=master)](https://travis-ci.org/CodelyTV/cqrs-ddd-java-example)

Implementation example of a Java application following Domain-Driven Design (DDD) and Command Query Responsibility Segregation (CQRS) principles, keeping the code as simple as possible.

Take a look, play and have fun with it!

## 🚀 Environment setup

1. Install Java: `brew cask install java`
2. Clone this repository: `git clone https://github.com/CodelyTV/cqrs-ddd-java-example`
3. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar) and other project artifacts:
    `./gradlew assemble --warning-mode all`
    2. Run the tests and plugins verification tasks:
    `./gradlew check --warning-mode all`
    3. Execute the main application entrypoint:
    `./gradlew run --warning-mode all`
4. Start developing!

## 🤔 How to update dependencies

* Gradle (current version: 5.1.1 - [releases](https://gradle.org/releases/)):
`./gradlew wrapper --gradle-version=5.1.1 --distribution-type=bin` or modifying the [gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties#L3)
* JUnit (current version: 5.3.2 - [releases](https://junit.org/junit5/docs/snapshot/release-notes/index.html)):
[`build.gradle:11`](build.gradle#L11-L12)

## 🤝 Contributing

There are a lot of missing things (add swagger/OpenAPI, improve documentation...), feel free to add them if you want!
