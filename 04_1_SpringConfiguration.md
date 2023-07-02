# Spring Configuration

스프링에서 Bean을 등록하는 방법

<br>

<hr>

# XML을 이용한 설정 

resource 디렉터리 아래에 application.xml 파일을 생성하여 이곳에 빈 정보를 입력하는 방법

```
<?xml version="1.0" encoding="UTF-8" ?>
<beans>

  <bean id="TestController"
        class="me.lkh.TestController">
    <property name="testService"
              ref="TestService"/>
  </bean>

  <bean id="TestService"
        class="me.lkh..TestService">
  </bean>

</beans>
```

* `<bean>` : 등록할 빈의 정보
* `id 속성` : Bean의 이름
* `class 속성` : Bean으로 등록할 클래스의 경로
* `<property>` : 주입할 의존성의 정보
* `name 속성` : 주입할 변수 명
* `ref 속성` : 주입할 빈의 이름

<br>

<hr>

# Java를 이용한 설정

java에서 등록할 빈의 정보를 직접 입력하는 방법

<br>
클래스를 생성하고, @Configuration 애노테이션을 달면 그 클래스가 설정파일이 된다.
<br>

그 후 @Bean 애노테이션을 메소드에 달아 등록할 빈을 표시한다. 이때, `메소드의 이름`이 `빈의 이름`이 된다.

```
@Configuration
public class ApplicationConfig {

  @Bean
  public TestController testController(TestService testService) {
    return new TestController(testService);  // 의존성 주입
  }
  
  @Bean
  public TestService testService() {
    return new TestService();
  }
  
}
```

