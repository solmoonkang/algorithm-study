package 알고리즘분류.자료구조;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class 에디터 {

    // TODO: ListIterator에 대해서 처음 접하게 된 문제, 이러한 문제를 효과적으로 구현할 수 있음을 알게 되었다. 조금 더 공부해서 적극 활용하도록 하자.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = bufferedReader.readLine();
        int N = Integer.parseInt(bufferedReader.readLine());

        List<Character> textLists = new ArrayList<>();
        for (char c : text.toCharArray()) {
            textLists.add(c);
        }

        ListIterator<Character> cursor = textLists.listIterator(textLists.size());

        for (int i = 0; i < N; i++) {
            String editor = bufferedReader.readLine();

            if (editor.startsWith("L")) {
                if (cursor.hasPrevious()) cursor.previous();
            } else if (editor.startsWith("D")) {
                if (cursor.hasNext()) cursor.next();
            } else if (editor.startsWith("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (editor.startsWith("P")) {
                char toInsert = editor.charAt(2);
                cursor.add(toInsert);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : textLists) {
            stringBuilder.append(c);
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
