package 모든문제.level3.알고리즘고득점KIT;

import java.util.*;

public class 베스트앨범 {

    // TODO: 문제 이해 능력과 해결 능력이 부족함.

    static class SongInfo {
        int id;
        int plays;

        public SongInfo(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<SongInfo>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + playCount);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new SongInfo(i, playCount));
        }

        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genrePlayCount.entrySet());
        sortedGenres.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedGenres) {
            String genre = entry.getKey();
            List<SongInfo> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (b.plays == a.plays) return Integer.compare(a.id, b.id);
                return Integer.compare(b.plays, a.plays);
            });

            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                answer.add(songs.get(j).id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        베스트앨범 problem = new 베스트앨범();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println("problem = " + Arrays.toString(problem.solution(genres, plays)));
    }
}
