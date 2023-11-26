package structures.linearstructure.list.arraylist;

// ArrayList 를 사용하기 위해선 해당 패키지를 명시하여 가져와야 한다
import java.util.ArrayList;
import java.util.Arrays;

public class ExampleCreateArrayList {

    public static void main(String[] args) {

        // 타입 설정 시 Integer 객체만 적재가 가능하다
        ArrayList<Integer> members = new ArrayList<>();

        // 초기 용량( capacity ) 지정
        ArrayList<Integer> num3 = new ArrayList<>(10);

        // 배열을 넣어서 생성한다
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 다른 컬렉션으로부터 그대로 요소를 받아와서 생성한다
        ArrayList<Integer> list3 = new ArrayList<>(list2);
    }
}
