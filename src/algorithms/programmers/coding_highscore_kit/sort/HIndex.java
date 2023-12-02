package algorithms.programmers.coding_highscore_kit.sort;

import java.util.Arrays;

public class HIndex {

    // H-Index 는 어떤 과학자가 발표한 논문 N편 중, H번 이상 인용된 논문이 H편 이상이고, 나머지 논문이 H번 이하 인용되었다면, H의 최대값
    // citations 는 과학자가 발표한 논문의 인용 횟수를 담은 배열

    public int solution(int[] citations) {

        // H번 이상 인용된 논문이 H편 이상인 H의 최대값을 구하면 된다

        int answer = 0;

        // 주어진 배열을 오름차순으로 정렬
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            // 여기서 H는 현재 순회 중인 원소를 기준으로, 그보다 인용 횟수가 같거나 많은 논문들의 수
            int H = citations.length - i;

            // 만약, 현재 원소( 인용 횟수 )가 H( 현재 원소 포함 우측에 있는 원소들의 개수 )보다 크거나 같으면,
            if (citations[i] >= H) {
                // 해당 H값을 정답으로 설정하고,
                answer = H;
                // 반복문을 종료
                break;
            }
        }

        // 즉, 배열에서 각 원소를 확인하면서 "남아있는 논문들이 현재 논문만큼 이상 인용되었다면" 해당 값을 정답으로 채택한다
        return answer;
    }

    public static void main(String[] args) {

        HIndex hIndex = new HIndex();

        int[] citations = {3, 0, 6, 1, 5};

        System.out.println("Result : " + hIndex.solution(citations));
    }
}
