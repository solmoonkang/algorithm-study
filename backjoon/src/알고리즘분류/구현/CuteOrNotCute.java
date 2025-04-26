package 알고리즘분류.구현;

import java.io.*;

public class CuteOrNotCute {

    private static final String JUNHEE_IS_CUTE = "Junhee is cute!";
    private static final String JUNHEE_IS_NOT_CUTE = "Junhee is not cute!";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int notCute = 0;
        int cute = 0;

        for (int i = 0; i < N; i++) {
            int survey = Integer.parseInt(bufferedReader.readLine());

            if (survey == 0) notCute++;
            else cute++;
        }

        bufferedWriter.write(notCute > cute ? JUNHEE_IS_NOT_CUTE : JUNHEE_IS_CUTE);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
