package programmers.coding_basic_training.day20;

public class 배열비교하기 {

    public int solution(int[] arr1, int[] arr2) {

        // 두 배열의 길이가 다르다면, 배열의 길이가 긴 쪽이 더 크다

        // 두 배열의 길이가 같다면, 각 배열에 있는 모든 원소의 합을 비교한다
            // 합이 다르다면 더 큰 쪽이 크고, 합이 같다면 같다

        // 위에서 정의한 배열의 대소관계에 대하여
            // arr2 가 크다면 -1을, arr1 이 크다면 1을, 두 배열이 같다면 0을 반환하라

        int answer = 0;

        int arr1_sum = 0;
        int arr2_sum = 0;

        if (arr1.length != arr2.length) {

            if (arr1.length < arr2.length) {

                answer = -1;

            } else {

                answer = 1;

            }

        } else {

            for (int i = 0; i < arr1.length; i++) {

                arr1_sum += arr1[i];
                arr2_sum += arr2[i];

                if (arr1_sum < arr2_sum) {

                    answer = -1;

                } else if (arr1_sum > arr2_sum) {

                    answer = 1;

                } else {

                    answer = 0;

                }

            }

        }

        return answer;
    }

    public static void main(String[] args) {

        배열비교하기 compare = new 배열비교하기();

        int[] first_arr1 = {49, 13};
        int[] second_arr1 = {100, 17, 84, 1};
        int[] third_arr1 = {1, 2, 3, 4, 5};

        int[] first_arr2 = {70, 11, 2};
        int[] second_arr2 = {55, 12, 65, 36};
        int[] third_arr2 = {3, 3, 3, 3, 3};

        System.out.println("Result : " + compare.solution(first_arr1, first_arr2));
        System.out.println("Result : " + compare.solution(second_arr1, second_arr2));
        System.out.println("Result : " + compare.solution(third_arr1, third_arr2));
    }
}
