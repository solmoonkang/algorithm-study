package programmers.모든문제.level1.복습문제;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0, index2 = 0;

        for (String word : goal) {
            if (index1 < cards1.length && cards1[index1].equals(word)) index1++;
            else if (index2 < cards2.length && cards2[index2].equals(word)) index2++;
            else return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        카드뭉치 problem = new 카드뭉치();

        String[] cards1_1 = {"i", "drink", "water"};
        String[] cards1_2 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println("problem = " + problem.solution(cards1_1, cards2, goal));

        System.out.println("problem = " + problem.solution(cards1_2, cards2, goal));
    }
}
