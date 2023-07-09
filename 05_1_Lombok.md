# Lombok이란?

### Lombok이란?

* java 에서 반복되는 메서드들을 Annotation기반으로 자동 작성해주는 라이브러리.
* Getter, Setter, 생성자 등을 만들때 유용하다.

<br>

<hr>

# Getter, Setter

### 클래스 단위 생성

클래스 선언부 위에 `@Getter, @Setter` 애노테이션 추가

```
import lombok.Getter;
import lombok.Setter;

// key, value 변수의 getter, setter가 생성된다.
@Getter
@Setter
public class TestVO {
    private String key;
    private String value;
}
```

### 변수 단위 생성

클래스 내 변수 선언부 위에 `@Getter, @Setter` 애노테이션 추가

```
import lombok.Getter;
import lombok.Setter;

// key, value 변수의 getter 생성
@Getter
public clase TestVO {
    private String key;

    // value 변수의 Setter 생성
    @Setter
    private String value;
}
```

<br>

<hr>

# Null 체크

* `@NonNull` 애노테이션을 변수,메서드나 생성자의 매개변수 사용하면 null check를 해준다.
* null이 들어오면 NullPointerException을 일으킨다.

### 1. 변수

```
@Getter, @Setter
public class TestVO {

    private String key;

    @NonNull
    private String value;
}


TestVO testVO = new TestVO();
testVO.setValue(null); // NullPointerException 발생

```

### 2. 메서드나 생성자의 매개변수

```
public class Test {

    private String value;

    public String concatValue(@NonNull String str) {
        return value + str;
    }
}
```

<br>

<hr>

# @ToString
클래스 이름과 각 필드의 값을 출력하는 toString 메서드를 만들어준다.

```
@ToString
public class TestVO {
    @ToString.Exclude
    private String key;

    priavet String value;
}
```

<br>

<hr>

# 생성자

### 매개변수가 없는 생성자

* `@NoArgsConstructor` 애노테이션을 달면 매개변수가 없는 기본 생성자를 생성한다.
* final 필드 등의 이유로 생성이 불가능할 시 컴파일 에러가 발생한다.
* `@NoArgsConstructor(force=true)` 로 final 필드는 기본값ㅇ ㄹ 0, false, null로 초기화할 수 있다.

### 필수 변수를 포함하는 생성자

* final 변수, @NonNull 변수에 대한 생성자를 생성해준다.

```
@Getter
@RequiredArgsConstructor
public class TestVO {

    @NonNull
    private String key;

    private final String value;

    private int num;

    /*
    // 다음과 같은 생성자가 생성된다.
    public TestVO(String key, String value){
        this.key = key;
        this.value = value;
    }
    */
}
```

### 모든 변수를 포함하는 생성자

* `@AllArgsConstructor`를 붙이면 모든 인스턴스변수를 매개변수로 받는 생성자를 만들어준다.

<br>

<hr>

# Builder

* `@Builder` 애노테이션을 붙이면 Builder를 만들어준다.
* 클래스에 붙이면 모든 인스턴스변수를 대상으로 만들어준다.
* 붙이고자 하는 인스턴스변수를 가지는 생성자를 만들고 거기에 붙이면 그 변수들을 대상으로만 만들어준다.

```
@Getter
@Setter
public class TestVO {
    private String key;
    private String value;
    private int num;

    @Builder
    public TestVO(String key, String value) {
        this.key = key;
        this.value = value;
    }
}


// =============================================
TestVO testVO = TestVO.builder().key("one").value("1").build();
```

<hr>
