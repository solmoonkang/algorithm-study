package algorithms.programmers.coding_basic_introduction.day14;

public class 삼육구게임 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 친구들과 369게임을 하고 있습니다.
     * 369게임은 1부터 숫자를 하나씩 대며 3, 6, 9가 들어가는 숫자는 숫자 대신 3, 6, 9의 개수만큼 박수를 치는 게임입니다.
     * 머쓱이가 말해야하는 숫자 order가 매개변수로 주어질 때, 머쓱이가 쳐야할 박수 횟수를 반환하라.
     */
    public int solution(int order) {
        int count = 0;
        String str = String.valueOf(order);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        삼육구게임 game = new 삼육구게임();
        System.out.println("Result: " + game.solution(3));
        System.out.println("Result: " + game.solution(29423));
    }
}
