package programmers.coding_highscore_kit.greedy;

import java.util.Arrays;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {

        // 전체 학생 수에서 잃어버린 학생의 수를 뺀 값을 초기 값으로 설정
        // 즉, 모든 학생들이 기본적으로 한 벌의 체육복을 가지고 있다고 가정
        int answer = n - lost.length;

        // 1. 선택 절차
        // 학생 번호를 기준으로 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 2. 적절성 검사
        // 여벌 체육복을 가져온 학생이 도난당한 경우, 즉 실제로 체육복이 없지 않은 사람을 탐색
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {

                // 만약, 찾으면 answer 값을 증가시키고, 해당 원소를 사용하지 못하게 -1로 설정
                if (lost[i] == reserve[j]) {    // 여벌 체육복을 가진 학생이 체육복을 잃어버린 경우,
                    answer++;                   // 체육복을 빌려받은 학생 수 증가
                    reserve[j] = -1;            // 빌려준 학생은 더 이상 빌려줄 수 없도록 표시
                    break;
                }
            }
        }

        // 3. 해답 검사
        // 도난당한 학생에게 체육복을 빌려주는 경우,
        // 즉, 남아있는 여분의 체육복 중 앞 번호나 뒷 번호인 사람에게 빌리도록 하는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {

                // 만약, 성공적으로 빌리면, answer 값을 증가시키고, 해당 원소를 사용하지 못하게 -1로 설정
                // lost[i] - 1 : 체육복을 잃어버린 학생의 왼쪽 번호, lost[i] + 1 : 체육복을 잃어버린 학생의 오른쪽 번호
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        체육복 workoutClothes = new 체육복();

        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println("Result : " + workoutClothes.solution(5, lost, reserve));
    }
}
