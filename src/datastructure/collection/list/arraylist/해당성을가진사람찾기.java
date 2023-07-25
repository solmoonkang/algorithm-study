package datastructure.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class 해당성을가진사람찾기 {

    /** ArrayList 연습문제
     *  5명의 사람 이름을 입력받아 ArrayList 에 저장한 후, 이들 중 '김씨' 성을 가진 사람을 모두 출력하시오
     *  2. 5명의 별명을 입력받아 ArrayList 에 저장하고 이들 중 별명의 길이가 가장 긴 별명을 출력하시오 (단, 별명은 모두 다 다르다)
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====== 1번 문제 ======");

        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println(i + "번째 사람의 이름을 입력해주세요");

            // 이름을 입력받는다
            String name = scanner.nextLine();

            // 입력받은 이름을 names 에 저장한다
            names.add(name);
        }

        for (int i = 0; i < names.size(); i++) {

            // 김씨 성을 가진 사람이 있을 경우, 이름을 반환한다
            if (names.get(i).startsWith("김")) {

                System.out.println("김씨 성을 갖는 사람 : " + names.get(i));
            }
        }
    }
}
