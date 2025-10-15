package 알고리즘고득점KIT.전체문제.그리디;

import java.io.*;

public class 조이스틱 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = bufferedReader.readLine();

        int minJoystickActions = findMinJoystickActions(name);
        bufferedWriter.write(String.valueOf(minJoystickActions));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int findMinJoystickActions(String name) {
        int joystickActions = 0, minMoves = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            char targetAlphabet = name.charAt(i);

            int upMoves = targetAlphabet - 'A';
            int downMoves = 'Z' - targetAlphabet + 1;

            joystickActions += Math.min(upMoves, downMoves);

            int nextAlphabet = i + 1;
            while (nextAlphabet < name.length() && name.charAt(nextAlphabet) == 'A') nextAlphabet++;
            minMoves = Math.min(minMoves, i + name.length() - nextAlphabet + Math.min(i, name.length() - nextAlphabet));
        }

        minMoves += joystickActions;
        return minMoves;
    }
}
