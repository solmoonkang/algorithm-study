package algorithms.programmers.coding_basic_introduction.day16;

public class 문자열계산하기 {

    /**
     * [ 문제 설명 ]
     * my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 문자열 my_string이 매개변수로 주어질 때, 수식을 계산한 값을 반환하라.
     */
    public int solution(String my_string) {
        String[] tokens = my_string.split(" ");
        int answer = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i+= 2) {
            String operator = tokens[i];
            int number = Integer.parseInt(tokens[i + 1]);

            if (operator.equals("+")) {
                answer += number;
            } else if (operator.equals("-")) {
                answer -= number;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열계산하기 calculatingTheString = new 문자열계산하기();
        System.out.println("Result: " + calculatingTheString.solution("3 + 4"));
    }
}
