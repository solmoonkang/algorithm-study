package algorithms.programmers.coding_basic_training.day14;

import java.util.ArrayList;
import java.util.Arrays;

public class 할일목록 {

    public String[] solution(String[] todo_list, boolean[] finished) {

        // 오늘 해야 할 일이 담긴 문자열 배열 todo_list 와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished 가 매개변수로 주어질 때,
        // todo_list 에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < todo_list.length; i++) {

            if (!finished[i]) {

                list.add(todo_list[i]);

            }
        }

        String[] answer = list.stream().toArray(String[]::new);

        return answer;
    }

    public static void main(String[] args) {

        할일목록 todoList = new 할일목록();

        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        System.out.println("Result : " + Arrays.toString(todoList.solution(todo_list, finished)));
    }
}
