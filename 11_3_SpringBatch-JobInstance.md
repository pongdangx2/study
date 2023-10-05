# Job Instance

## Job Insttance란?

- 특정 매개변수를 갖는 Job의 논리적 실행 단위입니다.
- `Job의 이름`과 Job에 전달되어 실행될 때 사용하는 `Parameter`로 식별됩니다.
- JobInstance의 상태는 `BATCH_JOB_INSTANCE` 테이블에서 조회할 수 있습니다.
- 파라미터가 완전 동일하다면 새로운 Job Instance를 얻지 못합니다.

ex. 파라미터로 schedule.date가 전달되는 EndOfDayJob의 예시

<img src=./resource/11_5_SpringBatchJobInstance.png>

## Job Instance 와 Job Parameter

- `Job Instance` 자체는 로드할 데이터와 관계가 없습니다.
- `Job Parameter`를 기반으로 어떻게 데이터를 로드할지는 `Job 구현체`에 달려있습니다.
- Job Parameter 의 몇가지 예시예시

> 1. 특정 날짜 : 날짜마다 `Job Instance`가 생성됩니다.
> 2. 특정 파일 : 파일마다 `Job Instance`가 생성됩니다.
> 3. RDB의 특정 범위의 레코드 : 범위마다 `Job Instance`가 생성됩니다.

## Job Instance 와 Job Execution

- `Job Execution`은 `Job Instance`를 실행하기 위한 각각의 시도를 나타내는 기술적인 개념입니다.
- Job Execution은 성공 혹은 실패로 끝이 납니다.
- 따라서 `JobInstance`는 여러개의 `Job Execution`을 가질 수 있습니다.

<img src=./resource/11_6_SpringBatchJobInstanceAndJobExecution.png>

## Job Instance, Job Parameter 그리고 Job Execution

- `Job Parameter`는 보통 `Job Instance`의 식별자로 사용됩니다.
- Job Parameter는 `identifying`이어도 되고 `identifying`이 아니어도 됩니다.

|Job Parameter|Identifying?|Example|
|---|---|---|
|schedule.date|Yes|2023-01-01|
|file.format|No|csv|

- `Identifying Job Parameter`는 배치가 실패했을 때 빛을 발합니다.
- 수백개의 Job Instance 중 특정 Job Instance의 Job Execution이 실패했을 때, 같은 Identifying Job Parameter로 Job을 실행하면 실패한 Job Instance를 대상으로 새로운 Job Execution을 생성합니다.

## 출처

`https://spring.academy/courses/building-a-batch-application-with-spring-batch/lessons/spring-batch-understanding-job-instances`
