package 입문문제.day19;

public class 머쓱이보다키큰사람 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다.
     * 머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때, 머쓱이보다 키 큰 사람 수를 반환하라.
     */
    public int solution(int[] array, int height) {
        int taller = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) {
                taller++;
            }
        }
        return taller;
    }

    public static void main(String[] args) {
        머쓱이보다키큰사람 personTallerThanMoseugi = new 머쓱이보다키큰사람();
        int[] firstArray = {149, 180, 192, 170};
        int[] secondArray = {180, 120, 140};
        System.out.println("Result: " + personTallerThanMoseugi.solution(firstArray, 167));
        System.out.println("Result: " + personTallerThanMoseugi.solution(secondArray, 190));
    }
}
