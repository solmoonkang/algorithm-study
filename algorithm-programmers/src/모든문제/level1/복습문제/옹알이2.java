package 모든문제.level1.복습문제;

public class 옹알이2 {

    public int solution(String[] babbling) {
        String[] word = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String babble : babbling) {
            String modified = babble;

            for (String w : word) {
                modified = modified.replace(w, " ");
            }

            if (!modified.contains(word[0]) && !modified.contains(word[1]) && !modified.contains(word[2]) && !modified.contains(word[3])) {
                String[] parts = modified.split(" ");
                boolean isValid = true;

                for (String part : parts) {
                    if (!part.isEmpty()) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        옹알이2 problem = new 옹알이2();

        String[] babbling1 = {"aya", "yee", "u", "maa"};
        System.out.println("problem = " + problem.solution(babbling1));

        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println("problem = " + problem.solution(babbling2));
    }
}
