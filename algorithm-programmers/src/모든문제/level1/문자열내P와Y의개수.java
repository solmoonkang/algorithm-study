package 모든문제.level1;

import java.io.*;

public class 문자열내P와Y의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = bufferedReader.readLine();

        boolean isEqual = isPAndYEqual(sentence);
        bufferedWriter.write(String.valueOf(isEqual));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static boolean isPAndYEqual(String sentence) {
        sentence = sentence.toUpperCase();
        if (!sentence.contains("P") && !sentence.contains("Y")) return true;

        int count = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'P') count++;
            else if (sentence.charAt(i) == 'Y') count--;
        }

        return count == 0;
    }

    private static boolean anotherSolution(String sentence) {
        sentence = sentence.toUpperCase();

        return sentence.chars().filter(element -> element == 'P').count()
                == sentence.chars().filter(element -> element == 'Y').count();
    }
}
