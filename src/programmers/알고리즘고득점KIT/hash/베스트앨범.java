package programmers.알고리즘고득점KIT.hash;

import java.util.*;

public class 베스트앨범 {

    /**
     * 1. 속한 노래가 많이 재생된 장르를 먼저 수록
     * 2. 장르 내에서 많이 재생된 노래를 먼저 수록
     * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
     */

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> album = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            album.put(genres[i], album.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genre = new ArrayList<>();

        for (String key : album.keySet()) {

            genre.add(key);
        }

        Collections.sort(genre, (o1, o2) -> album.get(o2) - album.get(o1));

        ArrayList<Integer> play = new ArrayList<>();

        for (int i = 0; i < genre.size(); i++) {

            String gen = genre.get(i);

            int max = 0;
            int firstIndex = -1;

            for (int j = 0; j < genres.length; j++) {

                if (gen.equals(genres[j]) && max < plays[j]) {

                    max = plays[j];

                    firstIndex = j;
                }
            }

            max = 0;
            int secondIndex = -1;

            for (int j = 0; j < genres.length; j++) {

                if (gen.equals(genres[j]) && max < plays[j] && j != firstIndex) {

                    max = plays[j];

                    secondIndex = j;
                }
            }

            play.add(firstIndex);

            if (secondIndex >= 0) play.add(secondIndex);
        }

        int[] answer = new int[play.size()];

        for (int i = 0; i < play.size(); i++) {

            answer[i] = play.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        베스트앨범 album = new 베스트앨범();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println("Best Album : " + Arrays.toString(album.solution(genres, plays)));
    }
}
