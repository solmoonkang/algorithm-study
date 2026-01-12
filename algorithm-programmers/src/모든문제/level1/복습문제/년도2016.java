package 모든문제.level1.복습문제;

public class 년도2016 {

    public String solution(int a, int b) {
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDays = 0;
        for (int i = 1; i < a; i++) {
            totalDays += daysInMonth[i];
        }

        totalDays += b;
        int dayOfWeeks = (a + totalDays - 1) % 7;

        return weekDays[dayOfWeeks];
    }

    public static void main(String[] args) {
        년도2016 problem = new 년도2016();

        System.out.println("problem = " + problem.solution(5, 24));
    }
}
