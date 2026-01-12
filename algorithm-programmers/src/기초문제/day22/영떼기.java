package 기초문제.day22;

public class 영떼기 {

    public String solution(String n_str) {

        // n_str 의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 반환하라

        int i = 0;

        while (i < n_str.length() && n_str.charAt(i) == '0') {

            i++;

        }

        return n_str.substring(i);
    }

    public String other(String n_str) {

        return "" + Integer.parseInt(n_str);

    }

    public static void main(String[] args) {

        영떼기 o = new 영떼기();

        System.out.println("Result : " + o.solution("0010"));
        System.out.println("Result : " + o.solution("854020"));
    }
}
