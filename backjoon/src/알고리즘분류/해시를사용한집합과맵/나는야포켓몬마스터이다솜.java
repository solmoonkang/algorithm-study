package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        Map<Integer, String> pokédexNumberMap = new HashMap<>();
        Map<String, Integer> pokédexNameMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokémonName = bufferedReader.readLine();
            pokédexNumberMap.put(i, pokémonName);
            pokédexNameMap.put(pokémonName, i);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String pokémonNameQuery = bufferedReader.readLine();

            if (pokémonNameQuery.matches("\\d+"))
                stringBuilder.append(pokédexNumberMap.get(Integer.parseInt(pokémonNameQuery))).append("\n");
            else stringBuilder.append(pokédexNameMap.get(pokémonNameQuery)).append("\n");
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
