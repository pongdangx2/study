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