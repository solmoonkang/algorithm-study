package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.*;

public class 걸그룹마스터준석이 {

    private static final int MEMBER_ORDER_NAMES = 0;
    private static final int TEAM_NAME_OF_MEMBER = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, List<String>> girlGroupMap = new HashMap<>();
        Map<String, String> memberToGroupNameMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String groupName = bufferedReader.readLine();
            int groupMemberNumber = Integer.parseInt(bufferedReader.readLine());

            List<String> memberList = new ArrayList<>();
            for (int j = 0; j < groupMemberNumber; j++) {
                String groupMemberName = bufferedReader.readLine();
                memberList.add(groupMemberName);
                memberToGroupNameMap.put(groupMemberName, groupName);
            }

            girlGroupMap.put(groupName, memberList);
        }

        List<String> quizAnswerList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String groupNameOrGroupMemberName = bufferedReader.readLine();
            int quizType = Integer.parseInt(bufferedReader.readLine());

            if (quizType == MEMBER_ORDER_NAMES) {
                if (girlGroupMap.containsKey(groupNameOrGroupMemberName)) {
                    List<String> members = girlGroupMap.get(groupNameOrGroupMemberName);
                    Collections.sort(members);
                    quizAnswerList.addAll(members);
                }
            } else if (quizType == TEAM_NAME_OF_MEMBER) {
                if (memberToGroupNameMap.containsKey(groupNameOrGroupMemberName)) {
                    String teamName = memberToGroupNameMap.get(groupNameOrGroupMemberName);
                    quizAnswerList.add(teamName);
                }
            }
        }

        for (String quizAnswer : quizAnswerList) bufferedWriter.write(quizAnswer + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
