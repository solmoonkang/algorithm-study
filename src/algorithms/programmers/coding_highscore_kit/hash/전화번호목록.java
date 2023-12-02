package algorithms.programmers.coding_highscore_kit.hash;

import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {

    public boolean solution_sort(String[] phone_book) {

        // 전화번호 목록을 정렬한다
        Arrays.sort(phone_book);

        boolean result = true;

        // 전화번호 목록의 첫 번째 요소를 모든 전화번호 목록과 비교
        for (int i = 0; i < phone_book.length - 1; i++) {

            // 만약, 첫 번째 요소와 전화번호 목록에 동일한 요소가 있다면 false, 없다면 true 를 반환한다
            if (phone_book[i + 1].contains(phone_book[i])) {
                result = false;
                break;
            }
        }

        return result;
    }

    public boolean solution_hash(String[] phone_book) {

        boolean answer = true;

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {

            hashMap.put(phone_book[i], "prefix");
        }

        for (String phone : phone_book) {

            for (int i = 1; i < phone.length(); i++) {

                if (hashMap.containsKey(phone.substring(0, i))) {

                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] phone1 = {"119", "97674223", "1195524421"};
        String[] phone2 = {"123", "456", "789"};
        String[] phone3 = {"12", "123", "1235", "567", "88"};

        전화번호목록 phone_number = new 전화번호목록();

        System.out.println("Solution : " + phone_number.solution_sort(phone1));
        System.out.println("Solution : " + phone_number.solution_sort(phone2));
        System.out.println("Solution : " + phone_number.solution_sort(phone3));
        System.out.println("----------------------------------------");

        System.out.println("Solution Hash : " + phone_number.solution_hash(phone1));
        System.out.println("Solution Hash : " + phone_number.solution_hash(phone2));
        System.out.println("Solution Hash : " + phone_number.solution_hash(phone3));
    }
}
