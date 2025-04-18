package 기출문제.월간코드챌린지시즌1;

public class 내적 {

    /**
     * [ 문제 설명 ]
     * 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
     * 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
     */
    public int solution(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        내적 dotProduct = new 내적();
        int[] firstA = {1,2,3,4};
        int[] firstB = {-3,-1,0,2};
        System.out.println("Result: " + dotProduct.solution(firstA, firstB));
        int[] secondA = {-1,0,1};
        int[] secondB = {1,0,-1};
        System.out.println("Result: " + dotProduct.solution(secondA, secondB));
    }
}
