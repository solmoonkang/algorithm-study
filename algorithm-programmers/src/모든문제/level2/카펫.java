package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 카펫 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int brown = Integer.parseInt(stringTokenizer.nextToken());
        int yellow = Integer.parseInt(stringTokenizer.nextToken());

        int[] carpetDimensions = getCarpetDimensions(brown, yellow);
        for (int size : carpetDimensions) bufferedWriter.write(size + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * 문제 접근 전략
     * - 전체 카펫의 면적은 brown + yellow로 고정되어 전체 면적의 약수의 쌍은 (가로, 세로) 후보가 될 수 있다.
     * - 문제 조건으로 가로 >= 세로이고, brown은 yellow를 감싸고 있는 형태이므로 전체 카펫 면적의 약수 중 서로 차가 2인 쌍을 반환해야 한다.
     */
    private static int[] getCarpetDimensions(int brown, int yellow) {
        int total = brown + yellow;

        // 외부 갈색 영역 안에 내부 노란색 영역이 존재하기 위해서는 위/아래로 갈색 한 줄씩 있어야 한다.
        // 따라서 최소 세로 길이는 3부터 시작해야 (height - 2) >= 1이 되어 내부가 존재 가능하다.
        // Math.sqrt(total)까지만 도는 이유는, 약수 쌍은 대칭적이기 때문이다.
        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                // 약수 쌍을 찾았으므로 가로 = 전체 면적/세로
                int width = total / height;
                // 가로 좌우와 세로 상하에서 테두리가 하나씩 빠져나가면 그게 노란색이 들어간 영역을 의미하므로 가로-2 * 세로-2가 노란색과 같으면 반환하면 된다.
                if ((width - 2) * (height - 2) == yellow) return new int[]{width, height};
            }
        }

        return new int[0];
    }
}
