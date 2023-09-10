# Strategy Pattern (전략패턴)

## 전략패턴이란?

* 행위의 수정이 필요한 경우 전략을 바꾸는 것만으로 수정이 가능하도록 만들어진 패턴

> 1. 동일 계열의 알고리즘군을 정의 (fly, walk, run ..) <br>
> 2. 각 알고리즘을 캡슐화 (Move Strategy) <br>
> 3. 이들을 상호 교환 가능하도록

## 로봇을 만들어보기!

### 날아가는 로봇과 걸어가는 로봇을 각각 만들기

* 로봇을 각각 클래스로 만들었습니다.

```
public class FlyingRobot {
    public void move(){
        System.out.println("날아갑니다.");
    }
}

public class WalingRobot {
    public void move(){
        System.out.println("걸어갑니다.");
    }
}
```

### 다형성을 활용해보기

* 다음과 같이 Robot 추상클래스를 활용해 변경해볼 수 있습니다.

```
public abstract class Robot {
    public abstract void move();
}

public class FlyingRobot extends Robot{
    @Override
    public void move(){
        System.out.println("날아갑니다.");
    }
}

public class WalingRobot extends Robot{
    @Override
    public void move(){
        System.out.println("걸어갑니다.");
    }
}

```

### Strategy Pattern을 적용해보기

1. 움직이는 전략 interface 생성

```
public interface MoveStrategy {
    void move();
}

public class Walk implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("걸어갑니다.");
    }
}

public class Fly implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("날아갑니다.");
    }
}
```

2. Robot이 MoveStrategy에 의존하도록 합니다.

```
public class Robot {
    MoveStrategy moveStrategy;

    public Robot(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
    public void move() {
        moveStrategy.move();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
    }
}

public class Main {
    public static void main(String[] args) {
        Robot walkingRobot = new Robot(new Walk());
        Robot flyingRobot = new Robot(new Fly());

        walkingRobot.move();
        flyingRobot.move();
    }
}
```

## 전략패턴의 장점

* 새로운 전략의 추가가 쉽습니다.
* 기존 전략의 수정이 쉽습니다.

## 전략패턴의 예시 - Comparator

* Comparator를 사용하면 비교 전략을 상황에 맞게 구현할 수 있도록 합니다.
* 기존 코드의 수정 없이 확장할 수 있습니다.

```
public class RobotCompareBySerialNo implements Comparator<Robot> {
    @Override
    public int compare(Robot robot1, Robot robot2){
        return robot1.getSerialNo() - robot2.getSerialNo();
    }
}
```