package csStudyCodingTest;

public class 최댓값과최솟값 {
    // Method
    /* 문제 접근 방식
     * 1) 문자열을 "" 단위로 split한다
     * 2) for문을 통해 "" 단위로 잘린 문자열 배열을 순회한다
     * 3) 순회시마다 max, min 값에 계속 비교하여 넣어준다
     * 4) 최소, 최대값을 이어붙여 문자열로 반환한다
     */

    public String solution(String s) {
        String answer = ""; // answer 초기화

        String[] str = s.split(" ");    // split 함수 : 입력받은 정규표현식 또는 특정 문자를 기준으로 문자열을 나누어 배열에 저장하여 리턴

        int min = 0;    // min 초기화
        int max = 0;    // max 초기화

        for (int i = 0; i < str.length; i++) {

            int number = Integer.parseInt(str[i]);  // Integer.parseInt : 문자열을 숫자로 변환시키는 방법

            min = Math.min(min, number);    // 문자열 중 최소값을 min에 저장한다
            max = Math.max(max, number);    // 문자열 중 최대값을 max에 저장한다
        }

        answer = min + " " + max;   // 문자열 반환을 위해 min과 max값을 이어붙여준다

        System.out.println("min :" + min);
        System.out.println("max :" + max);

        return answer;  // answer값을 반환한다
    }

    public static void main(String[] args) {
        최댓값과최솟값 solution = new 최댓값과최솟값();
        solution.solution("-1 -2 -3 -4");
    }
}


//public class GetMinMaxString {
//    public String getMinMaxString(String str) {
//        String[] tmp = str.split(" ");
//        int min, max, n;
//        min = max = Integer.parseInt(tmp[0]);
//        for (int i = 1; i < tmp.length; i++) {
//            n = Integer.parseInt(tmp[i]);
//            if(min > n) min = n;
//            if(max < n) max = n;
//        }
//
//        return min + " " + max;
//
//    }
//
//    public static void main(String[] args) {
//        String str = "1 2 3 4";
//        GetMinMaxString minMax = new GetMinMaxString();
//        //아래는 테스트로 출력해 보기 위한 코드입니다.
//        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
//    }
//}