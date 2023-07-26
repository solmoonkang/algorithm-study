package datastructure.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학생정보관리 {

    public String student(String[] studentNames, String[] studentNumbers, String name) {

        Map<String, String> studentInfo = new HashMap<>();

        for (int i = 0; i < studentNames.length; i++) {

            String studentName = studentNames[i];
            String studentNumber = studentNumbers[i];

            studentInfo.put(studentName, studentNumber);
        }

        if (studentInfo.containsKey(name)) {

            return studentInfo.get(name);
        } else {

            return "해당 학생의 정보는 등록되어 있지 않습니다";
        }
    }

    public static void main(String[] args) {

        학생정보관리 studentInformation = new 학생정보관리();

        String[] studentNames = {"홍길동", "홍명보", "홍익길", "홍박균", "홍국이"};

        String[] studentNumbers = {"010-1010-0101", "010-2020-0202", "010-3030-0303", "010-4040-0404", "010-5050-0505"};

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("찾는 학생의 이름을 입력해주세요 : ");

            String name = scanner.nextLine();

            String result = studentInformation.student(studentNames, studentNumbers, name);

            if (!name.equals("종료")) {

                break;
            }

            if (result == null) {

                System.out.println("학생의 정보를 등록해주세요");
            } else {

                System.out.println(name + " 학생의 전화번호는 " + result);
            }

        }
    }
}
