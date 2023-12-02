package algorithms.programmers.coding_all_problem.level1;

public class 자릿수더하기 {

    /**
     * [ 문제 설명 ]
     * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
     */
    public int solution(int n) {
        int answer = 0;
        String convert = String.valueOf(n);
        for (int i = 0; i < convert.length(); i++) {
            char c = convert.charAt(i);
            answer += Character.getNumericValue(c);
        }
        return answer;
    }

    public static void main(String[] args) {
        자릿수더하기 addingDigits = new 자릿수더하기();
        System.out.println("Result: " + addingDigits.solution(123));
        System.out.println("Result: " + addingDigits.solution(987));
    }
}
