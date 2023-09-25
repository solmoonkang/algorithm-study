package programmers.coding_basic_training.level0.day11;

import java.util.Arrays;

public class 글자지우기 {

    public String solution(String my_string, int[] indices) {

        // 문자열에서 특정 문자를 제거하려면, 일반적으로 StringBuilder를 사용하는 것이 효율적이다

        // my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고, 이어 붙인 문자열을 반환하라
        StringBuilder answer = new StringBuilder(my_string);

        // 인덱스 배열을 내림차순 정렬 -> 높은 인덱스부터 낮은 인덱스의 위치가 변경되지 않는다
        Arrays.sort(indices);

        // 배열이나 문자열에서 요소를 제거할 때, 인덱스의 변화에 따른 문제를 방지하기 위함

        // 즉, 배열이나 문자열에서 특정 위치의 요소를 제거하면, 그 뒤의 모든 요소들의 인덱스가 하나씩 앞으로 당겨진다
        // 따라서 앞에서부터 삭제를 하면, 삭제 과정 중에 다음에 삭제할 요소의 인덱스가 바뀌게 된다

        // 이로 인해서 반복문을 역순으로 실행하여 뒤쪽부터 요소를 제거하는 형식으로 반복문을 구성
        for (int i = indices.length - 1; i >= 0; i--) {

            answer.deleteCharAt(indices[i]);
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        글자지우기 remove = new 글자지우기();

        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        System.out.println("Result : " + remove.solution("apporoograpemmemprs", indices));
    }
}
