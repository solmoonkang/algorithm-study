package 모든문제.level1.전체문제;

public class 수박수박수박수박수박수 {

    /**
     * [ 문제 설명 ]
     * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
     * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
     */
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                builder.append("수");
            } else {
                builder.append("박");
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 watermelon = new 수박수박수박수박수박수();
        System.out.println("Result: " + watermelon.solution(3));
        System.out.println("Result: " + watermelon.solution(4));
    }
}
