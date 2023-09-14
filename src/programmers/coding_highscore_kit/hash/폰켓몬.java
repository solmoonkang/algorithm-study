package programmers.coding_highscore_kit.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class 폰켓몬 {

    /**
     * 문제 설명
     *
     * 폰켓몬이 들어있는 nums 배열에 있는 N 마리의 폰켓몬 중 N/2 마리를 가져갈 수 있다 ( 즉, nums 배열의 절반을 가져갈 수 있다 )
     * 또한, 각 폰켓몬은 종류에 따라 번호를 부여하였다 ( 같은 종류의 폰켓몬의 경우, 당연히 같은 번호를 부여받는다 )
     * 결론적으로, N 마리의 폰켓몬 중 N/2 마리의 폰켓몬을 선택할 때, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 폰켓몬의 종류 번호의 개수를 return 한다
     *
     * 문제 단순화하기
     *
     * 최대값을 구하기 위해 nums.length 에서 2를 나눈 값을 max 값에 대입한다
     * 중복을 제거한 값을 구하기 위해 Set 을 이용해 nums 에 담아준다
     * 중복을 제거한 Set 의 크기가 max 보다 크면 max 를, 작으면 Set 사이즈를 리턴한다
     */


    public int solution_hash(int[] nums) {

        // 최대값을 구하기 위해 nums.length 을 2로 나눈 max 값을 구한다
        int max = nums.length / 2;

        // 중복을 제거한다
        HashSet<Integer> hashSet = new HashSet<>();

        // Set 을 이용해 nums 배열에 중복을 제거한 값을 담아준다
        for (int num : nums) {
            hashSet.add(num);
        }

        // 중복을 제거한 Set 의 크기가 max 보다 크면 max 를, 작으면 Set 의 크기를 리턴한다
        if (hashSet.size() > max) {
            return max;
        } else {
            return hashSet.size();
        }
    }

    public int solution_array(int[] nums) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }

    public static void main(String[] args) {

        int[] num1 = {3, 1, 2, 3};
        int[] num2 = {3, 3, 3, 2, 2, 4};
        int[] num3 = {3, 3, 3, 2, 2, 2};

        폰켓몬 phonekemons = new 폰켓몬();

//        System.out.println("Phonekemons : " + phonekemons.solution_hash(num1));
//        System.out.println("Phonekemons : " + phonekemons.solution_hash(num2));
//        System.out.println("Phonekemons : " + phonekemons.solution_hash(num3));
//        System.out.println("------------------------------------------------");

        System.out.println("Phonekemons : " + phonekemons.solution_array(num1));
        System.out.println("Phonekemons : " + phonekemons.solution_array(num2));
        System.out.println("Phonekemons : " + phonekemons.solution_array(num3));
    }
}
