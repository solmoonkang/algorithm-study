package 기출문제.카카오인턴십_2020;

public class 키패드누르기 {

    // TODO: 3으로 나눈 몫과 3으로 나눈 나머지의 합이 이동거리임을 처음 알게 되었고, 다시 한 번 풀어봐야 할 것 같다.
    public String solution(int[] numbers, String hand) {
        int leftPosition = 10;
        int rightPosition = 11;

        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                builder.append("L");
                leftPosition = number;
            } else if (number == 3 || number == 6 || number == 9) {
                builder.append("R");
                rightPosition = number;
            } else {
                int targetPosition = number == 0 ? 10 : number;

                int leftDistance = calculateDistance(leftPosition, targetPosition);
                int rightDistance = calculateDistance(rightPosition, targetPosition);

                if (leftDistance < rightDistance) {
                    builder.append("L");
                    leftPosition = targetPosition;
                } else if (rightDistance < leftDistance) {
                    builder.append("R");
                    rightPosition = targetPosition;
                } else {
                    if (hand.equals("left")) {
                        builder.append("L");
                        leftPosition = targetPosition;
                    } else {
                        builder.append("R");
                        rightPosition = targetPosition;
                    }
                }
            }
        }

        return builder.toString();
    }

    public int calculateDistance(int current, int target) {
        int currentRow = (current == 10) ? 3 : (current == 11) ? 3 : (current - 1) / 3;
        int currentCol = (current == 10) ? 0 : (current == 11) ? 2 : (current - 1) % 3;

        int targetRow = (target == 10) ? 3 : (target == 11) ? 3 : (target - 1) / 3;
        int targetCol = (target == 10) ? 0 : (target == 11) ? 2 : (target - 1) % 3;

        return Math.abs(currentRow - targetRow) + Math.abs(currentCol - targetCol);
    }

    public static void main(String[] args) {
        키패드누르기 pressingTheKeypad = new 키패드누르기();

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println("pressingTheKeypad = " + pressingTheKeypad.solution(numbers1, "right"));

        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println("pressingTheKeypad = " + pressingTheKeypad.solution(numbers2, "left"));

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("pressingTheKeypad = " + pressingTheKeypad.solution(numbers3, "right"));
    }
}
