# Component Scan
### Component Scan이란?

* `@Controller, @Service, @Component, @Repository`애노테이션이 달려 있는 클래스들을 찾아 빈으로 등록해주는 것
* 기본적으로 component scan 할 때 `@Component` 애노테이션이 달린 클래스를 찾는데, <br>
`@Controller, @Service, @Repository` 애노테이션은 @Component 애노테이션을 포함하고 있어서 Component scan의 대상이 된다.

<br>

<hr>

# XML 파일에서 설정
### xml 파일에서 설정하는 법

<br>

resource 밑에 application.xml 파일을 만들고, <br>
`<context:component-scan base-package="me.lkh.test"/>`
<br>
위와 같은 태그를 추가한다. 이 때, base-package를 포함하여 하위 패키지들을 모두 스캔한다.


<br>

<hr>

# Java 파일에서 설정

Java 설정파일 (`@Configuration` 애노테이션이 달린 클래스)에 `@ComponentScan`애노테이션을 추가한다.

```
@Configuration
@ComponentScan(basePackages = "me.lkh.test")
public class ApplicationConfig {
}
```

이 때, basePackages에 있는 패키지를 포함하여 하위 패키지들을 모두 스캔한다. 

<br>
<hr>

# Spring Boot에서의 Component Scan

* Spring Boot 프로젝트를 처음 생성하면 만들어지는 클래스에 `@SpringBootApplication` 애노테이션이 달려있다.
* `@SpringBootApplication` 애노테이션이 달린 클래스가 있는 곳이 **base package**가 된다. 
* 다음과 같이 SpringBootApplication 애노테이션에는 ComponentScan 애노테이션이 포함되어 있다. 
```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
    ... 생략
```

<br>
<hr>