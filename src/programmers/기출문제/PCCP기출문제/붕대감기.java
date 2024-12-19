package programmers.기출문제.PCCP기출문제;

public class 붕대감기 {

    private static final int CHARACTER_DEAD = -1;

    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int attackIndex = 0;
        int successCharacterRecoveryTime = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (attackIndex < attacks.length && i == attacks[attackIndex][0]) {
                currentHealth -= attacks[attackIndex][1];
                attackIndex++;
                successCharacterRecoveryTime = 0;

                if (currentHealth <= 0) return CHARACTER_DEAD;
            } else {
                currentHealth += bandage[1];
                successCharacterRecoveryTime++;

                if (currentHealth > health) currentHealth = health;

                if (successCharacterRecoveryTime == bandage[0]) {
                    currentHealth += bandage[2];
                    if (currentHealth > health) currentHealth = health;
                    successCharacterRecoveryTime = 0;
                }
            }
        }

        return currentHealth;
    }

    public static void main(String[] args) {
        붕대감기 bandage = new 붕대감기();

        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println("bandage = " + bandage.solution(bandage1, health1, attacks1));

        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println("bandage = " + bandage.solution(bandage2, health2, attacks2));

        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println("bandage = " + bandage.solution(bandage3, health3, attacks3));

        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = {{1, 2}, {3, 2}};
        System.out.println("bandage = " + bandage.solution(bandage4, health4, attacks4));
    }
}
