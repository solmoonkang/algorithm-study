package 연습문제풀이.java_utils.math.recursive;

public class HelloWorldPrinter {

    /**
     * 재귀함수란 함수가 자기 자신을 다시 호출하는 방식을 의미한다.
     * 이는 문제를 더 작은 하위 문제로 분해하고, 각 하위 문제의 결과를 이용해 원래 문제를 해결하는 방법이다.
     *
     * 재귀함수는 반복문 없이 반복적인 수행을 할 수 있다. 또한, 재귀함수는 문제를 간결하고 이해하기 쉬운 형태로 표현할 수 있다.
     * 그러나, 재귀호출의 깊이가 너무 깊어지면, 스택 오버플로우가 발생할 수 있으므로 주의해야 한다.
     */

    public void printer(int n) {
        helloWorld(n);
    }

    private void helloWorld(int n) {
        // 즉, 해당 과정이 반복되어 n이 0이 되면, 재귀 호출이 종료되고 "HELLO WORLD!"가 n번 출력된다.

        // helloWorld 함수는 n이 0이 될 때까지 자기 자신을 호출한다.
        if (n == 0) {
            return;
        }
        // 각 호출마다 "HELLO WORLD!"를 출력한다.
        System.out.println("HELLO WORLD!");
        // 그리고 n을 1씩 감소시킨다.
        helloWorld(n - 1);
    }

    public static void main(String[] args) {
        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        helloWorldPrinter.printer(1);
    }
}
