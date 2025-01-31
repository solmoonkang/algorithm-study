package 알고리즘고득점KIT.해시;

import java.util.*;

public class 베스트앨범 {

    // TODO: computeIfAbsent를 사용하여 장르가 없으면 새 리스트를 생성하고 곡을 추가하는 것과 getOrDefault로 재생 횟수를 누적하는 방법
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> bestAlbumMap = new HashMap<>();
        Map<String, Integer> genrePlayCountMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            Song song = new Song(plays[i], i);

            bestAlbumMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(song);
            genrePlayCountMap.put(genre, genrePlayCountMap.getOrDefault(genre, 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genrePlayCountMap.entrySet());
        genreList.sort((songA, songB) -> songB.getValue().compareTo(songA.getValue()));

        List<Integer> sortedBestAlbumList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();

            List<Song> songList = bestAlbumMap.get(genre);
            songList.sort((songA, songB) -> songB.play - songA.play);

            for (int i = 0; i < Math.min(2, songList.size()); i++) sortedBestAlbumList.add(songList.get(i).index);
        }

        return sortedBestAlbumList.stream().mapToInt(i -> i).toArray();
    }

    private record Song(int play, int index) {
    }

    public static void main(String[] args) {
        베스트앨범 problem = new 베스트앨범();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println("problem = " + Arrays.toString(problem.solution(genres, plays)));
    }
}
