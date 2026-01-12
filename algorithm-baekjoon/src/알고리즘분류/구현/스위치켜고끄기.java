package 알고리즘분류.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int switchNumber = Integer.parseInt(bufferedReader.readLine());

        int[] switchStates = new int[switchNumber + 1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= switchNumber; i++) {
            switchStates[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int studentNumber = Integer.parseInt(bufferedReader.readLine());
        int[][] studentInfo = new int[studentNumber][2];
        for (int i = 0; i < studentNumber; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            studentInfo[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            studentInfo[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < studentNumber; i++) {
            int gender = studentInfo[i][0];
            int number = studentInfo[i][1];

            if (gender == 1) {
                // 남학생의 경우 선택된 번호의 배수를 반전시킨다.
                for (int j = number; j <= switchNumber; j += number) {
                    switchStates[j] = switchStates[j] == 0 ? 1 : 0;
                }
            } else if (gender == 2) {
                // 처음에는 중심 번호가 왼쪽이자 오른쪽이다.
                int left = number;
                int right = number;

                // left >= 1 && right <= switchNumber: 배열 범위를 벗어나지 않고
                // switchStates[left] == switchStates[right]: 양쪽 스위치 상태가 같으면 계속해서 반복한다.
                while (left >= 1 && right <= switchNumber && switchStates[left] == switchStates[right]) {
                    // 왼쪽 스위치를 토클한다.
                    switchStates[left] = switchStates[left] == 0 ? 1 : 0;

                    // 만약 left와 right가 다를 경우에만 오른쪽도 토클한다.
                    if (left != right) {
                        switchStates[right] = switchStates[right] == 0 ? 1 : 0;
                    }

                    // 범위를 확장한다.
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= switchNumber; i++) {
            bufferedWriter.write(switchStates[i] + " ");
            if (i % 20 == 0) bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
