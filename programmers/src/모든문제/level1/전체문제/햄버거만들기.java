package 모든문제.level1.전체문제;

import java.util.Stack;

public class 햄버거만들기 {

    // TODO: 덱이나 카운팅 배열을 이용해서 다시 한 번 풀어보자.
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);

            if (stack.size() >= 4 &&
                    stack.get(stack.size() - 1) == 1 &&
                    stack.get(stack.size() - 2) == 3 &&
                    stack.get(stack.size() - 3) == 2 &&
                    stack.get(stack.size() - 4) == 1) {
                count++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        햄버거만들기 makingAHamburger = new 햄버거만들기();

        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println("makingAHamburger = " + makingAHamburger.solution(ingredient1));

        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println("makingAHamburger = " + makingAHamburger.solution(ingredient2));
    }
}
