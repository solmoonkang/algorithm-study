package 모든문제.level2;

import java.io.*;
import java.util.StringTokenizer;

public class 스킬트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        String skill = stringTokenizer.nextToken();
        int N = Integer.parseInt(stringTokenizer.nextToken());

        String[] skillTrees = new String[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) skillTrees[i] = stringTokenizer.nextToken();

        int skills = getUsageSkillTrees(skill, skillTrees);
        bufferedWriter.write(String.valueOf(skills));
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getUsageSkillTrees(String skill, String[] skillTrees) {
        int count = 0;

        // skill 문자열에 있는 스킬들만 남겨서 순서만 검사하면 된다. 예를 들어 "BACDE"에서 "CBD"만 뽑아내면 "BD"가 된다. 따라서 "CBD"와 맞지 않아서 성립할 수 없다.
        for (String tree : skillTrees) {
            StringBuilder filtered = new StringBuilder();

            for (char skillName : tree.toCharArray()) {
                // skill.indexOf(c)는 문자가 "skill" 안에 있으면 그 인덱스를 리턴하고, 없으면 -1을 리턴한다.
                // 해당 조건문을 통해서 선행 스킬에 포함된 문자만 골라내서 filtered에 추가한다.
                if (skill.indexOf(skillName) != -1) filtered.append(skillName);
            }

            // 지금까지 뽑아낸 스킬 순서와 그 순서가 skill의 앞부분이랑 같은지 확인하고 일치한다면 카운트를 증가시킨다.
            if (skill.startsWith(filtered.toString())) count++;
        }

        return count;
    }
}
