# OAuth

`출처: https://opentutorials.org/course/3405`

## OAuth란?

- 구글, 카카오톡 등 다양한 플랫폼의 사용자 데이터에 접근하기위해 제3의 애플리케이션이 사용자의 접근 권한을 위임 받을 수 있는 표준 프로토콜
- 다음과 같이 다른 서비스로 로그인하는 기능 개발을 위해 필수
<img src=./resource/09_1_OAuthLogin.png>

<br>

## OAuth의 주체

#### Resource Server

- 자원을 가지고 있는 서버
- 데이터를 가지고 있는 서버 (구글, 카카오톡 등)

#### Authorization Server

- 인증과 관련된 처리를 전담하는 서버

#### Resource Owner

- 자원의 소유자
- 서비스를 사용하고자 하는 사용자

#### Client

- Resource Server로부터 데이터를 가져가는 Client
- 제3의 애플리케이션

<br>

<hr>

## OAuth의 절차

### 1. 등록

- Client가 사전에 Resource Server에 등록하고 승인받는 절차
- 3가지 필수 요소

|No|요소|설명|
|---|---|---|
|1|Client ID|우리가 만들고 있는 애플리케이션을 식별하는 식별자|
|2|Client Secret|Client ID에 대한 비밀번호 - `절대로 외부에 유출되면 안됨`|
|3|Authorized redirect URIs|인증 후 Authorization code를 받기위한 URI|

<br>

### 2. Resource Owner의 승인

1. 로그인버튼을 누르면 `https://ResourceServerURI?client_id=1&redirect_uri=~~~&scope=!!!!` 형태의 URL로 링크

|항목|설명|
|---|---|
|client_id|우리가 만들고 있는 애플리케이션의 식별자|
|scope|애플리케이션에서 사용할 기능들 (ResourceServer에서 정의한 형식대로)|
|redirect_uri|code를 응답받을 URI|

2. Resource Server는 이미 로그인 되어있는지 확인 후 로그인되어있지 않으면 로그인 화면으로 연결.
   <br> 이후 다음 작업 수행

> 1. 로그인에 성공하면, client_id와 같은 client_id가 있는지 확인
> 2. redirect_uri와 등록된 redirect URIs가 같은지 확인
> 3. scope에 해당하는 권한을 client에게 부여할지 확인하는 화면을 Resource Owner에게 보여줌
> 4. Resource Owner의 유저ID 와 scope정보 저장

<img src=./resource/09_2_OAuth_ResourceOwnser.png>

<br>

### 3. Resource Server의 승인

* 승인이 되면 `Location : https://redirectURI?code=~~~`형태로 code를 Resource Owner에게 응답
* Locations 헤더를 통해 Redirect

<img src=./resource/09_3_OAuth_redirect.png>

* 이 과정을 거치면 client는 client id, client secret, Authorization code 를 알고 있음.
* 그 뒤, 다음과 같이 세가지 정보를 Resource Server에 전달.

<img src=./resource/09_4_OAuth_code.png>


<br>

### 4. Access Token 발행

* Resource Server는 Client Id, Client Secret, Redirect URI, Code 정보가 모두 일치하는 지 확인
* Access Token 발행 후 Client 에게 응답
* Client는 Access Token을 저장

<br>

<hr>

## Refresh Token

Access Token은 유지시간이 짧기 때문에, 쉽게 Access Token을 다시 받을 수 있는 Refresh Token이 있음.

<img src=./resource/09_5_RefreshToken.png>

`출처: https://datatracker.ietf.org/doc/html/rfc6749#section-1.6`
