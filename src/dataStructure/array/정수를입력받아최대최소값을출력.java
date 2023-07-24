package dataStructure.array;

import java.util.Arrays;
import java.util.Scanner;

public class 정수를입력받아최대최소값을출력 {

    // 5개의 정수를 입력받아 배열의 값들을 출력하고, 최대/최소값을 출력

    public static void main(String[] args) {

        System.out.println("====== 입력받은 정수를 배열에 담아 출력 ======");
        System.out.println("5개의 정수를 입력해주세요!");

        int[] arr = new int[5];     // arr 배열 선언

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {

            arr[i] = scanner.nextInt();     // 데이터 입력 및 배열에 저장
        }

        // 입력받은 배열의 값들을 출력
        System.out.println("배열의 모든 값들은 : " + Arrays.toString(arr));

        Arrays.sort(arr);       // 배열 정렬

        System.out.println("정렬된 배열의 모든 값들은 : " + Arrays.toString(arr));

        System.out.println("====== 입력받은 정수의 최대/최소값을 출력 ======");

        int max = arr[0];       // 최대값 변수 선언 및 초기 설정
        int min = arr[0];       // 최소값 변수 선언 및 초기 설정

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {     // 최대값을 비교

                max = arr[i];       // 최대값을 할당
            }

            if (min > arr[i]) {     // 최소값을 비교

                min = arr[i];       // 최소값을 할당
            }
        }

        System.out.println("Min : " + min);
        System.out.println("Max : " + max);

        System.out.println("====== 입력받은 정수의 합계를 출력 ======");

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];      // 입력받은 정수의 값들을 더한 값을 sum 에 저장 및 더함
        }

        // 향상된 for 문으로 처리하는 방법
//        for (int i : arr) {
//
//            sum += i;
//        }

        System.out.println("Sum : " + sum);
    }
}
