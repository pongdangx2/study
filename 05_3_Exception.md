# Java Exception
<img src=./resource/05_1_JavaException.png>

**출처:http://www.tcpschool.com/java/java_exception_class**

<br>

<hr>

# Error vs Exception

### Error

* JVM에 의해 처리되는 치명적인 오류
* try - catch로 처리가 불가능하다.
* ex - OutOfMemoryError

### Exception

* 프로그램에서 처리하는 비교적 가벼운 오류
* ex - RuntimeException

<br>

<hr>

# Checked Exception vs. UnChecked Exception

* `RuntimeException`과 `RuntimeException의 서브클래스`는 Unchecked Exception
* 나머지는 Checked Exception

<br>

| |CheckedException|UncheckedException|
|---|---|---|
|처리여부|반드시 예외처리 필요|명시적 처리 필수 X|
|확인시점|컴파일 단계 | 실행 중 단계|
|대표 예외| IOException,ClassNotFoundException| NullPointerException, IndexOutOfBoundException|
<hr>