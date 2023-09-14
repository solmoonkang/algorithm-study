package programmers.coding_basic_training.level0.day8;

public class 글자이어붙여문자열만들기 {

    public String solution(String my_string, int[] index_list) {

        String answer = "";

        for (int i = 0; i < index_list.length; i++) {

            // answer = answer + String.valueOf(my_string.charAt(index_list[i]));
            answer += (my_string.charAt(index_list[i]));
        }

        return answer;
    }

    public static void main(String[] args) {

        글자이어붙여문자열만들기 makeString = new 글자이어붙여문자열만들기();

        int[] index1 = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        int[] index2 = {1, 2, 0, 0, 3};

        System.out.println("Result : " + makeString.solution("cvsgiorszzzmrpaqpe", index1));
        System.out.println("Result : " + makeString.solution("zpiaz", index2));
    }
}
