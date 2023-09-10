# Singleton Pattern

## Singleton Pattern이란?

* 인스턴스를 오직 1개만 생성하는 패턴
* Spring 컨테이너에서 객체를 관리할 때, 따로 설정하지 않으면 싱글톤으로 생성하여 관리함.


## ex

* 클래스 내의 static 클래스는 외부 클래스가 초기화될 때 초기화되지 않습니다.
* 클래스의 static 변수는 클래스가 로딩될 때 초기화됩니다.
* getInstance()가 호출될 때, LazyHolder가 로딩되고, static 변수가 초기화됩니다.
* class를 로딩하고 초기화하는 작업은 동기화되기 때문에 synchronized나 volatile같은 키워드 없이도 thread-safe하게 만들 수 있습니다.

```
public class Singleton {

    // 외부에서 생성자를 호출하여 인스턴스를 만드는 것을 방지합니다. 
    private Singleton(){

    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public void doSomething(){
        System.out.println("do Something!");
    }
}
```