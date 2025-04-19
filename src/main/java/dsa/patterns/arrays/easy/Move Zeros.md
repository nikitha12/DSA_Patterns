## 283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
```
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
```

Example 2:
```
Input: nums = [0]
Output: [0]
```

## Approaches
1. [Brute Force Approach](#brute-force-approach)
2. [Two Pointer Approach](#two-pointer-approach)
3. 
### Brute Force Approach
#### Intuition:
Iterating through all elements and moving nonzero elements to a new array 
Filling the rest of the array with zeros and copying the result array


#### Complexity Analysis:
- **Time Complexity:** O(n), where n is the length of the array.
- **Space Complexity:** O(n), due to the use of additional array.

-----

### Two Pointer Approach
#### Intuition:
- Have a pointer to signify the index of next nonzero element 
- Another pointer to traverse the array and find the nonzero elements 
- On finding nonzero element swap the element to the insertion pointer 
- Fill the rest of the array with 0s 
```java 
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
```

#### Complexity Analysis:
- **Time Complexity:** O(n), where n is the length of the array.
- **Space Complexity:** O(1), since we are modifying the array in place without using additional storage.
```java
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
```
---

### Optimised (with swaps of zeros and non zeros)
#### Intuition:
- Pointer to track zeros (lastZeroPosition)
- Traverse through array to find nonzero
- On finding nonzero element swap with the lastZeroPosition and move the lastZeroPosition


#### Complexity Analysis:
- **Time Complexity:** O(n), where n is the length of the array.
- **Space Complexity:** O(1), since we are modifying the array in place without using additional storage.

```java
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
```
---




