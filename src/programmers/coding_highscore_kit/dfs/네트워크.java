package programmers.coding_highscore_kit.dfs;

public class 네트워크 {

    public int solution(int n, int[][] computers) {

        // 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때,

        // 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있다 -> 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있다

        // 컴퓨터의 개수 N개, 연결에 대한 정보가 담긴 2차원 배열 Computers 가 매개변수로 주어질 때, 네트워크의 개수를 반환하라

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        네트워크 network = new 네트워크();

        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println("Result : " + network.solution(3, computers));
    }
}
