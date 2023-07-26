package datastructure.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {

    public static void main(String[] args) {

        // 정수가 있는 리스트를 하나씩 순회하면서 값을 출력
        List<Integer> list = new ArrayList<>();

        // 이를 스트림으로 변환
        Stream<Integer> stream = list.stream();

        stream.forEach(System.out::println);
    }
}
