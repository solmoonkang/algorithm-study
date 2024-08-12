package programmers.모든문제.level0.코딩테스트입문;

public class 로그인성공 {

    static String[] messages = {"login", "fail", "wrong pw"};

    public String solution(String[] id_pw, String[][] db) {
        String identity = id_pw[0];
        String password = id_pw[1];

        for (String[] strings : db) {
            if (identity.equals(strings[0])) {
                return password.equals(strings[1]) ? messages[0] : messages[2];
            }
        }

        return messages[1];
    }

    public static void main(String[] args) {
        로그인성공 successLogin = new 로그인성공();

        String[] id_pw1 = {"meosseugi", "1234"};
        String[][] db1 = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
        System.out.println("successLogin = " + successLogin.solution(id_pw1, db1));

        String[] id_pw2 = {"programmer01", "15789"};
        String[][] db2 = {{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}};
        System.out.println("successLogin = " + successLogin.solution(id_pw2, db2));

        String[] id_pw3 = {"rabbit04", "98761"};
        String[][] db3 = {{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}};
        System.out.println("successLogin = " + successLogin.solution(id_pw3, db3));
    }
}
