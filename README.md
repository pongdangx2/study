# Lezhin 기술과제 (이경훈)

## DB 접속 정보

|Host|Port|DB|user|password|
|---|---|---|---|---|
|218.232.175.4|49154|htldbp|user|P@ssw0rd

> 개인적으로 사용하고있는 DB에 테이블을 생성했으며, 테이블은 `9/27`까지 유지할 예정입니다. <br>

## DB Schema

### 1. 사용자 (user)

* 테이블명 : user

|컬럼명|타입|제약조건|설명|
|---|---|---|---|
|ID|int|Primary Key , NOT NULL, AUTO_INCREMENT|ID (PK)|
|userName|varchar(255)|NOT NULL|사용자 이름|
|userEmaili|varchar(255)|NOT NULL|사용자 이메일|
|gender|varchar(10)|NOT NULL|사용자 성별(남자, 여자)|
|type|varchar(10)|NOT NULL|유형(일반, 성인)|
|registerDate|varchar(8)|NOT NULL|서비스 등록일|

* 테이블 생성 쿼리

```
CREATE TABLE `user` (
                        `ID` int NOT NULL AUTO_INCREMENT,
                        `userName` varchar(255) NOT NULL,
                        `userEmail` varchar(255) NOT NULL,
                        `gender` varchar(10) NOT NULL,
                        `type` varchar(10) NOT NULL,
                        `registerDate` varchar(8) NOT NULL,
                        PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='레진 사용자';
```

### 2. 작품 (content)

* 테이블명 : content

|컬럼명|타입|제약조건|설명|
|---|---|---|---|
|ID|int|Primary Key , NOT NULL, AUTO_INCREMENT|ID (PK)|
|contentName|varchar(255)|NOT NULL|작품명|
|author|varchar(255)|NOT NULL|작가|
|coin|int|NOT NULL|금액 (0: 무료, 100~500: 유료)|
|adultContentYn|varchar(1)|NOT NULL, DEFAULT 'N'|성인용 작품인지 여부(Y/N)|
|openDate|varchar(8)|NOT NULL|서비스 제공일|

* 테이블 생성 쿼리

```
CREATE TABLE `content` (
                           `ID` int NOT NULL AUTO_INCREMENT,
                           `contentName` varchar(255) NOT NULL,
                           `author` varchar(255) NOT NULL,
                           `coin` int NOT NULL DEFAULT 0,
                           `adultContentYn` varchar(1) NOT NULL DEFAULT 'N',
                           `openDate` varchar(8) NOT NULL,
                           PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='레진 작품';
```

### 3. 평가 (review)

* 테이블명 : review

|컬럼명|타입|제약조건|설명|
|---|---|---|---|
|ID|int|Primary Key , NOT NULL, AUTO_INCREMENT|ID (PK)|
|userId|int|NOT NULL|사용자ID|
|contentId|int|NOT NULL|작품ID|
|isLike|varchar(1)|NOT NULL|좋아요(Y), 싫어요(N)|
|comment|varchar(255)||댓글|

* 테이블 생성 쿼리

```
CREATE TABLE `review` (
                          `ID` int NOT NULL AUTO_INCREMENT,
                          `userId` int NOT NULL,
                          `contentId` int NOT NULL,
                          `isLike` varchar(1) NOT NULL,
                          `comment` varchar(255),
                          PRIMARY KEY (`ID`),
                          CONSTRAINT `review_fk_01` FOREIGN KEY (`userId`) REFERENCES `user`(`id`),
                          CONSTRAINT `review_fk_02` FOREIGN KEY (`contentId`) REFERENCES `content`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='레진 작품 평가';
```


### 3. 조회이력 (view_history)

* 테이블명 : review

|컬럼명|타입|제약조건|설명|
|---|---|---|---|
|ID|int|Primary Key , NOT NULL, AUTO_INCREMENT|ID (PK)|
|userId|int|NOT NULL|사용자ID|
|contentId|int|NOT NULL|작품ID|
|viewDate|varchar(8)|NOT NULL|조회 날짜|

* 테이블 생성 쿼리

```
CREATE TABLE `view_history` (
                                `ID` int NOT NULL AUTO_INCREMENT,
                                `userId` int NOT NULL,
                                `contentId` int NOT NULL,
                                `viewDate` varchar(8) NOT NULL,
                                PRIMARY KEY (`ID`),
                                CONSTRAINT `view_history_fk_01` FOREIGN KEY (`userId`) REFERENCES `user`(`id`),
                                CONSTRAINT `view_history_fk_02` FOREIGN KEY (`contentId`) REFERENCES `content`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='레진 작품 조회이력';
```

<br>

<hr>

## Application 실행 방법

1. /target/lezhin-0.0.1-SNAPSHOT.jar 파일을 실행
2. maven 프로젝트를 import 해서 실행

<br>

<hr>

## 테스트 방법

### Postman 이용 
함께 첨부된 `레진.postman_collection.json` 파일을 postman에서 Import 하여 호출

<br>

<hr>

## API Specification

### 1. 리뷰 작성

#### URL <br>
- https://localhost:8080/review

#### Http Method <br>
- POST

#### Request Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|userId|Number||사용자ID|
|2|contentId|Number||작품ID|
|3|isLike|String||좋아요 여부 (Y:좋아요 / N: 싫어요)|
|4|comment|String|O| 댓글

