package dsa.patterns.arrays.easy;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] case1 = {0,1,0,3,12};
        moveZeros_BruteForce(case1);
        System.out.println(Arrays.toString(case1));
        int[] case2 = {0};
        moveZeros_TwoPointer(case2);
        System.out.println(Arrays.toString(case2));
        int[] case3 = {1,9,0,1,0,4,5};
        move_Zero_Optimised(case3);
        System.out.println(Arrays.toString(case3));
    }
    // BruteForce
    public static void moveZeros_BruteForce(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        int resultIndex=0;
        // Add non zero elements to result
        for(int num: nums){
            if(num!=0) {
                result[resultIndex] = num;
            }
        }
        // Add zero elements to result
        for(int i=resultIndex;i<nums.length;i++){
            result[i] =0;
        }
        // Copy final array to original
        System.arraycopy(result,0,nums,0,n);

    }
    public static void moveZeros_TwoPointer(int[] nums){
        int insertIndex =0;
        // Insert nonzero elements to start of array while ignoring 0s
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertIndex]=nums[i];
                insertIndex++;
            }
        }
        // Insert the remaining elements with 0
        while(insertIndex<nums.length){
            nums[insertIndex]=0;
            insertIndex++;
        }

    }

    public static void move_Zero_Optimised(int[] nums){

        int lastZeroPosition = 0;
        // Swap the zero with a non zero element
        for(int current=0;current<nums.length;current++){
            if(nums[current] !=0){
                if(current!=lastZeroPosition) {
                    int temp = nums[current];
                    nums[current] = nums[lastZeroPosition];
                    nums[lastZeroPosition] = temp;
                }
                lastZeroPosition++;
            }
        }
        // No need to move add the zeros at end as they are moved to the end with the swaps
    }
}
