package 알고리즘분류.해시를사용한집합과맵;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임 {

    private static final String YUT_NORI = "Y";
    private static final String FIND_THE_SAME_PICTURE = "F";
    private static final String ONE_CARD = "O";

    private static final int YUT_NORI_PLAYERS = 2;
    private static final int FIND_THE_SAME_PICTURE_PLAYERS = 3;
    private static final int ONE_CARD_PLAYERS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        String gamesToPlayTypes = stringTokenizer.nextToken();

        Set<String> gameToPlayPeopleNamesSet = new HashSet<>();

        for (int i = 0; i < N; i++) gameToPlayPeopleNamesSet.add(bufferedReader.readLine());

        int playersNumber = gameToPlayPeopleNamesSet.size();
        int maxGamesNumber = 0;

        if (gamesToPlayTypes.equals(YUT_NORI)) {
            if (playersNumber >= YUT_NORI_PLAYERS) maxGamesNumber = playersNumber;
        } else if (gamesToPlayTypes.equals(FIND_THE_SAME_PICTURE)) {
            if (playersNumber >= FIND_THE_SAME_PICTURE_PLAYERS) maxGamesNumber = playersNumber / 2;
        } else if (gamesToPlayTypes.equals(ONE_CARD)) {
            if (playersNumber >= ONE_CARD_PLAYERS) maxGamesNumber = playersNumber / 3;
        }

        bufferedWriter.write(String.valueOf(maxGamesNumber));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
