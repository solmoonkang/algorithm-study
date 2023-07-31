package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {

    public boolean solution(String[] phone_book) {

        boolean answer = true;

        Map<String, Integer> numberList = new HashMap<>();

        // 모든 전화번호를 저장하고
        for (int i = 0; i < phone_book.length; i++) {

            numberList.put(phone_book[i], i);
        }

        // 저장된 전화번호 중 동일한 전화번호가 있는지 확인한다



        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = {};       // 전화번호부에 적힌 전화번호를 담은 배열
    }
}
