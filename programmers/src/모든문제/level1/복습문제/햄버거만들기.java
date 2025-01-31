package 모든문제.level1.복습문제;

import java.util.ArrayDeque;
import java.util.Deque;

public class 햄버거만들기 {

    // TODO: 시간 초과로 인해 테스트 실패, 다른 방법으로 다시 풀어보자.
    public int solution(int[] ingredient) {
        int hamburger = 0;
        Deque<Integer> ingredientDeque = new ArrayDeque<>();

        for (int element : ingredient) {
            ingredientDeque.offerLast(element);

            if (ingredientDeque.size() >= 4) {
                if (ingredientDeque.peekLast() == 1 &&
                        ingredientDeque.toArray()[ingredientDeque.size() - 2].equals(3) &&
                        ingredientDeque.toArray()[ingredientDeque.size() - 3].equals(2) &&
                        ingredientDeque.toArray()[ingredientDeque.size() - 4].equals(1)) {
                    hamburger++;

                    ingredientDeque.removeLast();
                    ingredientDeque.removeLast();
                    ingredientDeque.removeLast();
                    ingredientDeque.removeLast();
                }
            }
        }

        return hamburger;
    }

    public static void main(String[] args) {
        햄버거만들기 problem = new 햄버거만들기();

        int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println("problem = " + problem.solution(ingredient1));

        int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println("problem = " + problem.solution(ingredient2));
    }
}
