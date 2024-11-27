package baekjoon.단계문제.집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {

    // TODO: 값에 대한 키를 빠르게 찾을 수 있도록 두 개의 해시맵을 사용해 양방향 해시맵으로 시간초과를 해결했다.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, String> numberToPokemonMap = new HashMap<>();
        Map<String, Integer> pokemonToNumberMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemonName = bufferedReader.readLine();
            numberToPokemonMap.put(i, pokemonName);
            pokemonToNumberMap.put(pokemonName, i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = bufferedReader.readLine();

            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                if (numberToPokemonMap.containsKey(number)) {
                    stringBuilder.append(numberToPokemonMap.get(number)).append("\n");
                }
            } else {
                if (pokemonToNumberMap.containsKey(input)) {
                    stringBuilder.append(pokemonToNumberMap.get(input)).append("\n");
                }
            }
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
