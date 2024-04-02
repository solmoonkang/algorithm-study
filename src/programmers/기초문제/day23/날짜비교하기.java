package programmers.기초문제.day23;

public class 날짜비교하기 {

    public int solution(int[] date1, int[] date2) {

        // 두 배열은 각각 날짜를 나타내며, [YEAR, MONTH, DAY] 꼴로 주어진다
        // 만약, date1이 date2보다 앞서는 날짜라면 1을,   아니면 0을 반환하라

        if (date1[0] < date2[0]) {

            return 1;

        } else if (date1[0] > date2[0]) {

            return 0;

        }

        if (date1[1] < date2[1]) {

            return 1;

        } else if (date1[1] > date2[1]) {

            return 0;

        }

        if (date1[2] < date2[2]) {

            return 1;

        } else if (date1[2] > date2[2]) {

            return 0;

        }

        return 0;
    }

    public static void main(String[] args) {

        날짜비교하기 date = new 날짜비교하기();

        int[] date11 = {2021, 12, 28};
        int[] date12 = {1024, 10, 24};

        int[] date21 = {2021, 12, 29};
        int[] date22 = {1024, 10, 24};

        System.out.println("Result : " + date.solution(date11, date21));
        System.out.println("Result : " + date.solution(date12, date22));
    }
}
