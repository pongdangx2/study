# PriorityQueue

## PriorityQueue 만들기

```
// 우선순위 오름차순
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 

// 우선순위 내림차순
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); 
```

<br>

## 값 추가

|메소드명|설명|
|---|---|
|add()|값 추가 (실패 시 예외 발생)|
|offer()|값 추가 (성공 시 ture, 실패 시 false 반환)|

<br>

## 값 꺼내기

|메소드명|설명|
|---|---|
|poll()|첫번째 값을 반환 (비어있다면 null)|
|remove()|첫번째 값을 제거|
|peek()|첫번째 값 반환|

<br>

<hr>

# Heap

## Heap의 종류

1. Max Heap (최대 힙)

> 부모 노드의 키 값이 자식노드의 키 값보다 크거나 같은 완전 이진트리

2. Min Heap (최소 힙)

> 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리

<br>

## 우선순위큐로 Heap 만들기

* Max Heap

```
PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
    @Override
    public int compare(Integer num1, Integer num2){
        return -Integer.compare(num1, num2);
    }
});
```

* Min Heap

```
PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
    @Override
    public int compare(Integer num1, Integer num2){
        return Integer.compare(num1, num2);
    }
});
```

<br>

<hr>
