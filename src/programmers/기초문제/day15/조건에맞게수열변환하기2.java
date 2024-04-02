package programmers.기초문제.day15;

public class 조건에맞게수열변환하기2 {

    public int solution(int[] arr) {

        // arr 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고
        // 50보다 작은 홀수라면 2를 곱하고 다시 1을 더한다

        // 이러한 작업을 x번 반복한 결과인 배열을 arr(x)라고 한다면, arr(x) = arr(x + 1)인 x가 항상 존재한다
        // 이러한 x 중 가장 작은 값을 반환하라

        int answer = 0;
        int count = 0;

        while (count != arr.length) {

            count = 0;

            int[] compare = arr.clone();

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] >= 50 && arr[i] % 2 == 0) {

                    arr[i] /= 2;

                } else if (arr[i] < 50 && arr[i] % 2 == 1) {

                    arr[i] = (arr[i] * 2) + 1;

                } else if (arr[i] == compare[i]) count++;
            }

            answer++;
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        조건에맞게수열변환하기2 sequence = new 조건에맞게수열변환하기2();

        int[] arr = {1, 2, 3, 100, 99, 98};

        System.out.println("Result : " + sequence.solution(arr));
    }
}
