package leetcodeEasy;

/**
 * Author: [Your Name]
 * Date: March 10, 2025
 *
 * Problem: Given an array nums containing n distinct numbers in the range [0, n], 
 * return the missing number.
 *
 * Constraints:
 * - 1 <= n <= 10^4
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique.
 */

 import java.util.Arrays;

 public class MissingNumber {
 
     /**
      * Solution 1: XOR Approach
      * Time Complexity: O(n)
      * Space Complexity: O(1)
      * Uses the property: a ⊕ a = 0, and ⊕ is commutative.
      */
     public static int missingNumberXOR(int[] nums) {
         int xorAll = 0, xorNums = 0;
         int n = nums.length;
 
         for (int i = 0; i <= n; i++) {
             xorAll ^= i;  // XOR all numbers from 0 to n
         }
 
         for (int num : nums) {
             xorNums ^= num; // XOR all numbers in the array
         }
 
         return xorAll ^ xorNums; // The missing number
     }
 
     /**
      * Solution 2: Summation Formula Approach
      * Time Complexity: O(n)
      * Space Complexity: O(1)
      * Uses the formula: Sum(0 to n) - Sum(nums) = missing number
      */
     public static int missingNumberSum(int[] nums) {
         int n = nums.length;
         int expectedSum = n * (n + 1) / 2;
         int actualSum = Arrays.stream(nums).sum();
 
         return expectedSum - actualSum;
     }

 
     // Main function to test all implementations
     public static void main(String[] args) {
         int[] nums = {9,6,4,2,3,5,7,0,1};  // Example input
         System.out.println("Missing Number (XOR): " + missingNumberXOR(nums));
         System.out.println("Missing Number (Summation Formula): " + missingNumberSum(nums));
     }
 }
 