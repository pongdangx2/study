# Java Record

## Java record란?

* Java에서 제공하는 데이터를 보관하기 위해 만든 특수한 종류의 클래스
* Java 14버전에서 도입되고, 16버전에서 정식 스펙으로 채택
* RequiredAllArgument 생성자, getter, equals, hashCode, toString을 자동으로 생성
* 모든 필드는 private final로 생성하기 때문에 Immutable하게 데이터를 관리할 수 있음.

<br>

<hr>

## Record 만들어보기

```
// SampleRecord.java

public record SampleRecord(String name, int age){}
```

### Json serialize

* @JsonProperty 애노테이션을 붙인다.

```
// SampleRecord2.java

public record SampleRecord2(
    @JsonProperty("name") String name,
    @JsonProperty("age") int age
){}
```

## 추가 기능

* record 에는 static 변수만 들어갈 수 있다.
* 생성자를 만들어 다른 로직을 수행할 수 있다.

```
// KoreanRecord.java

public record KoreanRecord(String name, String age){
    static String NATIONALITY = "Korea";

    public KoreanRecord {
        if(name == null || age == null)
            throw new IllegalStateException();
        name = name + "씨";
        String = age + "살";
    }

    public static String getCountry(){
        return NATIONALITY;
    }
}
```

<br>

<hr>
