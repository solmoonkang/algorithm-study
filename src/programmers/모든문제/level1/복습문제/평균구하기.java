package programmers.모든문제.level1.복습문제;

public class 평균구하기 {

    public double solution(int[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return (double) answer / arr.length;
    }

    public static void main(String[] args) {
        평균구하기 problem = new 평균구하기();

        int[] arr1 = {1, 2, 3, 4};
        System.out.println("problem = " + problem.solution(arr1));

        int[] arr2 = {5, 5};
        System.out.println("problem = " + problem.solution(arr2));
    }
}
