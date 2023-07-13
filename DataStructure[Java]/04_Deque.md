# Deque

## Deque 만들기

```
Deque<Integer> deque = new LinkedList<>();
```

<br>

## 값 추가

|메소드명|설명|
|---|---|
|add()|맨 마지막에 삽입 (사이즈 초과 시 예외 발생)|
|addFirst()|맨 앞에 삽입 (사이즈 초과 시 예외 발생)|
|addLast()|맨 마지막에 삽입 (사이즈 초과 시 예외 발생)|
|offer()|맨 마지막에 삽입 (성공시 true, 실패 시 false 반환)|
|offerFirst()|맨 앞에 삽입 (성공시 true, 실패 시 false 반환)|
|offerLast()|만 마지막에 삽입 (성공시 true, 실패 시 false 반환)|

* ex.

```
deque.add(3);
deque.addfirst(2);
deque.addLast(4);
deque.offer(5);
deque.offerFirst(1);
deque.offerLast(6);
// 1,2,3,4,5,6
```

<br>

## 값 제거

|메소드명|설명|
|---|---|
|remove()|맨 앞의 값 제거 후 반환 (비어있는 경우 예외 발생) |
|removeFirst()|맨 앞의 값 제거 후 반환 (비어있는 경우 예외 발생)|
|removeLast()|맨 마지막의 값 제거 후 반환 (비어있는 경우 예외 발생)|
|poll()|맨 앞의 값 제거 후 반환 (비어있는 경우 null 반환)|
|pollFirst()|맨앞의 값 제거 후 반환 (비어있는 경우 null 반환)|
|pollLast()|마지막 값 제거 후 반환 (비어있는 경우 null 반환)|

* ex.

```
// 1,2,3,4,5,6
deque.remove() // 1
deque.removeFirst() // 2
deque.removeLast() // 6
deque.poll() // 3
deque.pollFirst() // 4
deque.pollLast() // 5
```

<br>

## 값 확인

|메소드명|설명|
|---|---|
|getFirst()|맨 앞의 값 반환 (비어있는 경우 예외 발생)|
|getLast()|맨 뒤의 값 반환 (비어있는 경우 예외 발생)|
|peek()|맨 앞의 값 반환 (비어있는 경우 null 반환)|
|peekFirst()|맨 앞의 값 반환 (비어있는 경우 null 반환)|
|peekLast()|맨 뒤의 값 반환 (비어있는 경우 null 반환)|

<br>
<hr>