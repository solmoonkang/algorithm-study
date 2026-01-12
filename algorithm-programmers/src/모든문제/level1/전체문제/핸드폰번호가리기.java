package 모든문제.level1.전체문제;

public class 핸드폰번호가리기 {

    /**
     * [ 문제 설명 ]
     * 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
     * 전화번호가 문자열 phone_number로 주어졌을 때,
     * 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
     */
    public String solution(String phone_number) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < phone_number.length() - 4; i++) {
            builder.append("*");
        }

        builder.append(phone_number.substring(phone_number.length() - 4));
        return builder.toString();
    }

    public String refactoring(String phone_number) {
        int length = phone_number.length();
        String hideNumber = phone_number.substring(0, length - 4);
        String backNumber = phone_number.substring(hideNumber.length());
        // "." 는 hideNumber의 모든 문자열을 의미한다. 따라서 replaceAll(".", "*")은 모든 문자열을 "*"로 바꾼다는 것을 의미한다.
        return hideNumber.replaceAll(".", "*") + backNumber;
    }

    public static void main(String[] args) {
        핸드폰번호가리기 hidingPhoneNumber = new 핸드폰번호가리기();
        System.out.println("Result: " + hidingPhoneNumber.solution("01033334444"));
        System.out.println("Result: " + hidingPhoneNumber.solution("027778888"));

        System.out.println("Refactor: " + hidingPhoneNumber.refactoring("01033334444"));
        System.out.println("Refactor: " + hidingPhoneNumber.refactoring("027778888"));
    }
}
