# Spring batch - Job

## Job

- Job은 전체 배치 프로세스를 감싸고 있는 Entity입니다.
- 하나 이상의 Step으로 구성되어 있습니다.
- Spring Batch에서 Job은 `spring-batch-core`의 `Job`인터페이스로 표현합니다.

```java
public interface Job {
    String getName();
    void execute(JobExecution execution);
}
```

- `Job Interface`의 구현체는 Job의 이름(`getName` 메서드)과 Job이 무슨 작업을 수행할지(`execute` 메서드)를 명세해야 합니다.
- `execute` 메서드는 exception를 발생시켜선 안됩니다. Runtime Exception은 모두 execute 메서드 내에서 `예외처리` 되어야 하고, JobExecution 객체에 추가되어야 합니다.
- Job의 구현체는 JobRepository에 status와 exit code를 업데이트해야 한다.

## JobExecution

- Job 인터페이스의 execute 메서드에는 `JobExecution`이 매개변수로 전달됩니다.
- 여기에는 시작시간, 종료시간, 실행상태 등의 Runtime 세부사항들이 포함되어 있습니다.

## JobRepository

- Job과 Step의 메타데이터는 `JobRepository`에 저장됩니다.
- Spring Batch는 RDB에 메타데이터를 저장하기 쉽게 `JobRepository`의 `JDBC`구현체를 제공합니다.
- `JobRepository`는 `Job`이 시작될 때 `JobExecution`객체를 생성합니다.

## JobLauncher

- Spring Batch에서 Job은 `JobLauncher`를 통해 실행됩니다.

```java
public interface JobLauncher {

   JobExecution run(Job job, JobParameters jobParameters)
          throws
             JobExecutionAlreadyRunningException,
             JobRestartException,
             JobInstanceAlreadyCompleteException,
             JobParametersInvalidException;
}
```

- `run`메서드는 JobParameters와 함께 Job을 실행시킵니다.
- JobLauncher의 구현체는 다음 두가지를 충족해야합니다.

> 1. `JobRepository`에서 `JobExecution`을 얻어와서 Job을 실행해야 합니다.
> 2. `run`메서드는 몇가지 특정 Exception을 던질 수 있어야 합니다.

- Spring Batch에서는 바로 사용할 수있는 `JobLauncher`구현체를 제공하기 때문에, 직접 구현체를 개발하지 않아도 됩니다.

<img src=./resource/11_4_SpringJob.png>

## 출처

`https://spring.academy/courses/building-a-batch-application-with-spring-batch/lessons/spring-batch-creating-jobs`
