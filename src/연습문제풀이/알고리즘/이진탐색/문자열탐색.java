package 연습문제풀이.알고리즘.이진탐색;

import java.util.Arrays;

public class 문자열탐색 {

    /**
     * Arrays.binarySearch( ) 메서드를 이용한 이진 탐색
     * String[] 문자열 배열 내에서 key값을 찾는 문제로,
     * Arrays.binarySearch( ) 메서드로 배열 내 key값이 존재하는지 확인할 수 있다.
     */
    public int solution(String[] array, String key) {
        Arrays.sort(array);

        int result = Arrays.binarySearch(array, key);
        if (result < 0) System.out.println("해당 원소는 배열 내에 속해있지 않습니다.");

        return result;
    }

    public static void main(String[] args) {
        문자열탐색 binarySearch = new 문자열탐색();

        String[] array = {"가", "나", "다", "라", "마", "바", "사"};
        String key = "라";
        System.out.println("binarySearch = " + binarySearch.solution(array, key));
    }
}
