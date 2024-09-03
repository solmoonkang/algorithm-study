package programmers.모든문제.level1.알고리즘고득점KIT;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Map<Integer, Integer> phoneketmon = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            phoneketmon.put(nums[i], i);
        }

        return Math.min(phoneketmon.size(), nums.length / 2);
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
