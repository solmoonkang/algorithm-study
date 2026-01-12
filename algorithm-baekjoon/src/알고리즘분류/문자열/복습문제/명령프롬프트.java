package 알고리즘분류.문자열.복습문제;

import java.io.*;

public class 명령프롬프트 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] commandPrompts = new String[N];

        for (int i = 0; i < N; i++) {
            commandPrompts[i] = bufferedReader.readLine();
        }

        String command = derivePatternFromResult(commandPrompts);
        bufferedWriter.write(command);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String derivePatternFromResult(String[] commandPrompts) {
        String firstCommand = commandPrompts[0];

        char[] comparingCharacters = new char[firstCommand.length()];

        for (int j = 0; j < firstCommand.length(); j++) {
            comparingCharacters[j] = firstCommand.charAt(j);

            for (int i = 1; i < commandPrompts.length; i++) {
                String currentCommand = commandPrompts[i];

                if (firstCommand.charAt(j) != currentCommand.charAt(j)) {
                    comparingCharacters[j] = '?';
                    break;
                }
            }
        }

        return new String(comparingCharacters);
    }
}
