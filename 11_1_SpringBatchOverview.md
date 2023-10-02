# Spring Batch Overview

## Spring batch 란?

스프링 배치는 강력한(Robust) 배치 애플리케이션을 개발하기 위해 고안된 가볍고(lightweight) 종합적인 Framework입니다.
스프링 배치는 트랜잭션관리, 통계를 포함한 대용량 데이터를 처리하기 위해 필수로 필요한 특징들을 가지고 있습니다.

## Spring Batch 의 장점

1. 병렬처리 및 분산 처리를 지원합니다.
2. 장애가 발생했을 때 작업을 재시도하거나 이전 상태로 복구하는 메커니즘을 제공합니다.
3. 배치작업의 실행 상태를 모니터링하고, 작업 실행 로그 및 통계 정보를 쉽게 관리할 수 있습니다.
4. 다양한 배치작업에서 공통으로 사용되는 로직을 추상화하여 제공합니다.
5. 모듈화된 구조를 제공하기 때문에 유지보수의 장점이 있습니다.
6. 다양한 Data Source를 지원합니다. <br> DB, 파일, 메시지 큐 등 다양한 Data Source에서 데이터를 추출/처리할 수 있습니다.
7. Spring framework의 일환이기 때문에 단위테스트와 통합테스트를 수행하기 쉽습니다.

## Spring Boot와 Spring Batch

- Spring Boot는 애플리케이션이 실행될 때, application context에 정의된 `Job` 빈을 모두 자동으로 실행합니다.

## Spring Batch 와 멱등성

### 멱등성이란?

연산을 여러번 하더라도 결과가 달라지지 않는 성질을 의미합니다.

### 멱등성이 깨진 경우

- 오늘 날짜의 사용자 수를 집계하는 배치가 있다고 가정해 봅니다.

> 오늘 날짜를 얻기 위해 LocalDateTime.now() 메서드를 사용해 오늘 날짜를 가져와서 처리할 수 있습니다.

- 이 경우 어제의 배치에서 오류가 발생하여 다시 어제의 배치를 실행해야 할 때에는 소스를 수정하여 다시 배포하고 롤백하는 과정을 거쳐야 합니다.
- 이와 같은 상황에서 멱등성이 깨졌다고 얘기할 수 있습니다.

### Spring Batch 와 멱등성

Spring Batch에서는 멱등서을 유지하기 위해 `Spring Batch Job Parameter`를 통해 원하는 값을 외부에서 주입시켜주는 방법을 사용합니다.

## Batch 도메인 용어

<img src=./resource/11_1_BatchDomain.png>

### 1. Job

- 시작할때부터 끝날때까지 방해없이 실행되는, 전체 배치 프로세스를 감싸는 Entity입니다.
- 하나 이상의 Step으로 구성되어 있습니다.

### 2. Step

- 작업의 단위입니다.
- `ItemReader`와 `ItemProcess(Optional)`, `ItemWriter`를 가집니다.

### 3. JobLauncher

- `Job`은 `JobLauncher`에 의해 시작되며, `JobParameter`를 가지고 시작될 수도 있습니다.

### 4. JobRepository

- 실행되고 있는 `Job`에 대한 메타데이터들은 `JobRepository`에 저장됩니다.

## Batch Domain Model

<img src=./resource/11_2_BatchDomainModel.png>

`Spring Batch는 메타데이터를 위한 관계형 모델을 제공합니다.`

### Meta-Data Schema

- 스프링 배치에서 메타데이터를 저장하는 스키마는 다음 문서에 나타나있습니다.
`https://docs.spring.io/spring-batch/docs/3.0.x/reference/html/metaDataSchema.html`

### Meta-Data 세부 정보

#### Job_Instance

- Job의 이름이나 식별자같은 Job과 관련된 모든 정보를 담고 있습니다.

#### Job_Execution

- Job의 시작시간, 종료시간, 상태 등 `Job`의 실행과 관련된 정보를 담고 있습니다.
- Job이 실행될 때마다 새로운 row가 생성됩니다.

#### Job_Execution_Context

- Job Execution Context를 담고 있습니다.
- Job Execution Context란 일반적으로 실패 후 검색해야 하는 상태를 나타내는 런타임 정보의 키/값 쌍으로 이루어진 집합입니다.

#### Step_Execution

- 시작 시간, 종료 시간, 아이템 읽기 횟수, 아이템 쓰기 횟수 등 `Step`실행과 관련된 모든 정보가 들어있습니다.
- Step이 실행될 때마다 새로운 row가 생성됩니다.

#### Step_Execution_Context

- Step Execution Context를 담고 있습니다.
- Job Execution Context와 유사하지만, Step에 대한 정보가 담겨있습니다.

#### Job_Execution_Params

- Job실행의 Runtime Parameter들을 담고 있습니다.

## Spring Batch Architecture

- Spring Batch는 모듈식, 확장 가능한 방식으로 설계되어 있습니다.
- 다음 그림은 프레임워크를 쉽게 사용할 수 있도록 지원하는 계증화된 아키텍처입니다.

<img src=./resource/11_3_SpringBatchArchitecture.png>

### Application Layer

- 배치 애플리케이션 개발자가 작성한 Batch job 과 사용자의 코드가 포함되어 있습니다.

### Batch Core Layer

- 배치 Job을 생성하고 제어하는데 필요한 Spring Batch에서 제공하는 핵심 런타임 클래스가 포함되어 있습니다.
- Job, Step, JobLauncher, JobRepository 등이 포함됩니다.

### Batch Infrastructure

- 스프링 배치에 의해 제공되는 공용 Item reader와 writer가 포함되어 있습니다.
- 반복 및 재시도와 같은 애플리케이션 개발자와 core 프레임워크 자체에서 모두 사용되는 기본 서비스가 포함되어 있습니다.

## 출처

`https://spring.academy/courses/building-a-batch-application-with-spring-batch/lessons/introduction`
