package 기초문제.day10;

public class QrCode {

    public String solution(int q, int r, String code) {

        // code 의 각 인덱스를 q로 나누었을 때, 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 반환하라

        // 문자열의 각 인덱스를 q로 나누었을 때, 나머지가 r인 인덱스들의 문자를 순서대로 이어붙여라
        String answer = "";

        for (int i = r; i < code.length(); i += q) {

           answer += code.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        QrCode qrCode = new QrCode();

        System.out.println("Result : " + qrCode.solution(3, 1, "qjnwezgrpirldywt"));
        System.out.println("Result : " + qrCode.solution(1, 0, "programmers"));
    }
}
