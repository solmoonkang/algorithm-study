package datastructure.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ExampleList {

    public static void main(String[] args) {

        List<String> flowers = new ArrayList<>();


        // ======= add(  ) =======
        System.out.println("======= add(  ) =======");

        flowers.add("장미꽃");
        flowers.add("국화꽃");
        flowers.add("할미꽃");

        for (String flower : flowers) {

            System.out.println(flower);
        }


        // ======= remove(  ) =======
        System.out.println("======= remove(  ) =======");

        flowers.remove("국화꽃");

        for (String flower : flowers) {

            System.out.println(flower);
        }


        // ======= get(  ) =======
        System.out.println("======= get(  ) =======");

        String firstFlower = flowers.get(0);

        System.out.println(firstFlower);


        // ======= set(  ) =======
        System.out.println("======= set(  ) =======");

        flowers.set(0, "할미꽃");
        flowers.set(1, "장미꽃");

        for (String flower : flowers) {

            System.out.println(flower);
        }


        // ======= size(  ) =======
        System.out.println("======= size(  ) =======");

        flowers.add("안개꽃");
        flowers.add("동백꽃");

        int numOfFlowers = flowers.size();

        System.out.println(numOfFlowers);


        // ======= contains(  ) =======
        System.out.println("======= contains(  ) =======");

        boolean has동백꽃 = flowers.contains("동백꽃");
        boolean has국화꽃 = flowers.contains("국화꽃");

        System.out.println(has동백꽃);
        System.out.println(has국화꽃);
    }
}
