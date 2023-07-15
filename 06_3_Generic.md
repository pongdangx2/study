# Generic

## Generic이란?

* 타입에 의존하지 않고, 여러 데이터 타입을 가질 수 있도록 하는 방법
* Primitive 타입은 올 수 없으며, Reference 타입만 올 수 있다.

<br>

<hr>

## Generic 만들기

### Generic Type 표
|타입|설명|
|---|---|
|`<T>` |Type|
|`<E>`|Element|
|`<K>`|Key|
|`<V>`|Value|
|`<N>`|Number|

<br>

### 선언

```
public class ClassName <T> { ... }
public interface InterfaceName <T> { ... }

public class LkhMap <K, V> {
    ...
}
```

<hr>