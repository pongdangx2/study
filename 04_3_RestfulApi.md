# Rest API란?

### Rest란?

**RE**presentational **S**tate **T**ransfer 의 약자
<br>

REST : 분산 파이퍼 미디어 시스템을 위한 아키텍처 스타일 (제약조건들의 집합)

<br>

### Rest의 구성요소
1. Resource - URI
2. 행위 - HTTP Method
3. 표현 (Representation)

<br>

<hr>

# Rest를 구성하는 제약조건

## 1. **Uniform Interface (유니폼 인터페이스)**
Uniform Interface는 URI로 지정한 리소스에 대한 조작을 통일된 인터페이스로 수행하는 아키텍처 스타일
<br>

## 2. Stateless (무상태성)
작업을 위한 상태정보를 따로 저장하고 관리하지 않음
<br>

## 3. Cacheable 
HTTP프로토콜 표준의 캐싱 구현이 가능
<br>

## 4. Client-Server 구조
클리이언트 - 서버 구조
<br>

## 5. 계층형 구조
REST서버는 다중 계층으로 구성 가능
<br>
<br>

<hr>

# Uniform Interface 제약조건

1. identification of resources (URI로 정보의 자원을 식별)
2. manipulation of resource through representations (HTTP Method를 통해 자원에 대한 행위 표현)
3. Self-descriptive messages
4. Hypermedia As The Engine Of Application State (HATEOAS)

`일반적으로 1, 2번을 지키도록 신경쓴다.`

<br>

### Self-descriptive message

`메시지는 스스로를 설명해야한다`

### Hypermedia As The Engine Of Application State

`애플리케이션의 상태는 Hyperlink를 통해 전이되어야 한다`

<br>

<hr>

* 참고 자료

`https://www.youtube.com/watch?v=RP_f5dMoHFc&t=214s`

<hr>