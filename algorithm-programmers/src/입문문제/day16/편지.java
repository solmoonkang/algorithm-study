package 입문문제.day16;

public class 편지 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 할머니께 생신 축하 편지를 쓰려고 합니다.
     * 할머니가 보시기 편하도록 글자 한 자 한 자를 가로 2cm 크기로 적으려고 하며, 편지를 가로로만 적을 때,
     * 축하 문구 message를 적기 위해 필요한 편지지의 최소 가로길이를 반환하라.
     */
    public int solution(String message) {
        return message.length() * 2;
    }

    public static void main(String[] args) {
        편지 letter = new 편지();
        System.out.println("Result: " + letter.solution("happy birthday!"));
        System.out.println("Result: " + letter.solution("I love you~"));
    }
}
