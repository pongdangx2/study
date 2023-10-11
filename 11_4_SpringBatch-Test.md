# Spring Batch Test

## spring-batch-test 모듈

- `spring-batch-test`는 batch artifact 테스트를 단순화 하기 위해 디자인된 Spring Batch의 모듈입니다.

## 배치 테스트의 두가지 종류

### 두가지 방식

- `Job` 전체 테스트 (End to End)

> 테스트할 때 `input data` 를 제공하고, `Job` 을 실행하고, `결과` 를 검증합니다.

- Job의 각 `Step` 테스트

> 테스트할 때 전체 Job을 실행하지 않고, 각 Step만 독립적으로 테스트합니다.

### `JobLauncerTestUtils` API

- 테스트의 두가지 종류 모두 `Job` 혹은 특정 `step` 을 실행하기 전에 테스트데이터를 준비해야 합니다.
- 테스트에서 `Job` 혹은 특정 `step` 을 실행하기 위해 `JobLauncerTestUtils` API를 제공합니다.
- `JobLauncerTestUtils` 는 몇가지 유용한 utilities와 methods를 제공합니다.

#### 1. ***Random Job Parameter Generation***

- 테스트할 때 별개의 Job Instance를 생성하기 위해 unique한 Job Parameter를 생성할 수 있습니다.

```Java
JobLauncherTestUtils.getUniqueJobParameters
JobLauncherTestUtils.getUniqueJobParametersBuilder
```

- ex

```Java
@Test
void testJobExecution(CapturedOutput output) throws Exception {
	// given
	String parameterFileName = "/some/input/file";
	JobParameters jobParameters = this.jobLauncherTestUtils.getUniqueJobParametersBuilder()
			.addString("input.file", parameterFileName)
			.toJobParameters();

	// when
	JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jobParameters);

	// then
	Assertions.assertTrue(output.getOut().contains("processing billing information from file " + parameterFileName));
	Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
}
```

위와 같이 jobLauncherTestUtils.getUniqueJobParametersBuilder() 메서드를 이용하면 테스트를 실행할 때, 등록된 파라미터와 다른 Unique한 파라미터가 함께 생성됩니다.

 |job_execution_id | parameter_name |  parameter_type  |   parameter_value    | identifying|
 |---|---|---|---|---|
|49 | random         | java.lang.Long   | -2305569543280804739 | Y|
|49 | input.file     | java.lang.String | /some/input/file     | Y|
|51 | random         | java.lang.Long   | 208082855255757609   | Y|
|51 | input.file     | java.lang.String | /some/input/file     | Y|
|53 | random         | java.lang.Long   | 6393756363010672354  | Y|
|53 | input.file     | java.lang.String | /some/input/file     | Y|

#### 2. ***Launching an entire job from end to end***

- `JobLauncherTestUtils.launchJob` 를 사용하면 실제 운영환경에서와 동일하게 Job을 실행할 수 있습니다.
- 랜덤 Parameter로 실행할지, 특정 파라미터로 실행할지 지정할 수 있습니다.

#### 3, ***Launching an individual step***

- `JobLauncherTestUtils.launchStep` 를 사용하면 Job 과 상관없이 특정 Step만 테스트할 수 있습니다.

## Spring Batch Test 와 데이터베이스

- 테스트할 때 메타데이터 DB를 정리하기 위해, Spring batch에서는 `JobRepositoryTestUtils`를 제공합니다.
- 이는 테스트 하는 동안 `JobExecution`을 생성하거나 삭제할 때 사용됩니다.
- 보통 다음과 같이 테스트 전/후에 DB의 메타데이터를 정리할 때 사용됩니다.

```Java
@BeforeEach
void setUp() {
    this.jobRepositoryTestUtils.removeJobExecutions();
}

@AfterEach
void tearDown() {
    this.jobRepositoryTestUtils.removeJobExecutions();
}
```

## 그밖의 테스트 Utility

- `ExecutionContextTestUtils` class

> `JobExecution` 과 `StepExecution`의 execution context로부터 애트리뷰트에 접근하기 위한 static method를 제공합니다.

- `MetaDataInstanceFactory` class

> - batch domain model에 정의된 제약조건대로 Spring Batch의 메타데이터 엔티티를 생성합니다.
> - ex. JobInstance + JobExecution , JobExecution + StepExecution

- `@SpringBatchTest` 애노테이션

> 테스트 컨텍스트에 test utility들(`JobLauncherTestUtils, JobRepositoryTestUtils, etc`)을 빈으로 등록합니다.

## 출처

`https://spring.academy/courses/building-a-batch-application-with-spring-batch/lessons/spring-batch-testing-jobs`
