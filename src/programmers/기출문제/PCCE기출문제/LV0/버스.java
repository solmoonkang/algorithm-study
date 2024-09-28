package programmers.기출문제.PCCE기출문제.LV0;

public class 버스 {

    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;
        for (int i = 0; i < passengers.length; i++) {
            num_passenger += func4(passengers[i]);
            num_passenger -= func3(passengers[i]);
        }

        return func1(seat - num_passenger);
    }

    public int func1(int num) {
        return Math.max(0, num);
    }

    public int func2(int num) {
        return Math.min(num, 0);
    }

    public int func3(String[] station) {
        int num = 0;
        for (String s : station) {
            if (s.equals("Off")) num += 1;
        }

        return num;
    }

    public int func4(String[] station) {
        int num = 0;
        for (String s : station) {
            if (s.equals("On")) num += 1;
        }

        return num;
    }

    public static void main(String[] args) {
        버스 problem = new 버스();

        String[][] passengers1 = {{"On", "On", "On"}, {"Off", "On", "-"}, {"Off", "-", "-"}};
        System.out.println("problem = " + problem.solution(5, passengers1));

        String[][] passengers2 = {{"On", "On", "On", "On", "On", "On", "On", "On", "-", "-"}, {"On", "On", "Off", "Off", "Off", "On", "On", "-", "-", "-"}, {"On", "On", "On", "Off", "On", "On", "On", "Off", "Off", "Off"}, {"On", "On", "Off", "-", "-", "-", "-", "-", "-", "-"}};
        System.out.println("problem = " + problem.solution(10, passengers2));
    }
}
