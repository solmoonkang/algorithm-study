package programmers.coding_basic_training.level0.day2;

public class 문자열겹쳐쓰기 {

    /**
     * 문제 설명
     * 문자열 my_string, overwrite_string 과 정수 s가 주어집니다.
     * 문자열 my_string 의 인덱스 s부터 overwrite_string 의 길이만큼을 문자열 overwrite_string 으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
     *
     * 제한 사항
     * my_string 와 overwrite_string 은 숫자와 알파벳으로 이루어져 있습니다.
     * 1 ≤ overwrite_string 의 길이 ≤ my_string 의 길이 ≤ 1,000
     * 0 ≤ s ≤ my_string 의 길이 - overwrite_string 의 길이
     */

    public String solution_best(String my_string, String overwrite_string, int s) {

        String answer = my_string.substring(0, s) + overwrite_string;

        if (my_string.length() > answer.length()) {

            answer += my_string.substring(answer.length());
        }

        return answer;
    }

    public String solution_best2(String my_string, String overwrite_string, int s) {

        String before = my_string.substring(0, s);

        String after = my_string.substring(s + overwrite_string.length());

        return before + overwrite_string + after;
    }

    public static void main(String[] args) {

        문자열겹쳐쓰기 c = new 문자열겹쳐쓰기();

        System.out.println("Result Best : " + c.solution_best("He11oWor1d", "lloWorl", 2));
        System.out.println("Result Best : " + c.solution_best("Program29b8UYP", "merS123", 7));
        System.out.println("======================================================");

        System.out.println("Result Best2 : " + c.solution_best2("He11oWor1d", "lloWorl", 2));
        System.out.println("Result Best2 : " + c.solution_best2("Program29b8UYP", "merS123", 7));
    }
}
