# HttpSession

## HttpSession (javax.servlet.http)

* java에서 세션(Session)을 제어하기 위해 제공하는 interface

<br>

## 주요 메서드
|Method|Description|
|---|---|
|void setAttribute(String name, Object value) | String 키로 Object를 세션에 바인딩|
|Object getAttribute(String name) | 세션에 바인딩된 Object를 리턴 (필요시 업캐스팅) |
|void removeValue(String name) | 세션에 바인딩된 Object를 제거 |
|void invalidate() | 바인딩된 모든 속성 제거 |

<br>

## 세션 생성

* HttpServletRequest (javax.servlet.http) 를 통해 생성한다.
<br>

|Method|Description|
|---|---|
|HttpSession getSession() | 현재 Request와 연관된 세션을 리턴, 없을 땐 새로 생성하여 리턴|
|httpSession getSession(boolean create) | 현재 Request와 연관된 세션을 리턴, 없을 시 create가 true일 때 새로 생성하여 리턴|

<br>

## HttpSession 사용

### 필드 주입

* `@Autowired` 애노테이션을 이용해 필드에 주입
* HttpSession 필드는 `session scope`를 가짐
* 주입이후 HttpSession 객체를 `사용할 때` Servlet Container로부터 Session을 `생성`

```
@Controller
public class TestController {
    @Autowired
    private HttpSession session;

    @GetMapping("/test")
    public String test(@requestBody String test) {
        session.setAttribute("test", "TEST");
        return "Hello world";
    }
}
```

### Method에서 주입

* 메서드의 매개변수로 주입
* 메서드가 `호출되는 즉시` Servlet Container로부터 Session `생성`

```
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(@requestBody String test, HttpSession sessio) {
        session.setAttribute("test", "TEST");
        return "Hello world";
    }
}
```


