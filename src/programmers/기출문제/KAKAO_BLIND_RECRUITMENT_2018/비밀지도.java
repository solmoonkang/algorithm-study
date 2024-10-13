package programmers.기출문제.KAKAO_BLIND_RECRUITMENT_2018;

import java.util.Arrays;

public class 비밀지도 {

    // TODO: 런타임 에러가 발생했다. 이진 문자열 변환 후 바로 정수형으로 변환하는 것은 의미가 없다.
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            int convertStringArr1 = Integer.parseInt(Integer.toBinaryString(arr1[i]));
            int convertStringArr2 = Integer.parseInt(Integer.toBinaryString(arr2[i]));

            answer[i] = String.valueOf(convertStringArr1 + convertStringArr2)
                    .replace("2", "1").replace("1", "#").replace("0", " ");
        }

        return answer;
    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // arr1과 arr2의 해당 행을 비트 OR 연산하여 새로운 값을 만듭니다.
            int combined = arr1[i] | arr2[i];
            // 이진수 문자열로 변환하고, 길이를 n으로 맞추기 위해 0을 채웁니다.
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(combined)).replace(' ', '0');
            // '#'과 ' '로 변환
            answer[i] = binaryString.replace('1', '#').replace('0', ' ');
        }

        return answer;
    }

    public static void main(String[] args) {
        비밀지도 problem = new 비밀지도();

        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println("problem = " + Arrays.toString(problem.solution(5, arr1, arr2)));
    }
}
