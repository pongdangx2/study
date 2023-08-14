# Custom Annotaion

## Annotaion이란?

* Java 5부터 추가된 기능
* 클래스나 메소드 위에 붙여서 사용 -ex. @Override
* 소스코드에 메타코드(추가정보)를 주는 것

<br>

<hr>

## Custom annotaion

* @interface 키워드로 생성
* 기본적인 구조

```
@Target({ElementType.[적용대상]})
@Retention(RetentionPolicy.[정보유지되는 대상])
public @interface [어노테이션명]{
    public 타입 elementName() [default 값]
    ...
}
```

### 메타 애노테이션의 종류

* `@Retention` : 어느시점까지 영향을 미치는지 결정 (컴파일러가 애노테이션을 다루는 방법 기술)
> 1. RetentionPolicy.SOURCE : 컴파일 전까지 유효
> 1. RetentionPolicy.CLASS : 컴파일러가 클래스를 참조하는 동안 유효
> 1. RetentionPolicy.RUNTIME : 컴파일 이후 런타임 시기에도 JVM에 의해 참조 가능(리플렉션)

* `@Target` : 애노테이션을 적용할 위치 선택
> 1. ElementType.PACKAGE : 패키지 선언
> 1. ElementType.TYPE : 타입 선언
> 1. ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
> 1. ElementType.CONSTRUCTOR : 생성자 선언
> 1. ElementType.FIELD : 멤버 변수 선언
> 1. ElementType.LOCAL_VARIABLE : 지역 변수 선언
> 1. ElementType.METHOD : 메서드 선언
> 1. ElementType.PARAMETER : 전달인자 선언
> 1. ElementType.TYPE_PARAMETER : 전달인자 타입 선언
> 1. ElementType.TYPE_USE : 타입 선언

* `@Documented` : 애노테이션을 Javadoc에 포함
* `@Inherited` : 애노테이션의 상속 가능

### 예시

* Annotion 정의

```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface TestAnnotaion {
  public String value() default "test";
}
```

* Annotation 사용

```
@TestAnnotaion(value = "test value")
public class Test {
    ...
}
```

* Annotation 활용

```
public class TestClass {
    public static void main(String[] args){
        Annotation[] annotaions = Test.class.getDeclaredAnnotations();
        for(Annotation annotaion : annotations){
            TestAnnotaion testAnnotaion = (TestAnnotaion) annotaion;
            System.out.println(testAnnotaion.value()); // test value 출력
        }
    }
}
```
