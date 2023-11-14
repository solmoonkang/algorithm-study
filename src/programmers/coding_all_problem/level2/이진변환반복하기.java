package programmers.coding_all_problem.level2;

public class 이진변환반복하기 {

    public int[] binaryTransformation(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        이진변환반복하기 solution = new 이진변환반복하기();
    }
}


//    public int[] binaryTransformation(String s) {
//        int[] answer = new int[2];
//
//        while (!s.equals("1")) {    // s가 1이 될 때까지 반복해줄 반복문을 설정해준다
//            answer[0]++;            // answer[0]에 몇 회 반복되는지 확인하는 값이 들어므로 while 문 실행 시 1씩 증시킨다
//            String temp = s.replaceAll("0", "");    // replaceAll을 통해서 0을 공백으로 바꾼 후 0을 제거한 문자를 temp에 담는다
//            answer[1] += s.length() - temp.length();    // answer[1]에 0의 개수가 들어간다, s의 길이에서 0을 제거한 temp를 빼준다 = 제거한 0의 개수
//            s = Integer.toBinaryString(temp.length()).toString();   // temp의 길이를 2진수로 변환시킨 후 toString()을 통해 문자형으로 만들어준다
//        }
