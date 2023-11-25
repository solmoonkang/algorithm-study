package programmers.coding_basic_introduction.day9;

public class 모스부호1 {

    /**
     * 머쓱이는 친구에게 모스부호를 이용한 편지를 받았습니다.
     * 그냥은 읽을 수 없어 이를 해독하는 프로그램을 만들려고 합니다.
     * 문자열 letter가 매개변수로 주어질 때, letter를 영어 소문자로 바꾼 문자열을 반환하라.
     */
    public String solution(String letter) {
        String[] morseCode = {
                ".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."};
        String[] morse = letter.split(" ");

        String answer = "";
        for (String m : morse) {
            for (int i = 0; i < morseCode.length; i++) {
                if (m.equals(morseCode[i])) {
                    answer += Character.toString(i + 'a');
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        모스부호1 morseCode = new 모스부호1();
        System.out.println("Result: " + morseCode.solution(".... . .-.. .-.. ---"));
        System.out.println("Result: " + morseCode.solution(".--. -.-- - .... --- -."));
    }
}