#### Request Body Example
```
{
    "userId":2,
    "contentId":1,
    "isLike":"N"
}
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|0001|요청 데이터가 잘못되었습니다.|요청 데이터가 잘못된 경우|
|1001|평가 작성에 실패했습니다.| 평가 작성에 실패한 경우|
|1002|이미 평가를 작성한 작품입니다.|유저가 작품에 이미 평가를 작성한 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response Body Example
```
{
    "responseCode": {
        "code": "1002",
        "message": "이미 평가를 작성한 작품입니다."
    }
}
```

### 2. 좋아요가 가장많은 3개 작품과 싫어요가 가장많은 3개 작품 조회

#### URL <br>
- http://localhost:8080/review/best-worst

#### Http Method <br>
- GET

### Request Sample
```
http://localhost:8080/review/best-worst
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|
|4|data|Object||결과 데이터|
|5|data.best|Array||좋아요가 가장 많은 3개|
|6|data.best[].id|Number||작품ID|
|7|data.best[].contentName|String||작품명|
|8|data.best[].author|String||작가|
|9|data.best[].coin|Number||가격|
|10|data.best[].adultContentYn|String||성인용 컨텐츠 여부|
|11|data.best[].openDate|String||서비스제공일|
|12|data.worst|Array||싫어요가 가장 많은 3개|
|13|data.worst[].id|Number||작품ID|
|14|data.worst[].contentName|String||작품명|
|15|data.worst[].author|String||작가|
|16|data.worst[].coin|Number||가격|
|17|data.worst[].adultContentYn|String||성인용 컨텐츠 여부|
|18|data.worst[].openDate|String||서비스제공일|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response body example
```
{
    "data": {
        "best": [],
        "worst": [
            {
                "id": 1,
                "contentName": "여우를 사냥하는 방법",
                "author": "치즈스틱",
                "coin": 0,
                "adultContentYn": "N",
                "openDate": "20230914"
            },
            {
                "id": 2,
                "contentName": "탈격소년",
                "author": "윤소함",
                "coin": 0,
                "adultContentYn": "N",
                "openDate": "20230914"
            }
        ]
    },
    "responseCode": {
        "code": "0000",
        "message": "성공했습니다."
    }
}
```

### 3. 작품 조회 이력 조회

#### URL <br>
- http://localhost:8080/content/{contentId}/view-history

#### Http Method <br>
- GET

#### Path Variable

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|contentId|Number||조회할 작품 ID|

### Request Sample
```
http://localhost:8080/content/1/view-history
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|
|4|data|Array||결과 데이터|
|5|data[].viewDate|String||작품을 조회한 날짜|
|6|data[].userId|Number||작품을 조회한 회원ID|
|7|data[].userName|String||작품을 조회한 회원명|
|8|data[].userEmail|String||작품을 조회한 회원 이메일|
|9|data[].gender|String||작품을 조회한 회원 성별(남자/여자)|
|10|data[].type|String||작품을 조회한 회원 타입(일반/성인)|
|11|data[].registerDate|String||작품을 조회한 회원서비스 시작일|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|1003|존재하지 않는 작품입니다.|작품ID가 존재하지 않는 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response body example
```
{
    "data": [
        {
            "viewDate": "20230914",
            "userId": 20230914,
            "userName": "leekh",
            "userEmail": "leekh@gmail.com",
            "gender": "남자",
            "type": "성인",
            "registerDate": "20230914"
        }
    ],
    "responseCode": {
        "code": "0000",
        "message": "성공했습니다."
    }
}
```

### 4. 최근 1주일간 가입한 사용자 중 성인 컨텐츠를 3개 이상 조회한 사용자 조회

#### URL <br>
- http://localhost:8080/content/adult-viewer

#### Http Method <br>
- GET

### Request Sample
```
http://localhost:8080/content/adult-viewer
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|
|4|data|Array||결과 데이터|
|5|data[].id|Number||회원 ID|
|7|data[].userName|String||회원명|
|8|data[].userEmail|String||원 이메일|
|9|data[].gender|String||회원 성별(남자/여자)|
|10|data[].type|String||회원 타입(일반/성인)|
|11|data[].registerDate|String||회원 서비스 시작일|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response body example
```
{
    "data": [
        {
            "id": 1,
            "userName": "leekh",
            "userEmail": "leekh@gmail.com",
            "gender": "남자",
            "type": "성인",
            "registerDate": "20230901"
        }
    ],
    "responseCode": {
        "code": "0000",
        "message": "성공했습니다."
    }
}
```

### 5. 작품 가격 변경

#### URL <br>
- http://localhost:8080/content/coin

#### Http Method <br>
- PATCH

#### Request Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|coin|Number||변경할 가격 (0원: 무료/ 100~500원: 유료)|
|2|contentId|Number||작품ID|

#### Request Body Example
```
{
    "coin":500,
    "contentId":1
}
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|0001|요청 데이터가 잘못되었습니다.|요청 데이터가 잘못된 경우|
|1003|존재하지 않는 작품입니다.|작품ID가 존재하지 않는 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response Body Example
```
{
    "responseCode": {
        "code": "0000",
        "message": "성공했습니다."
    }
}
```

### 6. 유저 삭제

#### URL <br>
- http://localhost:8080/user/{userId}

#### Http Method <br>
- DELETE

### Request Sample
```
http://localhost:8080/user/3
```

#### Response Body

|No|항목|타입|Optional|설명|
|---|---|---|---|---|
|1|responseCode|Object||응답 메타 데이터|
|2|responseCode.code|String||응답코드|
|3|responseCode.message|String||응답 메시지|

#### responseCode

|코드|메시지|설명|
|---|---|---|
|0000|성공했습니다.|요청이 성공한 경우|
|3000|존재하지 않는 유저입니다.|유저ID가 존재하지 않는 경우|
|9999|처리중 오류가 발생했습니다.|기타 에러가 발생한 경우|

#### Response Body Example
```
{
    "responseCode": {
        "code": "0000",
        "message": "성공했습니다."
    }
}
```
