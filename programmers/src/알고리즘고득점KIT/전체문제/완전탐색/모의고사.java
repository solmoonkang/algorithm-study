package 알고리즘고득점KIT.전체문제.완전탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의고사 {

    private static final int[] GAVE_UP_MATH_PERSON_1 = {1, 2, 3, 4, 5};
    private static final int[] GAVE_UP_MATH_PERSON_2 = {2, 1, 2, 3, 2};
    private static final int[] GAVE_UP_MATH_PERSON_3 = {3, 3, 1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        int[] answers = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) answers[i] = Integer.parseInt(stringTokenizer.nextToken());

        // 오름차순 출력을 위해 정렬을 사용한 과정은 O(N logN)을 갖는다. -> 크기가 3이므로 3 log3으로 O(1)으로 변환된다.
        int[] persons = getMostQuestionsRightPerson(answers);
        Arrays.sort(persons);
        for (int person : persons) bufferedWriter.write(person + " ");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    // 최종 시간 복잡도는 정답을 맞춘 개수를 계산하는 반복문으로 O(N)의 시간 복잡도를 갖으므로, N은 최대 10,000으로 10^8보다 적으므로 통과 가능하다.
    private static int[] getMostQuestionsRightPerson(int[] answers) {
        int firstIndex = 0;
        int secondIndex = 1;
        int thirdIndex = 2;

        int[] correctQuestion = new int[3];

        // 반복문으로 인해서 O(N)의 시간 복잡도를 갖는다.
        // GAVE_UP_MATH_PERSON 배열은 수포자의 답안 패턴을 나타내며, 배열의 길이는 문제의 개수 N보다 짧다.
        // 만약 GAVE_UP_MATH_PERSON 배열 길이가 5일 때 N이 8이라고 가정하면, i가 5 이상일 때는 배열의 범위를 초과하게 되기 때문에 배열 인덱스를 안전하게 접근하기 위해 나머지 연산을 사용한다.
        for (int i = 0; i < answers.length; i++) {
            if (i % GAVE_UP_MATH_PERSON_1.length == answers[i]) correctQuestion[firstIndex]++;
            if (i % GAVE_UP_MATH_PERSON_2.length == answers[i]) correctQuestion[secondIndex]++;
            if (i % GAVE_UP_MATH_PERSON_3.length == answers[i]) correctQuestion[thirdIndex]++;
        }

        // 최대 점수를 찾는 과정은 O(1)의 시간 복잡도를 갖는다. -> O(3) = O(1)
        int maxScore = Math.max(correctQuestion[0], Math.max(correctQuestion[1], correctQuestion[2]));

        int index = 0;
        int[] corrects = new int[3];
        for (int i = 0; i < correctQuestion.length; i++) {
            if (correctQuestion[i] == maxScore) corrects[index++] = i + 1;
        }

        // corrects 배열의 앞에서부터 index 만큼의 원소를 복사해서 새로운 배열을 반환하는 메서드로, index가 0인 경우 배열이 비게 된다.
        return Arrays.copyOf(corrects, index);
    }
}
