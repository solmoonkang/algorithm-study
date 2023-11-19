package programmers.coding_basic_training.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 그림확대 {

    /**
     * 직사각형 형태의 그림 파일이 있고, 이 그림 파일은 1 × 1 크기의 정사각형 크기의 픽셀로 이루어져 있습니다.
     * 이 그림 파일을 나타낸 문자열 배열 picture과 정수 k가 매개변수로 주어질 때,
     * 이 그림 파일을 가로 세로로 k배 늘린 그림 파일을 나타내도록 문자열 배열을 반환하라
     */

    public String[] solution(String[] picture, int k) {
        // picture 배열의 각 원소도 k배만큼, picture 배열의 길이도 k배만큼 증가시켜야 한다.

        //
        String[] result = new String[picture.length * k];

        List<String> answer = new ArrayList<>();
        return result;
    }

    public static void main(String[] args) {

        그림확대 zoom = new 그림확대();

        String[] picture = {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."};

        System.out.println("Result : " + Arrays.toString(zoom.solution(picture, 2)));
    }
}
