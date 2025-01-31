package 입문문제.day12;

public class 숨어있는숫자의덧셈 {

    /**
     * [ 문제 설명 ]
     * 문자열 my_string이 매개변수로 주어집니다. my_string안의 모든 자연수들의 합을 반환하라.
     */
    public int my_solution(String my_string) {
        String revert = my_string.replaceAll("\\D", "");
        int answer = 0;

        for (int i = 0; i < revert.length(); i++) {
            int value = Integer.parseInt(String.valueOf(revert.charAt(i)));
            answer += value;
        }
        return answer;
    }

    public int solution(String my_string) {
        return my_string.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sum();
    }

    public static void main(String[] args) {
        숨어있는숫자의덧셈 additionOfHiddenNumbers = new 숨어있는숫자의덧셈();
        System.out.println("Result: " + additionOfHiddenNumbers.solution("aAb1B2cC34oOp"));
        System.out.println("Result: " + additionOfHiddenNumbers.solution("1a2b3c4d123"));
    }
}
