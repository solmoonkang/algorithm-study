package programmers.모든문제.level2;

import java.util.*;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String lastWord = list.get(i - 1);
            String currentWord = words[i];

            if (!currentWord.startsWith(lastWord.substring(lastWord.length() - 1)) || list.contains(words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            list.add(words[i]);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        영어끝말잇기 wordChain = new 영어끝말잇기();

        String[] firstWords = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println("wordChain = " + Arrays.toString(wordChain.solution(3, firstWords)));

        String[] secondWords = {"hello", "observe", "effect", "take", "either", "recognize", "encourage",
                "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println("wordChain = " + Arrays.toString(wordChain.solution(5, secondWords)));

        String[] thirdWords = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println("wordChain = " + Arrays.toString(wordChain.solution(2, thirdWords)));
    }
}
