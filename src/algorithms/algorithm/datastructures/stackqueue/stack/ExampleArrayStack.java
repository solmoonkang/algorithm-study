package algorithms.algorithm.datastructures.stackqueue.stack;

public class ExampleArrayStack {

    private int top;
    private int maxSize;
    private Object[] stackArray;

    // 스택 배열을 생성하고, 스택 배열의 크기를 maxSize 로 설정
    public ExampleArrayStack(int maxSize) {

        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }

    // 스택이 비어있는지 확인
    public boolean empty() {

        return (top == -1);
    }

    // 스택이 가득 찼는지 확인
    public boolean full() {

        return (top == maxSize - 1);
    }

    // 스택에 item 삽입
    public void push(Object item) {

        if (full()) {

            throw new ArrayIndexOutOfBoundsException((top + 1) + ">=" + maxSize);
        }

        stackArray[++top] = item;
    }

    // 스택의 가장 위의 데이터 반환
    public Object peek() {

        if (empty()) {

            throw new ArrayIndexOutOfBoundsException(top);
        }

        return stackArray[top];
    }

    // 스택의 가장 위의 데이터 삭제
    public Object pop() {

        Object item = peek();

        top--;

        return item;
    }
}
