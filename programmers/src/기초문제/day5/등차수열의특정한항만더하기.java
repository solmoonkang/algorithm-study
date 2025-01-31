package 기초문제.day5;

import java.util.stream.IntStream;

public class 등차수열의특정한항만더하기 {

    /**
     * 등차수열이란
     * 첫째항부터 같은 수씩 더해지는 수열을 의미한다
     *
     * 예를 들어 [ 1, 3, 5, 7, 9, ... ] 일 경우,
     *      제1항은 1이다
     *      제2항은 제1항에 2를 더한 값이고,
     *      제3항은 제2항에 2를 더한 값이다
     *
     * 즉, 1, 3, 5, 7, 9 는 제1항을 1로 가지고 2씩 더해지는 등차수열이다
     *
     * 공차란
     * 등차수열에서 이웃한 두 항의 변화량이다
     * 즉, 제 n 항에 공차를 더하면, 제 ( n + 1 )항을 얻을 수 있다
     *
     * 예를 들어 10, 11, 12, 13, 14, ... 에서 공차는 1이다
     * 마찬가지로 9, 7, 5, 3, 1, ... 에서 공차는 -2이다
     *
     * 등차수열의 일반항이란
     * 등차수열의 첫째항을 a, 공차를 d 라고 한다면, 수열 a 의 n 번째 항은
     * an = a + ( n - 1 )d 를 만족한다
     */

    public int solution(int a, int d, boolean[] included) {

        int answer = 0;

        int num = a;

        for (int i = 0; i < included.length; i++) {     // included 배열만큼 반복해서

            if (included[i]) {      // true 면, num 을 더하고

                answer += num;
            }

            num += d;       // num 에 등차를 더해준다
        }

//        for (int i = 0; i < included.length; i++) {
//
//            if (included[i]) {
//
//                answer +=  a + (d * i);
//            }
//        }

        return answer;
    }

    public int solution_best(int a, int d, boolean[] included) {

        return IntStream.range(0, included.length)
                .map(idx -> included[idx] ? a + (idx * d) : 0)
                .sum();
    }

    public static void main(String[] args) {

        등차수열의특정한항만더하기 sum = new 등차수열의특정한항만더하기();

        boolean[] included = {true, false, false, true, true};

        System.out.println("Result : " + sum.solution(3, 4, included));
        System.out.println("Best Result : " + sum.solution_best(3, 4, included));
    }
}
