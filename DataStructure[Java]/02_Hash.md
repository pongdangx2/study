# Map

## 값 넣기

* put(key, value)

```
Map<String, String> numbers = new HashMap<>();
numbers.put("1", "one");
numbers.put("2", "two");
```

<br>

## 값 꺼내기

* get(key)
* getOrDefault(key, defaultValue)

```
String one = numbers.get("1"); // one
String three = numbers.getOrDefault("3", "three"); // three
```

<br>

## 값 삭제
* revmove(key)  - key에 해당하는 값을 삭제 후 반환

```
String one = numbers.remove("1"); // one
```
