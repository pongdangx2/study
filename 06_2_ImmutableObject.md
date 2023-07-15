# Immutable Object

## Immutable Object(불변객체)란?

* 객체 생성 이후 내부의 상태가 변하지 않는 객체
* Read-only 메서드만 제공한다. 

<br>

<hr>

## Immutable object를 써야하는 이유

1. thread-safe하여, 병렬 프로그래밍 시 동기화를 고려하지 않아도 된다.
2. Failure Atomic 메서드를 만들 수 있다.

> 불변객체는 메서드 처리 도중 예외가 발생해도 메서드 호출 전과 같은 상태를 유지할 수 있다.

3. Map의 Key와 Set의 요소로 사용하기 좋다. (내부상태가 변경되지 않기 때문에)
4. 한번 메모리에 할당하면 같은 객체를 계속 호출해도, 새롭게 할당하지 않으므로 GC의 성능을 높힐 수 있다.


<br>

<hr>

## Immutable object 만들기

1. Setter메서드를 사용하지 않기
2. 모든 필드를 private final 키워드로 만들기
3. 클래스를 final로 선언하여 Overriding을 막기
4. 객체 생성을 위한 생성자 혹은 정적 팩토리 메서드 추가하기
5. 인스턴스 필드에 가변객체가 포함된다면 방어적 복사를 이용해 전달하기

<br>

<hr>

## Immutable Object 만들기

```
// 객체를 final로 선언하기
public final class Person {

    // 모든 필드를 private fianl 키워드로 만들기
    private final String name;
    private final Date birthday;
    private final String address;

    private Persion(String name, Date birthday, String address){
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    // 정적 팩토리메서드 추가하기
    public static Person createPersonWith(String name, Date birthday, String address){
        return new Person(name, birthday, address);
    }

    public String getName(){
        return name;
    }

    // 인스턴스 필드에 가변객체가 포함된다면 방어적 복사를 이용해 전달하기
    public Date getBirthday(){
        return new Date(birthday.getTime());
    }

    public String getAddress(){
        return address;
    }

}
```

<br>

<hr>