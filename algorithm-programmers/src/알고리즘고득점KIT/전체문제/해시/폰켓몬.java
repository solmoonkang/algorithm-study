package 알고리즘고득점KIT.전체문제.해시;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Set<Integer> pokémonSet = new HashSet<>();
        for (int number : nums) pokémonSet.add(number);

        return Math.min(pokémonSet.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        폰켓몬 problem = new 폰켓몬();

        int[] nums1 = {3, 1, 2, 3};
        System.out.println("problem = " + problem.solution(nums1));


        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println("problem = " + problem.solution(nums2));


        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println("problem = " + problem.solution(nums3));
    }
}
