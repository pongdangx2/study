# Observer Pattern (옵저버 패턴)

## 옵저버 패턴이란?

* 객체의 상태 변화를 관찰하는 옵저버의 목록에 객체를 등록해서 상태 변화가 있을 때마다 옵저버에 통지하도록 하는 디자인 패턴입니다.
* 객체의 상태 변화를 주기적으로 조회히자 읺아도 됩니다.
* 주로 분산 이벤트 핸들링 시스템을 구현할 때 사용됩니다.
* 발행/구독 모델로 알려져 있기도 합니다.

## 메일이 도착하면 푸시메시지를 보내는 옵저버 만들기

1. 옵저버 인터페이스 만들기

```
public interface Observer {
    void update();
}
```

2. Observer 만들기

```
public class PushManager implements Observer {

    @Override
    public void update() {
        System.out.println("메일이 도착했습니다.");
    }
}
```

3. 각 객체의 옵저버를 관리할 수있는 인터페이스 만들기

```
public interface Subject {
    List<Observer> observers = new ArrayList<>();

    default void registObserver(Observer observer){
        if(observer != null)
            this.observers.add(observer);
    };
    default void unregistObserver(Observer observer){
        if(observer != null)
            this.observers.remove(observer);
    };

    default void notifyObservers() {
        for(Observer observer : observers){
            observer.update();
        }
    }
}
```

4. 신규 객체 만들기

```
public class MailBox implements Subject {
    public void registPushObserver(){
        this.registObserver(new PushManager());
    }
    public void receiveNewMail() {
        System.out.println("Receive a new mail");
        this.notifyObserver();
    }
}
```
