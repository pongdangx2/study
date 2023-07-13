# List

## 값추가/꺼내기
* add()
```
List<String> list = new ArrayList<>();
list.add("A");
list.add(0, "B"); // 0번째에 B추가

String firstElement = list.get(0); // B
```

<br>

## 값 삭제
* remove(Object e)  - e 제거 + 삭제여부 true/false 반환
* Remove(int index) - 인덱스로 제거 + 삭제한 값 반환
```
String test = list.remove(1); // A
boolean delYn = list.remove("B");  // true;
```

<br>

## 인덱스 찾기
* indexOf(value)

```
int index = list.indexOf("A");
```

<br>

## 값 수정

* set()

```
list.set(0, "A");  // 0번째 인덱스의 값을 A로 수정
```

<br>

## Sorting

* Collections.sort()

```
public static  void sort(List<T> list)
public static  void sort(List<T> list, Comparator<? super T> c)
```

* java8 이후에선 List.sort 사용 가능

```
default void sort(Comparator<? super E> c)
```

* 예시
```
Collections.sort(list);  // 오름차순 정렬
Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

list.sort(Collections.naturalOrder());  // 오름차순 정렬
list.sort(Collections.reverseOrder());  // 내림차순 정렬
```