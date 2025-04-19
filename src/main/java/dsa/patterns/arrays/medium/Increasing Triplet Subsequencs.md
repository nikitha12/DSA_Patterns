## LC 334. Increasing Triplet Subsequence

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
```
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
```

Example 2:
```
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
```

Example 3:
```
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
```

### Approaches  

1. [Brute Force Approach](#brute-force-approach)
2. [Linear Scan with Two Variables](#linear-scan-with-two-variables)

### Brute Force Approach
#### Intuition 
- For all the available triplets check if it satisfies  i < j < k and nums[i] < nums[j] < nums[k]
- i < j < k can be achived using for loops with indeces of inner loops se to next element to avoid j< i and k<j or k<i

#### Implementation

```java
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
   ```
#### Complexity Analysis:
- **Time Complexity**: O(n^3), due to the three nested loops over the array.
- **Space Complexity**: O(1), since we are not using any additional data structures.

---

### Linear Scan with Two Variables
#### Intuition 
The goal is to find three increasing numbers a, b, c such that a < b < c. We can achieve this in linear time with two variables:
- `first`: This will keep track of the smallest number found so far.
- `second`: This will keep track of a number larger than `first`.
```java
public boolean increasingTriplet(int[] nums) {
    // Initialize the first and second variables to the maximum possible value
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    // Traverse the array
    for (int num : nums) {
        // If current number is less than or equal to the first, update first
        if (num <= first) {
            first = num;
        // Else if current number is less than or equal to the second, update second
        } else if (num <= second) {
            second = num;
        // Else we found a number greater than both first and second
        } else {
            return true;
        }
    }
    return false;
}
```

#### Complexity Analysis:
- **Time Complexity**: O(n), where n is the number of elements in the array. We only require one pass through the array.
- **Space Complexity**: O(1), since we are using only a constant amount of additional space.
