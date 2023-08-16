package programmers.foundation;

public class TwoDimensionalArray {

    public static void main(String[] args) {

        int[][] array = new int[][]
                {{100, 100, 100}, {20, 20, 20}, {30, 30, 30}, {10, 10, 10}};

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.println("Array[" + i + "][" + j + "] : " + array[i][j]);
            }
        }
    }
}
