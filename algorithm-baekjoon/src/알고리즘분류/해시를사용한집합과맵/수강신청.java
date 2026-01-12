package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 수강신청 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> studentOrderSet = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String registrationStudentId = bufferedReader.readLine();
            studentOrderSet.remove(registrationStudentId);
            studentOrderSet.add(registrationStudentId);
        }

        int enrollmentLimit = 0;
        for (String studentId : studentOrderSet) {
            if (enrollmentLimit < K) {
                bufferedWriter.write(studentId + "\n");
                enrollmentLimit++;
            } else {
                break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
