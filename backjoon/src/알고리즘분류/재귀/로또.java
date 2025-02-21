package 알고리즘분류.재귀;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 로또 {

    private static final int LOTTO_NUMBER = 6;
    private static final List<List<Integer>> lottoNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder combinationLottoNumber = new StringBuilder();

        while (true) {
            String number = bufferedReader.readLine();
            if (number.equals("0")) break;

            String[] numbers = number.split(" ");
            int K = Integer.parseInt(numbers[0]);

            List<Integer> S = new ArrayList<>();
            for (int i = 1; i <= K; i++) S.add(Integer.parseInt(numbers[i]));

            lottoNumbers.clear();
            generateCombinations(S, new ArrayList<>(), 0);

            for (List<Integer> combination : lottoNumbers) {
                combinationLottoNumber.append(combination.toString().replaceAll("[\\[\\],]", "")).append("\n");
            }
            combinationLottoNumber.append("\n");
        }

        bufferedWriter.write(combinationLottoNumber.toString().trim());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * @param S:       전체 숫자 리스트
     * @param current: 현재 선택된 조합을 저장할 리스트
     * @param start:   현재 선택할 숫자의 시작 인덱스
     */
    private static void generateCombinations(List<Integer> S, List<Integer> current, int start) {
        // 현재 선택된 조합의 크기가 원하는 조합 크기와 같으면 현재 조합을 lottoNumbers에 추가한다.
        if (current.size() == LOTTO_NUMBER) {
            lottoNumbers.add(new ArrayList<>(current));
            return;
        }

        // 현재 숫자를 선택한 후, 다음 숫자를 선택하기 위해 재귀 호출을 한다.
        for (int i = start; i < S.size(); i++) {
            current.add(S.get(i));
            generateCombinations(S, current, i + 1);
            // 선택이 끝나면, 현재 조합에서 마지막 숫자를 제거하여 다음 조합 생성을 위한 백트래킹을 수행한다.
            current.remove(current.size() - 1);
        }
    }
}
