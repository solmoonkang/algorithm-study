package 모든문제.level2.알고리즘고득점KIT;

import java.util.Arrays;
import java.util.HashSet;

public class 전화번호목록 {

    public boolean solution_iterator(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].equals(phone_book[i + 1].substring(0, phone_book[i].length()))) return false;
        }

        return true;
    }

    public boolean solution_hash(String[] phone_book) {
        HashSet<String> phoneBookNumbers = new HashSet<>(Arrays.asList(phone_book));

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (phoneBookNumbers.contains(number.substring(0, i))) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        전화번호목록 problem = new 전화번호목록();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        System.out.println("problem iterator = " + problem.solution_iterator(phone_book1));     // O(N logN)
        System.out.println("problem hash = " + problem.solution_hash(phone_book1));             // O(N)

        String[] phone_book2 = {"123", "456", "789"};
        System.out.println("problem iterator = " + problem.solution_iterator(phone_book2));
        System.out.println("problem hash = " + problem.solution_hash(phone_book2));

        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        System.out.println("problem iterator = " + problem.solution_iterator(phone_book3));
        System.out.println("problem hash = " + problem.solution_hash(phone_book3));
    }
}
