package programmers.모든문제.level0.전체문제;

public class 종이자르기 {

    public int solution(int M, int N) {
        return M == 1 && N == 1 ? 0 : M * N - 1;
    }

    public static void main(String[] args) {
        종이자르기 cuttingPaper = new 종이자르기();

        System.out.println("cuttingPaper = " + cuttingPaper.solution(2, 2));
        System.out.println("cuttingPaper = " + cuttingPaper.solution(2, 5));
        System.out.println("cuttingPaper = " + cuttingPaper.solution(1, 1));
    }
}
