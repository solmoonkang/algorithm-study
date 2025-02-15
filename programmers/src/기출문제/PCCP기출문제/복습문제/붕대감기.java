package 기출문제.PCCP기출문제.복습문제;

import java.io.*;
import java.util.StringTokenizer;

public class 붕대감기 {

    private static final int BANDAGE_SIZE = 3;
    private static final int ATTACK_SIZE = 2;
    private static final int HEALTH_DROPS_BELOW_ZERO = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] bandage = new int[BANDAGE_SIZE];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < BANDAGE_SIZE; i++) bandage[i] = Integer.parseInt(stringTokenizer.nextToken());

        int health = Integer.parseInt(bufferedReader.readLine());

        int monsterPattern = Integer.parseInt(bufferedReader.readLine());
        int[][] attacks = new int[monsterPattern][ATTACK_SIZE];

        for (int i = 0; i < monsterPattern; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            attacks[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            attacks[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int currentHealth = getRemainingAfterAllAttacksCompleted(bandage, health, attacks);
        bufferedWriter.write(String.valueOf(currentHealth));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getRemainingAfterAllAttacksCompleted(int[] bandage, int health, int[][] attacks) {
        int maxAttackTime = 0;
        for (int[] attack : attacks) maxAttackTime = Math.max(maxAttackTime, attack[0]);

        int consecutiveSuccessTime = 0;
        int monsterTotalAttackTime = 0;
        int currentHealth = health;

        // 게임 캐릭터가 생존해 있는 시간이 몬스터가 마지막으로 공격하는 시간보다 적을 경우에만 반복한다.
        while (monsterTotalAttackTime < maxAttackTime) {
            // 게임 캐릭터가 생존해 있는 시간을 증가시킨다.
            monsterTotalAttackTime++;

            // 몬스터의 공격 여부를 판단한다.
            boolean isAttacked = false;

            // 몬스터가 공격하는 경우를 계산하기 위해 attacks 배열을 순회한다.
            for (int[] attack : attacks) {

                // 게임 캐릭터가 생존해 있는 시간이 몬스터가 공격하는 시간과 같다면,
                if (monsterTotalAttackTime == attack[0]) {
                    // 현재 체력에서 몬스터가 입히는 피해량을 감소시킨다.
                    currentHealth -= attack[1];
                    // 몬스터에게 공격을 받았으므로, 몬스터의 공격 여부를 TRUE로 설정한다.
                    isAttacked = true;
                    // 몬스터의 공격을 받았으므로, 연속 성공 시간을 0으로 초기화한다.
                    consecutiveSuccessTime = 0;

                    // 현재 체력이 0 이하라면 -1을 반환하고 종료한다.
                    if (currentHealth <= 0) return HEALTH_DROPS_BELOW_ZERO;
                    // 공격이 발생하면 더 이상 회복 로직을 수행하지 않도록 한다.
                    break;
                }
            }

            // 몬스터에게 공격을 받지 않았다면,
            if (!isAttacked) {
                // 연속 성공 시간이 기술 시전 시간보다 작다면,
                if (consecutiveSuccessTime < bandage[0]) {
                    // 현재 체력에서 1초 회복량만큼 증가시킨다.
                    currentHealth += bandage[1];
                    // 현재 체력이 최대 체력보다 크다면 현재 체력을 최대 체력으로 초기화한다.
                    if (currentHealth > health) currentHealth = health;
                    // 연속 성공 시간을 증가시킨다.
                    consecutiveSuccessTime++;

                // 연속 성공 시간이 기술 시전 시간과 같다면,
                } else {
                    // 현재 체력에서 추가 회복량만큼 증가시킨다.
                    currentHealth += bandage[2];
                    // 현재 체력이 최대 체력보다 크다면 현재 체력을 최대 체력으로 초기화한다.
                    if (currentHealth > health) currentHealth = health;
                    // 연속 성공 시간을 0으로 초기화한다.
                    consecutiveSuccessTime = 0;
                }
            }
        }

        return currentHealth;
    }
}
