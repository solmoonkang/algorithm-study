package 기출문제.월간코드챌린지시즌1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두개뽑아서더하기 {

    /**
     * [ 문제 설명 ]
     * 정수 배열 numbers가 주어집니다.
     * numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
     * 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * numbers의 길이는 2 이상 100 이하입니다.
     *  - numbers의 모든 수는 0 이상 100 이하입니다.
     */
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }

        return list.stream().mapToInt(i -> i).sorted().distinct().toArray();
    }

    public static void main(String[] args) {
        두개뽑아서더하기 pickAndAdd = new 두개뽑아서더하기();

        int[] firstNumbers = {2,1,3,4,1};
        System.out.println("pickAndAdd = " + Arrays.toString(pickAndAdd.solution(firstNumbers)));

        int[] secondNumbers = {5,0,2,7};
        System.out.println("pickAndAdd = " + Arrays.toString(pickAndAdd.solution(secondNumbers)));
    }
}
