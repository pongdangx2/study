# Garbage Collector

## Garbage Collection
* JVM의 Heap 영역에 동적으로 할당했으나 더이상 참조되지 않고 있는 메모리를 회수하는 메모리 관리 방법

## Heap의 영역

<img src=./resource/7_2_JVMHeap.png>


#### Young Generation (영 영역)

* 새로 생성된 객체가 할당되는 영역
* Young 영역에 대한 GC를 `Minor GC`라고 부른다.

#### Old Generation (올드 영역)

* Young영역에서 살아남은 객체가 복사되는 영역
* Young영역보다 크게 할당된다.
* Old 영역에 대한 GC를 `Major GC`라고 부른다.

#### Permanent Generation

* 클래스로더가 런타임중에 읽은 클래스의 메타데이터가 저장되는 영역
* Java8 이후에는 Metaspace로 옮겨졌다.
* MetaSpace : Java의 Native memory에 할당되기 때문에 OS가 알아서 메모리를 관리한다.

<br>

<hr>

## 객체 이동 순서

1. 처음 객체가 생성되면 Eden 영역에 저장된다.
2. Eden영역이 꽉 차면 Minor GC가 일어나는데, 이 때 Eden 영역에서 살아남은 객체가 Survivor 영역으로 옮겨진다.
3. Minor GC가 발생할 때, Survivor 영역이 꽉차면 다른 Survivor 영역으로 모두 옮긴다.
4. 특정 횟수만큼의 Minor GC에서 살아남으면 Old 영역으로 옮겨진다.
