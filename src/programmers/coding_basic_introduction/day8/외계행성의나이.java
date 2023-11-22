package programmers.coding_basic_introduction.day8;

public class 외계행성의나이 {

    /**
     * 우주여행을 하던 머쓱이는 엔진 고장으로 PROGRAMMERS-962 행성에 불시착하게 됐습니다.
     * 입국심사에서 나이를 말해야 하는데, PROGRAMMERS-962 행성에서는 나이를 알파벳으로 말하고 있습니다.
     * a는 0, b는 1, c는 2, ..., j는 9입니다. 예를 들어 23살은 cd, 51살은 fb로 표현합니다.
     * 나이 age가 매개변수로 주어질 때 PROGRAMMER-962식 나이를 반환하라.
     */
    public String solution(int age) {
        // TODO: char 배열에 대한 개념이 부족하여 공부가 필요하다.
        StringBuilder stringBuilder = new StringBuilder();
        String programmers962 = "abcdefghij";
        char[] digits = Integer.toString(age).toCharArray();

        for (char digit : digits) {
            stringBuilder.append(programmers962.charAt(Character.getNumericValue(digit)));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        외계행성의나이 ageOfAlienPlanet = new 외계행성의나이();
        System.out.println("Result: " + ageOfAlienPlanet.solution(23));
        System.out.println("Result: " + ageOfAlienPlanet.solution(51));
        System.out.println("Result: " + ageOfAlienPlanet.solution(100));
    }
}
