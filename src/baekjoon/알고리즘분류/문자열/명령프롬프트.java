package baekjoon.알고리즘분류.문자열;

import java.io.*;

public class 명령프롬프트 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] fileNameList = new String[N];

        for (int i = 0; i < N; i++) {
            fileNameList[i] = bufferedReader.readLine();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < fileNameList[0].length(); i++) {
            char currentCommand = fileNameList[0].charAt(i);
            boolean isCommon = true;

            for (int j = 1; j < N; j++) {
                if (fileNameList[j].charAt(i) != currentCommand) {
                    isCommon = false;
                    break;
                }
            }

            if (isCommon) stringBuilder.append(currentCommand);
            else stringBuilder.append("?");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
