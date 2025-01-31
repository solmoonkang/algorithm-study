package 모든문제.level1.전체문제;

public class 가운데글자가져오기 {

    /**
     * [ 문제 설명 ]
     * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
     */
    public String solution(String s) {
        int middle = (s.length() - 1) / 2;
        return (s.length() % 2 == 1) ? String.valueOf(s.charAt(middle)) : String.valueOf(s.charAt(middle)) + String.valueOf(s.charAt(middle + 1));
    }

    public static void main(String[] args) {
        가운데글자가져오기 getMiddleCharacter = new 가운데글자가져오기();
        System.out.println("Result: " + getMiddleCharacter.solution("abcde"));
        System.out.println("Result: " + getMiddleCharacter.solution("qwer"));
    }
}
