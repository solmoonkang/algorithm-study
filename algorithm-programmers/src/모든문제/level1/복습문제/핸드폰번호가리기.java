package 모든문제.level1.복습문제;

public class 핸드폰번호가리기 {

    public String solution(String phone_number) {
        StringBuilder builder = new StringBuilder();
        builder.append("*".repeat(Math.max(0, phone_number.length() - 4)));
        builder.append(phone_number.substring(phone_number.length() - 4));

        return builder.toString();
    }

    public static void main(String[] args) {
        핸드폰번호가리기 problem = new 핸드폰번호가리기();

        System.out.println("problem = " + problem.solution("01033334444"));
        System.out.println("problem = " + problem.solution("027778888"));
    }
}
