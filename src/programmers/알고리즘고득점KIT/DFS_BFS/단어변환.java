package programmers.알고리즘고득점KIT.DFS_BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 단어변환 {

    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        boolean[] visited = new boolean[words.length];
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);

        int depth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                String currentWord = deque.pollFirst();
                if (currentWord.equals(target)) return depth;

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && isOneLetterDifferent(currentWord, words[j])) {
                        visited[j] = true;
                        deque.add(words[j]);
                    }
                }
            }

            depth++;
        }

        return 0;
    }

    private boolean isOneLetterDifferent(String currentWord, String compareWord) {
        int differentWordCount = 0;

        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) - compareWord.charAt(i) != 0) differentWordCount++;
        }

        return differentWordCount == 1;
    }

    public static void main(String[] args) {
        단어변환 changeWord = new 단어변환();

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println("changeWord = " + changeWord.solution(begin1, target1, words1));

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println("changeWord = " + changeWord.solution(begin2, target2, words2));
    }
}
