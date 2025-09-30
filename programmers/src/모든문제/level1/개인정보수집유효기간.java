package 모든문제.level1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 개인정보수집유효기간 {

    private static final int DAYS_PER_CUSTOM_MONTH = 28;
    private static final String DATE_DELIMITER = "\\.";
    private static final String TERM_DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String today = bufferedReader.readLine();

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] terms = new String[N];
        for (int i = 0; i < N; i++) {
            terms[i] = bufferedReader.readLine();
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        String[] privacies = new String[M];
        for (int i = 0; i < M; i++) {
            privacies[i] = bufferedReader.readLine();
        }

        int[] personalDataNumbers = getPersonalDataDestroyedNumber(today, terms, privacies);
        String dataNumber = Arrays.stream(personalDataNumbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        bufferedWriter.write(dataNumber);
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int[] getPersonalDataDestroyedNumber(String today, String[] terms, String[] privacies) {
        int todayDate = toTotalDays(today);

        Map<String, Integer> termExpirationMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(TERM_DELIMITER);
            termExpirationMap.put(parts[0], Integer.valueOf(parts[1]));
        }

        List<Integer> destroyedNumbers = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(TERM_DELIMITER);

            int collectedTotalDays = toTotalDays(privacyParts[0]);
            int monthsToAdd = termExpirationMap.get(privacyParts[1]);

            int expirationTotalDays = collectedTotalDays + (monthsToAdd * DAYS_PER_CUSTOM_MONTH);

            if (todayDate >= expirationTotalDays) destroyedNumbers.add(i + 1);
        }

        return destroyedNumbers.stream().mapToInt(i -> i).toArray();
    }

    private static int toTotalDays(String date) {
        String[] parts = date.split(DATE_DELIMITER);
        return (Integer.parseInt(parts[0]) * 12 * DAYS_PER_CUSTOM_MONTH) +
                (Integer.parseInt(parts[1]) * DAYS_PER_CUSTOM_MONTH) +
                Integer.parseInt(parts[2]);
    }
}
