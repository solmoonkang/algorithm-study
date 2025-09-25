package 모든문제.level1;

import java.io.*;

public class 신규아이디추천 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = bufferedReader.readLine();
        String newId = recommendNewId(id);
        bufferedWriter.write(newId);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String recommendNewId(String id) {
        // 1단계: 모든 대문자를 대응되는 소문자로 치환
        id = id.toLowerCase();

        StringBuilder filteredId = new StringBuilder();
        // 2단계: 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거한다.
        for (char character : id.toCharArray()) {
            if ((character >= 'a' && character <= 'z') || (character >= '0' && character <= '9') || character == '-' || character == '_' || character == '.') {
                filteredId.append(character);
            }
        }

        // 3단계: 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
        for (int i = 0; i < filteredId.length() - 1; ) {
            if (filteredId.charAt(i) == '.' && filteredId.charAt(i + 1) == '.') {
                filteredId.deleteCharAt(i + 1);
            } else {
                i++;
            }
        }

        // 4단계: 마침표가 처음이나 끝에 위치한다면 제거
        if (!filteredId.isEmpty() && filteredId.charAt(0) == '.') filteredId.deleteCharAt(0);
        if (!filteredId.isEmpty() && filteredId.charAt(filteredId.length() - 1) == '.')
            filteredId.deleteCharAt(filteredId.length() - 1);

        // 5단계: 빈 문자열이라면, "a"를 대입
        if (filteredId.isEmpty()) filteredId.append("a");

        // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거 만약 제거 후 마침표가 끝에 위치한다면 끝에 위치한 마침표를 제거한다.
        if (filteredId.length() >= 16) {
            filteredId.delete(15, filteredId.length());
            if (filteredId.charAt(filteredId.length() - 1) == '.') filteredId.deleteCharAt(filteredId.length() - 1);
        }

        // 7단계: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        if (filteredId.length() <= 2) {
            filteredId.append(String.valueOf(filteredId.charAt(filteredId.length() - 1)).repeat(Math.max(0, 3 - filteredId.length())));
        }

        return filteredId.toString();
    }
}
