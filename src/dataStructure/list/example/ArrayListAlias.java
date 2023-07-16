package dataStructure.list.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListAlias {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====== 2번 문제 ======");

        ArrayList<String> aliasList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println(i + "번째 사람의 별명을 입력해주세요");

            // 별명을 입력받는다
            String alias = scanner.nextLine();

            // 입력받은 별명을 aliasList 에 저장한다
            aliasList.add(alias);
        }

        int maxAlias = 0;

        for (int i = 1; i < aliasList.size(); i++) {

            if (aliasList.get(maxAlias).length() < aliasList.get(i).length()) {

                maxAlias = i;
            }
        }

        System.out.println("제일 긴 별명을 갖는 사람 : " + aliasList.get(maxAlias));
    }
}
