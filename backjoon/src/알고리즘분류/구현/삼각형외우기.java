package 알고리즘분류.구현;

import java.io.*;

public class 삼각형외우기 {

    private static final String ALL_ANGLES_ARE_60_DEGREES = "Equilateral";
    private static final String SUM_IS_180_AND_TWO_ANGLES_ARE_EQUAL = "Isosceles";
    private static final String SUM_IS_180_AND_NO_EQUAL_ANGLES = "Scalene";
    private static final String SUM_IS_NOT_180 = "Error";

    private static final int ANGLE_60 = 60;
    private static final int ANGLE_180 = 180;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int firstDegree = Integer.parseInt(bufferedReader.readLine());
        int secondDegree = Integer.parseInt(bufferedReader.readLine());
        int thirdDegree = Integer.parseInt(bufferedReader.readLine());

        int allAngles = firstDegree + secondDegree + thirdDegree;

        if (firstDegree == ANGLE_60 && secondDegree == ANGLE_60 && thirdDegree == ANGLE_60)
            bufferedWriter.write(ALL_ANGLES_ARE_60_DEGREES);
        else if (allAngles == ANGLE_180) {
            if (firstDegree == secondDegree || firstDegree == thirdDegree || secondDegree == thirdDegree)
                bufferedWriter.write(SUM_IS_180_AND_TWO_ANGLES_ARE_EQUAL);
            else bufferedWriter.write(SUM_IS_180_AND_NO_EQUAL_ANGLES);
        } else bufferedWriter.write(SUM_IS_NOT_180);

        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
