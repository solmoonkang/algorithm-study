package programmers.입문문제.day4;

public class 배열의평균값 {

    /**
     * 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소의 평균값을 반환하라
     */
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            answer = (double) sum / numbers.length;
        }
        return answer;
    }

    public static void main(String[] args) {
        배열의평균값 average = new 배열의평균값();
        int[] firstNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondNumbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        System.out.println("Result: " + average.solution(firstNumbers));
        System.out.println("Result: " + average.solution(secondNumbers));
    }
}
