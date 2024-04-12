package 연습문제풀이.algorithm.정렬;

import java.util.Arrays;

public class SortExample {

    public int[] theKthNumber(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }

    public String theLargestNumber(int[] numbers) {

        // numbers 배열을 문자열로 변환시킨다
        String[] answer = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 조합했을 때, 큰 수가 되도록 정렬한다
        Arrays.sort(answer, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if (answer[0].equals("0")) return "0";

        StringBuilder stringBuilder = new StringBuilder();

        // StringBuilder 를 통해서 append 하여 문자열로 반환한다
        for (int i = 0; i < answer.length; i++) {
            stringBuilder.append(answer[i]);
        }

        return stringBuilder.toString();
    }

    public int H_Index(int[] citations) {

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        SortExample sortExample = new SortExample();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println("The Kth Number : " + Arrays.toString(sortExample.theKthNumber(array, commands)));

        int[] numbers = {6, 10, 2};

        System.out.println("The Largest Number : " + sortExample.theLargestNumber(numbers));
    }
}
