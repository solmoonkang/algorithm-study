package programmers.입문문제.day19;

public class 칠의개수 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 반환하라.
     */
    public int solution(int[] array) {
        // array 배열의 원소를 String으로 만들고, 이를 char형으로 변환하여 7의 개수를 count++ 시켜서 값을 반환한다.
        int count = 0;
        for (int a : array) {
            String str = Integer.toString(a);
            for (char c : str.toCharArray()) {
                if (c == '7') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        칠의개수 numberOfSevens = new 칠의개수();
        int[] firstArray = {7, 77, 17};
        int[] secondArray = {10, 29};
        System.out.println("Result: " + numberOfSevens.solution(firstArray));
        System.out.println("Result: " + numberOfSevens.solution(secondArray));
    }
}
