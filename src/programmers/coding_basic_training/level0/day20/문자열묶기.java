package programmers.coding_basic_training.level0.day20;

public class 문자열묶기 {

    public int solution(String[] strArr) {

        // strArr 의 원소들을 길이가 같은 문자열들끼리 그룹으로 묶었을 때, 가장 개수가 많은 그룹의 크기를 반환하라

        for (int i = 0; i < strArr.length; i++) {

            int s = strArr[i].length();

            System.out.print("s : " + s + ", ");



        }

        int answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        문자열묶기 tie = new 문자열묶기();

        String[] strArr = {"a", "bc", "d", "efg", "hi"};

        System.out.println("Result : " + tie.solution(strArr));
    }
}
