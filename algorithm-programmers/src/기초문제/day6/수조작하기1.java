package 기초문제.day6;

public class 수조작하기1 {     // Review Required

    public int solution(int n, String control) {

        for (int i = 0; i < control.length(); i++) {

            switch (control.charAt(i)) {

                case 'w' :
                    n += 1;
                    break;

                case 's' :
                    n -= 1;
                    break;

                case 'd' :
                    n += 10;
                    break;

                case 'a' :
                    n -= 10;
                    break;
            }
        }

        return n;
    }

    public static void main(String[] args) {

        수조작하기1 control = new 수조작하기1();

        System.out.println("Result : " + control.solution(0, "wsdawsdassw"));
    }
}
