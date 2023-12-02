package algorithms.structures.linearstructure.array;

import java.util.Arrays;

public class ExampleOutputForArray {

    public static void main(String[] args) {

        System.out.println("===== Array.toString =====");
        // 배열의 모든 요소를 [ 첫 번째 요소, 두 번째 요소, ... ] 형식의 문자열로 변환한다

        int[] array = {10, 20, 30, 40, 50};

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(array));





        System.out.println("===== System.arraycopy =====");
        // 배열을 한 번 생성하면, 크기를 변경할 수 없으므로, 더 많은 저장공간이 필요하면, 큰 배열을 새로 만들고 기존 배열을 새로운 배열에 복사한다

        int[] wheels = new int[5];
        int[] vehicles = new int[wheels.length * 2];    // 기존 배열보다 2배 더 큰 길이를 갖는 배열을 생성한다

        for (int i = 0; i < wheels.length * 2; i++) {

            // wheels[i]의 값을 vehicles[i]에 복사한다
            vehicles[i] = array[i];

            // 참조변수 wheels 가 새로운 배열을 가리키게 한다
            // wheels 와 vehicles 는 이름만 다를 뿐 동일한 배열이다
            wheels = vehicles;
        }


        for (int i = 0; i < wheels.length * 2; i++) {

            vehicles[i] = array[i];
        }

        System.arraycopy(wheels, 0, vehicles, 0, wheels.length);
    }
}
