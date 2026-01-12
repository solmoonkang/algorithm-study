package 알고리즘분류.구현;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.StringTokenizer;

public class 이천칠년 {

    private static final int YEAR = 2007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int month = Integer.parseInt(stringTokenizer.nextToken());
        int day = Integer.parseInt(stringTokenizer.nextToken());

        LocalDate date = LocalDate.of(YEAR, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        bufferedWriter.write(String.format(Locale.ENGLISH, "%ta", dayOfWeek).toUpperCase());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
