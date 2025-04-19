package com.learning.arrays.medium;

public class IncreasingTripletSubsequencs {
    public static void main(String[] args) {
        int[] case1 = {1,2,3,4,5};
        System.out.println(increasingTripletBrute(case1));
        System.out.println(increasingTriplet(case1));
        int[] case2 = {5,4,3,2,1};
        System.out.println(increasingTripletBrute(case2));
        System.out.println(increasingTriplet(case2));
        int[] case3 = {2,1,5,0,4,6};
        System.out.println(increasingTripletBrute(case3));
        System.out.println(increasingTriplet(case3));
        int[] case4 = {20,100,10,12,5,13};
        System.out.println(increasingTripletBrute(case4));
        System.out.println(increasingTriplet(case4));
    }

    public static boolean increasingTripletBrute(int[] nums) {
        int l= nums.length;
        for(int i=0;i<l-2;i++){
            for(int j=i+1;j<l-1;j++){
                for(int k=j+1;k<l;k++){
                    if(nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }
        return false;

    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num :nums){
            if(num <= first){
                first = num;
            }else if(num <= second){
                second = num;
            }else{
                return true;
            }
        }
        return false;

    }
}
