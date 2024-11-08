## Stack & Queue 란?

---

![Stack & Queue](stack%20%26%20queue.png)

## Stack 이란?

---

스택은 LIFO(Last In First Out) 구조로 이루어져 있으며, 쉽게 말하면 후입 선출이다.

- 즉, 마지막(최근)에 넣은 요소를 먼저 뺀다는 의미이다.

스택은 순차적으로 데이터를 추가하고 삭제하기 때문에 ArrayList와 같은 배열 기반의 컬렉션 클래스가 적합하다.

### boolean empty( )

- 스택이 비어있는지 여부를 확인한다.

### Object peek( )

- 스택의 가장 최근(맨 위)에 저장된 객체를 반환한다.
- 만약, 스택이 비었다면 EmptyStackException이 발생한다.

### Object pop( )

- 스택의 가장 최근(맨 위)에 저장된 객체를 꺼낸다.
- 만약, 스택이 비었다면 EmptyStackException이 발생한다.

### Object push( Object item )

- 스택에 객체를 저장한다.

### int search( Object o )

- 스택에 주어진 객체를 찾아서 해당 위치를 반환한다.
- 만약, 주어진 객체를 찾지 못하면 -1을 반환한다.

## Queue 란?

큐는 FIFO(First In First Out) 구조로 이루어져 있으며, 스택과 반대로 선입 선출이다.

- 즉, 먼저 넣은 요소(오래된 요소)를 먼저 뺀다는 의미이다.

큐는 데이터를 꺼낼 때 항상 첫 번째에 저장된 데이터를 삭제하므로 배열 기반의 클래스는 비효율적이다.

- 데이터를 꺼낼 때마다 빈 공간을 채우기 위해 데이터의 복사가 발생하기 때문이다.

때문에 큐는 데이터의 추가 및 삭제가 쉬운 LinkedList로 구현하는 것이 더 효율적이다.

### boolean add( Object o )

- 지정된 객체를 큐에 추가한다.
- 만약, 저장 공간이 부족하면 IllegalStateException이 발생한다.

### Object remove( )

- 큐에서 객체를 꺼내서 반환한다.
- 만약, 큐가 비었다면 NoSuchElementException이 발생한다.

### Object element( )

- 삭제없이 요소를 읽어온다.
- 만약, 큐가 비었다면 NoSuchElementException이 발생한다.

### boolean offer( Object o )

- 큐에 객체를 저장한다.

### Object poll( )

- 큐의 가장 처음(맨 아래)에 저장된 객체를 꺼낸다.
- 만약, 큐가 비었다면 NULL을 반환한다.

### Object peek( )

- 큐의 가장 처음(맨 아래)에 저장된 객체를 반환한다.
- 만약, 큐가 비었다면 NULL을 반환한다.
