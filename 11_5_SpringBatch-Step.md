# Spring Batch Step

## Step

- Sprign Batch에서 Step은 인터페이스로 제공됩니다.

```Java
public interface Step {

  String getName();

  void execute(StepExecution stepExecution) throws JobInterruptedException;
}
```

## Step의 대표적인 구현체

- SpringBatch에서 제공하는 Step의 대표적인 구현체는 다음과 같습니다.

<img src=./resource/11_7_SpringBatchStep.png>

## TaskletStep

### Tasklet

- `Tasklet` 은 Step에서 수행하는 작업의 단위를 의미합니다.
- `Tasklet` 인터페이스는 다음과 같습니다.

```Java
@FunctionalInterface
public interface Tasklet {

  @Nullable
  RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception;
}
```

- `RepeatStatus` : 프레임워크에게 작업이 끝났는지(`RepeatStatus.FINISHED`), 아직 끝나지 않았는지(`RepeatStatus.CONTINUABLE`)를 전달하기 위한 enum입니다.
- 각각의 Tasklet은 DB Transaction의 scope에서 실행됩니다.

## 출처

`https://spring.academy/courses/building-a-batch-application-with-spring-batch/lessons/spring-batch-steps-understanding-steps`
