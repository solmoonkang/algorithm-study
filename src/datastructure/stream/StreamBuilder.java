package datastructure.stream;

import java.util.stream.Stream;

public class StreamBuilder {

    public static void main(String[] args) {

        Stream<String> builderStream = Stream.<String> builder()
                .add("Eric")
                .add("Elena")
                .add("Java")
                .build();

        Stream<String> generateStream = Stream.generate(() -> "gen").limit(5);
    }
}
