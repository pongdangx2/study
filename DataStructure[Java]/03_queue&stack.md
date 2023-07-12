# Queue

## Queue 만들기

```
Queue<Integer> queue = new LinkedList<>();
```

<br>

## 값 추가

* offer()
* add()

```
queue.add(1);
queue.add(2);
queue.offer(3);
```

<br>

## 값 꺼내기

* poll()  - 첫번째 값 삭제하고 반환 / 비어있다면 null
* remove()  - 첫번째 값 그냥 삭제
* peek()   - 첫번째 값 반환만

```
int e1 = queue.peek();
int e2 = queue.poll();
queue.remove();
```

<br>

<hr>

# Stack

## Stack 만들기

```
Stack<Integer> stack = new Stack<>();
```

<br>

## 값 추가

* push()

```
stack.push(1);
stack.push(2);
stack.push(3);
```

<br>

## 값 꺼내기

* pop() - 마지막 값 삭제하고 반환
* peek() - 마지막 값 반환 
```
int num1 = stack.peek(); // 3
int num2 = stack.pop(); //3
```

