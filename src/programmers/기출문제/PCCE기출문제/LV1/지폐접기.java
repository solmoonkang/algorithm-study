package programmers.기출문제.PCCE기출문제.LV1;

import java.util.Arrays;

public class 지폐접기 {

    // TODO: 접는 횟수 증가를 접을 때마다 증가되도록 수정했다. 그리고 매 반복 후 bill을 정렬하여 항상 작은 값이 bill[0]에 오도록 했다.
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);

        int answer = 0;
        Arrays.sort(bill);

        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            if (bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
            answer++;
            Arrays.sort(bill);
        }

        return answer;
    }

    public static void main(String[] args) {
        지폐접기 problem = new 지폐접기();

        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};
        System.out.println("problem = " + problem.solution(wallet1, bill1));

        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};
        System.out.println("problem = " + problem.solution(wallet2, bill2));
    }
}
