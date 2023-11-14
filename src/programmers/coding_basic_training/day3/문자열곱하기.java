package programmers.coding_basic_training.day3;

public class 문자열곱하기 {

    public String solution_for(String my_string, int k) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < k; i++) {

            stringBuilder.append(my_string);
        }

        return stringBuilder.toString();
    }

    public String solution_repeat(String my_string, int k) {

        return my_string.repeat(k);
    }

    public static void main(String[] args) {

        문자열곱하기 multiply = new 문자열곱하기();

        System.out.println("Result For : " + multiply.solution_for("string", 3));
        System.out.println("Result For : " + multiply.solution_for("love", 10));
        System.out.println("=================================================");

        System.out.println("Result Repeat : " + multiply.solution_repeat("string", 3));
        System.out.println("Result Repeat : " + multiply.solution_repeat("love", 10));
    }
}
