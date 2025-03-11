package leetcodeEasy;

/**
 * Author: Sachin Bhardwaj
 * Date: March 10, 2025
 *
 * LeetCode - 338
 * Problem: Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
 * ans[i] is the number of 1's in the binary representation of i.
 *
 * Constraints:
 * 0 <= n <= 10^5
 */

 import java.util.Arrays;

 public class CountingBits {
     
     // Method to count bits using DP + bitwise manipulation
     public static int[] countBits(int n) {
         int[] result = new int[n + 1];
 
         for (int i = 1; i <= n; i++) {
             // Count bits using previously computed value and last bit check
             result[i] = result[i >> 1] + (i & 1);
         }
 
         return result;
     }
 
     // Method to compute XOR of all numbers in the given range
     public static int computeXOR(int n) {
         /**
          * XOR properties:
          * n % 4 == 0 -> n
          * n % 4 == 1 -> 1
          * n % 4 == 2 -> n + 1
          * n % 4 == 3 -> 0
          */
         switch (n % 4) {
             case 0: return n;
             case 1: return 1;
             case 2: return n + 1;
             case 3: return 0;
             default: return 0; // Should never reach here
         }
     }
 
     // Binary Search function to find a target in an array
     public static int binarySearch(int[] arr, int target) {
         int left = 0, right = arr.length - 1;
 
         while (left <= right) {
             int mid = left + (right - left) / 2;
 
             if (arr[mid] == target) {
                 return mid; // Found target
             } else if (arr[mid] < target) {
                 left = mid + 1; // Search in the right half
             } else {
                 right = mid - 1; // Search in the left half
             }
         }
 
         return -1; // Target not found
     }
 
     // Main function to test the methods
     public static void main(String[] args) {
         int n = 5; // Example input
 
         // Compute counting bits
         int[] bitCounts = countBits(n);
         System.out.println("Counting Bits: " + Arrays.toString(bitCounts));
 
         // Compute XOR
         int xorResult = computeXOR(n);
         System.out.println("XOR from 0 to " + n + ": " + xorResult);
 
         // Example array for binary search
         int[] sortedArray = {0, 1, 2, 3, 4, 5};
         int target = 3;
         int searchIndex = binarySearch(sortedArray, target);
         System.out.println("Binary Search: Index of " + target + " is " + searchIndex);
     }
 }
 