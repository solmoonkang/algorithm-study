package programmers.모든문제.level1.복습문제;

public class 푸드파이트대회 {

    public String solution(int[] food) {
        StringBuilder foodDisplay = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            foodDisplay.append(String.valueOf(i).repeat(Math.max(0, food[i] / 2)));
        }

        StringBuilder reverseFoodDisplay = new StringBuilder(foodDisplay);
        reverseFoodDisplay.reverse();
        return foodDisplay.append("0").append(reverseFoodDisplay).toString();
    }

    public static void main(String[] args) {
        푸드파이트대회 problem = new 푸드파이트대회();

        int[] food1 = {1, 3, 4, 6};
        System.out.println("problem = " + problem.solution(food1));

        int[] food2 = {1, 7, 1, 2};
        System.out.println("problem = " + problem.solution(food2));
    }
}
