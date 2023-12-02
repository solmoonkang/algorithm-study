package algorithms.programmers.coding_basic_training.day10;

public class 문자열의앞의N글자 {

    public String solution(String my_string, int n) {

        // 문자열과 정수가 매개변수로 주어질 때, my_string 의 앞에 n 글자로 이루어진 문자열을 반환하라

        StringBuilder answer = new StringBuilder(my_string);

        for (int i = 0; i < my_string.length(); i++) {

            String str = my_string.substring(0, n);

            StringBuilder builder = new StringBuilder(str);

            answer = builder.replace(0, n, str);
        }

        return answer.toString();
    }

    public String others(String my_string, int n) {

        return my_string.substring(0, n);
    }

    public static void main(String[] args) {

        문자열의앞의N글자 n = new 문자열의앞의N글자();

        System.out.println("Result : " + n.solution("ProgrammerS123", 11));
        System.out.println("Result : " + n.solution("He110W0r1d", 5));

        System.out.println("Result : " + n.others("ProgrammerS123", 11));
    }
}
