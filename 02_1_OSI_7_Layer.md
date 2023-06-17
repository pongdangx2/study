# OSI 7 계층이란?
### OSI 7계층이란?
* 개방형 시스템에서 상호 연결 모델의 표준
* 실제 인터넷에서 사용하는 TCP/IP는 OSI 모델 기반으로 단순화한 것

<br>

### OSI 7 Layer

<img src=./resource/02_1_OSI7Layer.png>

<br>
<hr>

# 1 Layer - Physical Layer (물리 계층)
### Physical Layer?

* 7계층 중 최하위 계층
* 전기적 특성을 이용해 통신케이블로 데이터를 전송
* 하드웨어적으로 구성
* 데이터를 전달하기만 할 뿐, 이게 어떤 데이터인지는 상관없다.
* 전송단위: 비트 (0과 1)
* 연관 장비: 통신케이블, 리피터, 허브 등

<br>

### Encoding & Decoding
통신케이블을 통해 데이터를 주고받을 때는 아날로그 신호를 사용한다.

1. Encoding : 2계층으로부터 받은 데이터(0, 1로 구성)를 아날로그 신호로 변경하는 것.
2. Decoding : 전달받은 아날로그신호를 0,1로 구성된 데이터로 변경하는 것.
<img src=./resource/02_2_PhysicalLayer.png>

<br>
<hr>

# 2 Layer - Data-Link Layer (데이터링크 계층)
### Data-Link Layer?

* Link: **통신노드**들 간의 연결 <br> - [통신노드: 컴퓨터, 교환기, 라우터 등]
* 물리적 연결로 인접해있는 두 통신노드 간의 신뢰성 있는 정보 전달 담당<br>(Point-To-Point 전송)
* 통신 시 Mac address 이용
* 하드웨어적으로 구성
* 에러검출(CRC이용), 재전송, 흐름제어 수행
* 전송단위: Frame(프레임)
* 연관장비: 스위치, 브리지

<br>

### Farme이란?
* Network Layer에서 내려온 Packet에 헤더(header)와 트레일러(trailer)를 붙여서 Frame을 만든다. 
* Header와 Trailer는 네트워크 유형에 따라 다르지만 일반적으론 다음과 같다.
> Header
>> Frame시작을 나타내는 Flag를 시작으로 목적지 주소(Mac)를 포함<br>

> Trailer
>> 에러 검출을 위한 Checksum비트와 Frame의 끝을 나타내는 Flag 등으로 구성

<img src=./resource/02_3_DataLink.png>

<br>
<hr>

# 3 Layer - Network Layer (네트워크 계층)
### Network Layer?

* 송신 단말로부터 여러 네트워크를 거쳐 수신 단말로 전달
* 출발 지점에서 최종 목적지로 최적의 경로로 찾아가기<br>- `라우팅`을 담당
* 통신시 IP Address 사용
* 패킷의 헤더에는 논리적 주소인 IP 주소 포함
* OS 커널에 소프트웨어적으로 구성
* 전송단위: Packet(패킷)
* 연관장비: 라우터, L3 스위치
* 대표 프로토콜

> `IP`(Internet Protocol)<br>
> `ICMP`(Internet Control Message Protocol)

<br>

### IP(Internet Protocol) 란?

* 네트워크 계층에서 수신단말의 주소지정과 패킻 분할 및 조립 수행
* 즉 패킷(Packet)단위로 지정한 IP 주소에 데이터를 전달하는 프로토콜

> #### IP 의 한계
>
> 1. 비연결성<br> - 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷을 전송함.
> 2. 비신뢰성<br> - 전송하는 데이터가 정확하게 갔는지 확인하지 않음.

<br>

<hr>

# 4 Layer - Transport Layer (전송 계층)
### Transport Layer?

* 종단 간 신뢰성 있고 정확한 데이터 전송 담당 (End-To-End)
* 오류검출 및 복구, 흐름제어, 중복검사 등 수행
* 상위 계층에서 데이터의 유효성이나 효율성을 신경쓰지 않게 해준다.
* 데이터 전송을 위해 Port를 사용
<br> - 도착지 컴퓨터의 프로세스까지 데이터가 도달하게 한다.

* OS 커널에 소프트웨어적으로 구성
* 전송단위: Segment(세그먼트)
* 대표 프로토콜

> `TCP`(Transmission Control Protocol)<br>
> `UDP`(User Datagram Protocl)

<br>
<hr>

# 5 Layer - Session Layer (세션 계층)
### Session Layer?

* 통신장치간 상호작용 및 동기화 제공
* 연결 세선에서 데이터 교환과 에러 발생 시의 복구 관리

**. . .  (중요하지 않음.)**

<br>
<hr>

# 6 Layer - Presention Layer (표현 계층)
### Presentation Layer?

* 데이터를 어떻게 표현할지 정하는 역할
* 암-복호화 수행

**. . .  (중요하지 않음.)**

<br>
<hr>

# 7 Layer - Application Layer (응용 계층)
### Application Layer?

* 사용자 간 혹은 응용 프로세스 간의 정보 교환 담당
* 대표 프로토콜

> HTTP, FTP, SMTP, POP3, Telnet 등등..

<hr>