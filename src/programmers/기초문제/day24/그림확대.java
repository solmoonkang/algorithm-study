package programmers.기초문제.day24;

import java.util.Arrays;

public class 그림확대 {

    /**
     * [ 문제 설명 ]
     * 직사각형 형태의 그림 파일이 있고, 이 그림 파일은 1 × 1 크기의 정사각형 크기의 픽셀로 이루어져 있습니다.
     * 이 그림 파일을 나타낸 문자열 배열 picture과 정수 k가 매개변수로 주어질 때,
     * 이 그림 파일을 가로 세로로 k배 늘린 그림 파일을 나타내도록 문자열 배열을 반환하라
     */
    public String[] solution(String[] picture, int k) {
        // picture[i]의 원소의 각 원소(char)의 값을 k배 늘려야 한다.
        String[] answer = new String[picture.length * k];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < picture.length; i++) {
            String p = picture[i];
            // 이전 줄의 내용이 다음 줄에 영향을 주는 것을 방지하기 위해 StringBuilder를 초기화한다.
            builder.setLength(0);
            for (char c : p.toCharArray()) {
                for (int j = 0; j < k; j++) {
                    builder.append(c);
                }
            }
            // 각 줄을 k번 반복하여 answer 배열에 추가하는 것을 담당한다.
            for (int j = 0; j < k; j++) {
                // i * k 부분은 현재 줄이 k번 반복되는 것을 반영하고 있다. 이는 answer 배열에서 현재 줄이 시작되는 인덱스를 나타낸다.
                // 이후, j를 더함으로써 현재 줄이 k번 반복되는 동안의 각 반복을 인덱싱한다.
                // 따라서, builder에 저장된 현재 줄을 answer 배열의 적절한 위치에 k번 반복하여 저장하는 것을 의미한다.
                answer[i * k + j] = builder.toString();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        그림확대 imageEnlargement = new 그림확대();
        String[] pictures = {
                ".xx...xx.", "x..x.x..x",
                "x...x...x", ".x.....x.",
                "..x...x..", "...x.x...",
                "....x...."};
        System.out.println("Result : " + Arrays.toString(imageEnlargement.solution(pictures, 2)));
    }
}
