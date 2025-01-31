package 입문문제.day18;

public class 세균증식 {

    /**
     * [ 문제 설명 ]
     * 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
     * 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수 반환하라.
     */
    public int solution(int n, int t) {
        int answer = n;
        for (int i = 1; i <= t; i++) {
            answer *= 2;
        }
        return answer;

        // return n * (int) Math.pow(2, t);
    }

    public static void main(String[] args) {
        세균증식 bacterialProliferation = new 세균증식();
        System.out.println("Result: " + bacterialProliferation.solution(2, 10));
        System.out.println("Result: " + bacterialProliferation.solution(7, 15));
    }
}
