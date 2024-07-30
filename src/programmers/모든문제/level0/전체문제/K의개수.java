package programmers.모든문제.level0.전체문제;

public class K의개수 {

    // TODO: forDigit라는 메서드를 처음 알게 됌.
    public int solution(int i, int j, int k) {
        int count = 0;

        for (int index = i; index <= j; index++) {
            String convertIndex = String.valueOf(index);
            for (char c : convertIndex.toCharArray()) {
                if (c == Character.forDigit(k, 10)) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        K의개수 numberOfK = new K의개수();

        System.out.println("numberOfK = " + numberOfK.solution(1, 13, 1));
        System.out.println("numberOfK = " + numberOfK.solution(10, 50, 5));
        System.out.println("numberOfK = " + numberOfK.solution(3, 10, 2));
    }
}
