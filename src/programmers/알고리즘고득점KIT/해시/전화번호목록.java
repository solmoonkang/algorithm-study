package programmers.알고리즘고득점KIT.해시;

import java.util.Arrays;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        전화번호목록 problem = new 전화번호목록();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        System.out.println("problem = " + problem.solution(phone_book1));


        String[] phone_book2 = {"123", "456", "789"};
        System.out.println("problem = " + problem.solution(phone_book2));


        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println("problem = " + problem.solution(phone_book3));
    }
}
