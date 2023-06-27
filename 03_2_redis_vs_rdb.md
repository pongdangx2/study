# Redis
### Redis란?

* 오픈소스 In-memory DB
* `Re`mote `Di`ctionary `S`erver 의 약자
* 다양한 자료구조를 지원하기에 개발 편의성이 좋음.
* Key - Value 기반의 NoSql DB


<br>
<hr>

### RDB vs. Redis

1. 저장공간
> RDB에서는 데이터가 디스크에 저장된다.<br>
> 반면,  Redis는 메모리에 저장된다.

2. 확장성
> RDB에서는 컬럼을 추가하기위해 스키마를 변경해야한다. <br>
> Redis의 스키마는 유연성이 있다. RDB에서처럼 스키마를 미리 정해두지 않아도 된다.

3. 데이터중복
> RDB에서는 데이터를 중복해서 저장시키는 것을 최소화 한다. (정규화) <br>
> Redis에서는 중복을 허용한다. 즉, join 이 줄어들어 어느정도 Performance에 이점이 있다.

<hr>
