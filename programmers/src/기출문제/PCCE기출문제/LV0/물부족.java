package 기출문제.PCCE기출문제.LV0;

public class 물부족 {

    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage = usage * (100 + change[i]) / 100;
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        물부족 problem = new 물부족();

        int[] change1 = {10, -10, 10, -10, 10, -10, 10, -10, 10, -10};
        System.out.println("problem = " + problem.solution(5141, 500, change1));

        int[] change2 = {-10, 25, -33};
        System.out.println("problem = " + problem.solution(1000, 2000, change2));
    }
}
