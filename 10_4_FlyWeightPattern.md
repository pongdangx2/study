# FlyWegit Pattern (플라이웨이트 패턴)

## 플라이웨이트 패턴이란?

* 공통으로 사용하는 클래스(Flyweight)를 생성하는 팩토리클래스(Flyweight Factory)를 만들어, 인스턴스를 최초 1개만 생성하고 공유하여 재사용할 수 있도록 하는 패턴입니다.
* 인스턴스를 재사용하여 메모리 사용을 줄일 수 있습니다.

## 자동차를 이용한 예시

* 자동차의 차량번호는 차량마다 다를 수 있습니다.
* 차종별로 연료타입은 항상 같습니다.
* 차량이 200대 들어있는 주차장을 만들어봅시다!

1. 차종 별 연료 타입을 담는 클래스를 생성합니다.
```
public final class FuelType {
    private final String fuelType;

    public FuelType(String fuelType){
        this.fuelType = fuelType;
    }
    // ... getter는 생략합니다.
}
```

2. 차종별 정보를 관리하는 Factory를 생성합니다.
```
public class FuelTypeFactory {
    private Map<String, FuelType> cache = new HashMap<>();

    public FuelType getFuelType(String modelName, String fuelType){
        if(cache.containsKey(modelName)){
            return cache.get(modelName);
        } else {
            FuelType fuelType = new FuelType(fuelType);
            cache.put(modelName, fuelType);
            return fuelType;
        }
    }
}
```

3. 차량정보를 담는 차량 클래스를 생성합니다.
```
public class Car {
    private String carRegistNumber;
    private FuelType fuelType;

    public Car(String carRegistNumber, FuelType fuelType){
        this.carRegistNumber = carRegistNumber;
        this.fuelType = fuelType;
    }
    // ... getter는 생략합니다.
}
```

4. 차량정보를 관리하는 주차장을 만들어봅니다.
```
public class Main {
    public static void main(String[] args){
        FuelTypeFactory fuelTypeFactory = new FuelTypeFactory();
        List<Car> parkingLot = new ArrayList<>();
        parkingLot.add(new Car("12가3456", fuelTypeFactory.getFuelType("아이오닉5", "electric")));
        parkingLot.add(new Car("23가1234", fuelTypeFactory.getFuelType("아이오닉5", "electric")));
    }
}
```