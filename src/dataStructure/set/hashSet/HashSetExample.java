package dataStructure.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {

        // ========== HashSet 선언 ========== //

        // HashSet 을 생성한다
        HashSet<Integer> hashSet1 = new HashSet<Integer>();

        // new 타입에서는 타입 파라미터를 생략할 수 있다
        HashSet<Integer> hashSet2 = new HashSet<>();

        // hashSet1 의 모든 값을 가진 hashSet3 를 생성한다
        HashSet<Integer> hashSet3 = new HashSet<>(hashSet1);

        // 초기 용량이 10인 hashSet 을 생성한다
        HashSet<Integer> hashSet4 = new HashSet<>(10);

        // 초기값을 지정한다
        HashSet<Integer> hashSet5 = new HashSet<>(Arrays.asList(1, 2, 3));


        // ========== HashSet 값 추가 및 삭제 ========== //

        HashSet<Integer> hashSet = new HashSet<>();

        // 1이라는 값을 추가한다
        hashSet.add(1);

        // 1이라는 값을 제거한다
        hashSet.remove(1);

        // 모든 값을 제거한다
        hashSet.clear();
    }
}
