# Spring Exception Handler

## SpringBoot의 에러처리

* SpringBoot 에는 기본적으로 에러 처리를 위한 `BasicErrorController`가 구현되어 있다.
* error의 기본 경로는 `/error`로 되어어있으며, Properties에 `server.error.path`로 설정할 수 있다.

<br>

<hr>

# 스프링부트의 예외 처리 방식

## 예외처리를 위한 클래스 지정

* `@ControllerAdvice, @RestControllerAdvice`애노테이션을 사용하면 된다.
* 컴포넌트스캔을 할때 처럼 범위 지정도 가능하다
```
@ControllerAdvice(basePackages="me.lkh.test")
```
* 결과를 JSON형태로 반환할 때 `@RestControllerAdvice`를 사용한다.<br>
즉, 다음과 같이 @ControllerAdvice에 @ResponseBody 애노테이션을 붙이면 @RestControllerAdvice가 된다. 

```
// RestControllerAdvice
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ControllerAdvice
@ResponseBody
public @interface RestControllerAdvice {

// @ControllerAdvice
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ControllerAdvice {
```

<br>

## 예외를 처리하는 방법

* `@ExceptionHandler` : 특정 예외 발생 시 이 Handler로 처리하겠다고 명시하는 역할을 한다.
* 다음과 같이 애노테이션 뒤에 () 를 붙여 Exception을 특정할 수 있다.
```
@ExceptionHandler(NoSuchAlgorithmException.class)
```

<br>

## ExceptionHandler 지정의 우선순위

1. 더 하위 클래스를 처리하는 Handler의 우선순위가 높다.

> @ExceptionHandler(Exception.class) < @ExceptionHandler(NullPointerException.class)

2. `@ControllerAdvice, @RestControllerAdvice`를 사용해 전역적으로 설정한 ExceptionHandler보다 `Controller`내에 지역적으로 정의한 ExceptionHandler가 우선순위를 가진다.

<br>

## **모든** Controller에서 발생하는 예외를 처리하는 예시

* @ControllerAdvice/@RestControllerAdvice + @ExceptionHandler 조합으로 처리한다.

```
@RestControllerAdvice
public class LkhExceptionHandler {
    
    @ExceptionHandler(value=NullPointerException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(NullPointerException e){
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> body = new HashMap<>();
        map.put("error type", httpStatus.getResonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");
    
        return ResponseEntity.status(httpStatus).body(body);
    }
}
```

<br>

## **특정** Controller에서 발생하는 예외를 처리하는 예시

* 컨트롤러 내에 @ExceptionHandler를 달아서 처리한다.

```
@Controller
public class LkhController {
    @RequestMapping("/test")
    public void test() throws Exception {
        // ... (Exception 발생)
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> body = new HashMap<>();
        map.put("error type", httpStatus.getResonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");
    
        return ResponseEntity.status(httpStatus).body(body);
    } 
}
```

<hr>
