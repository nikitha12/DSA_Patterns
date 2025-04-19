package dsa.patterns.arrays.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] case1 = {1,2,0};
        int[] case2 = {3,4,-1,1};
        int[] case3 = {7,8,9,11,12};
        System.out.println(firstMissingPositive_BruteForce(case1));
        System.out.println(firstMissingPositive_BruteForce(case2));
        System.out.println(firstMissingPositive_BruteForce(case3));
        System.out.println(firstMissingPositive_HashSet(case1));
        System.out.println(firstMissingPositive_HashSet(case2));
        System.out.println(firstMissingPositive_HashSet(case3));
        System.out.println(firstMissingPositive_Optimised(case1));
        System.out.println(firstMissingPositive_Optimised(case2));
        System.out.println(firstMissingPositive_Optimised(case3));

    }

    public static int firstMissingPositive_BruteForce(int[] nums) {
        int n = nums.length;
        // Starting from 1, check each integer in the array
        for (int i = 1; i <= n + 1; i++) {
            boolean found = false;
            // Check if i is present in the array
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            // If not found, then it's the missing positive
            if (!found) return i;
        }
        return -1; // The function should never reach here
    }

    public static int firstMissingPositive_HashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // Add all nums into the HashSet
        for (int num : nums) {
            set.add(num);
        }
        // Check from 1 to infinite for the first missing number
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1; // The function should never reach here
    }
    public static int firstMissingPositive_Optimised(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Swap numbers to their correct positions
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Determine the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // If all numbers 1 to n are present, return n+1
    }


}
