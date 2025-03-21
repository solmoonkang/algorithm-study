package 모든문제.level1.전체문제;

public class 문자열내P와Y의개수 {

    /**
     * [ 문제 설명 ]
     * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
     * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
     * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
     */
    boolean solution(String s) {
        int pCount  = 0;
        int yCount = 0;

        for (int i = 0; i < s.length(); i++) {
            String str = s.toLowerCase();
            if (str.charAt(i) == 'p') {
                pCount++;
            }
            if (str.charAt(i) == 'y') {
                yCount++;
            }
        }

        if (pCount != yCount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        문자열내P와Y의개수 numberOfPY = new 문자열내P와Y의개수();
        System.out.println("Result: " + numberOfPY.solution("pPoooyY"));
        System.out.println("Result: " + numberOfPY.solution("Pyy"));
    }
}
