package 알고리즘분류.문자열.틀린문제;

import java.io.*;

public class 명령프롬프트 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int fileNameNumber = Integer.parseInt(bufferedReader.readLine());

        String[] commandPrompts = new String[fileNameNumber];
        for (int i = 0; i < fileNameNumber; i++) commandPrompts[i] = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        String currentCommand = commandPrompts[0];

        for (int i = 1; i < commandPrompts.length; i++) {
            String nextCommand = commandPrompts[i];
            // 이전 비교 결과가 계속 남아서 누적되기 때문에 잘못된 결과를 초래할 수 있다.
            stringBuilder.setLength(0);
            for (int j = 0; j < nextCommand.length(); j++) {
                if (currentCommand.charAt(j) == nextCommand.charAt(j)) stringBuilder.append(currentCommand.charAt(j));
                else stringBuilder.append("?");
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
