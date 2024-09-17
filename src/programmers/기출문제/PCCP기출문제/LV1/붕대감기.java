package programmers.기출문제.PCCP기출문제.LV1;

public class 붕대감기 {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;     // 현재 캐릭터 체력
        int attackIndex = 0;            // 공격 정보 추적 인덱스
        int successStreak = 0;          // 연속된 붕대 감기 시간

        // 1초부터 마지막 공격 시간이 도달할 때까지 반복하며, 현재 시간 i가 몬스터의 공격 시간인지 확인
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            // 공격 처리: 현재 시간이 공격 시간과 같으면 몬스터의 공격을 받음
            if (attackIndex < attacks.length && i == attacks[attackIndex][0]) {
                // 몬스터의 공격량에 따라 캐릭터의 체력을 감소
                currentHealth -= attacks[attackIndex][1];

                // attackIndex를 증가시켜 다음 공격으로 넘어감
                attackIndex++;

                // 몬스터의 공격으로 인해 연속 붕대 감기 성공 시간이 초기화
                successStreak = 0;

                if (currentHealth <= 0) return -1;
            // 회복 처리: 현재 시간이 공격 시간이 아닐 경우, 붕대 감기를 지속
            } else {
                // 초당 회복량인 x만큼 체력을 회복
                currentHealth += bandage[1];
                successStreak++;

                // 현재 체력이 최대 체력을 초과하지 않도록 제한
                if (currentHealth > health) currentHealth = health;

                // 추가 회복 처리: 연속 성공 시간이 기술의 시전 시간에 도달하면 추가 회복을 수행
                if (successStreak == bandage[0]) {
                    // 추가 회복량 y만큼 체력을 회복
                    currentHealth += bandage[2];

                    // 현재 체력이 최대 체력을 초과하지 않도록 제한
                    if (currentHealth > health) currentHealth = health;
                    successStreak = 0;
                }
            }
        }

        return currentHealth;
    }

    public static void main(String[] args) {
        붕대감기 bandaging = new 붕대감기();

        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println("bandaging = " + bandaging.solution(bandage1, health1, attacks1));

        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println("bandaging = " + bandaging.solution(bandage2, health2, attacks2));

        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println("bandaging = " + bandaging.solution(bandage3, health3, attacks3));

        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = {{1, 2}, {3, 2}};
        System.out.println("bandaging = " + bandaging.solution(bandage4, health4, attacks4));
    }
}
