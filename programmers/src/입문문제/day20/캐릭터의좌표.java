package 입문문제.day20;

import java.util.Arrays;

public class 캐릭터의좌표 {

    /**
     * [ 문제 설명 ]
     * 머쓱이는 RPG게임을 하고 있습니다.
     * 게임에는 up, down, left, right 방향키가 있으며 각 키를 누르면 위, 아래, 왼쪽, 오른쪽으로 한 칸씩 이동합니다.
     * 예를 들어 [0,0]에서
     * up을 누른다면 캐릭터의 좌표는 [0, 1],
     * down을 누른다면 [0, -1],
     * left를 누른다면 [-1, 0],
     * right를 누른다면 [1, 0]입니다.
     * 머쓱이가 입력한 방향키의 배열 keyinput와 맵의 크기 board이 매개변수로 주어집니다.
     * 캐릭터는 항상 [0,0]에서 시작할 때 키 입력이 모두 끝난 뒤에 캐릭터의 좌표 [x, y]를 반환하라.
     *
     * [0, 0]은 board의 정 중앙에 위치합니다.
     * 예를 들어 board의 가로 크기가 9라면 캐릭터는 왼쪽으로 최대 [-4, 0]까지 오른쪽으로 최대 [4, 0]까지 이동할 수 있습니다.
     */

    /**
     * [ 제한 사항 ]
     * board은 [가로 크기, 세로 크기] 형태로 주어집니다.
     * board의 가로 크기와 세로 크기는 홀수입니다.
     * board의 크기를 벗어난 방향키 입력은 무시합니다.
     * keyinput은 항상 up, down, left, right만 주어집니다.
     */
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        int width = (board[0] - 1) / 2;
        int height = (board[1] - 1) / 2;

        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("left")) {
                answer[0] = Math.max(answer[0] - 1, -width);
            } else if (keyinput[i].equals("right")) {
                answer[0] = Math.min(answer[0] + 1, width);
            } else if (keyinput[i].equals("up")) {
                answer[1] = Math.min(answer[1] + 1, height);
            } else {
                answer[1] = Math.max(answer[1] - 1, -height);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        캐릭터의좌표 coordinatesOfCharacter = new 캐릭터의좌표();
        String[] firstKeyInputs = {"left", "right", "up", "right", "right"};
        String[] secondKeyInputs = {"down", "down", "down", "down", "down"};
        int[] firstBoards = {11, 11};
        int[] secondBoards = {7, 9};
        System.out.println("Result: " + Arrays.toString(coordinatesOfCharacter.solution(firstKeyInputs, firstBoards)));
        System.out.println("Result: " + Arrays.toString(coordinatesOfCharacter.solution(secondKeyInputs, secondBoards)));
    }
}
