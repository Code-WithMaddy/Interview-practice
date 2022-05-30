/*Kth Smallest/Largest Element In Unsorted Array Difficulty Level - Medium
 *Problem Statement
	Given an array and a number k where k is smaller than the size of the array, 
	we need to find the Kth  smallest element in the given array.
	It is given that all elements in the array are distinct. for eg.
	Input: arr[] = {6, 9, 3, 2, 19, 14}
			k = 3
	Output: 6
 */
package com.cwm.medium;

import java.util.Arrays;

public class KthLargestSamllest {

	public static void main(String[] args) {
		//Initializing input
		int[] arr = {6,9,3,2,19,14};
		int k=4;
		System.out.println(k+"th smallest element in given array is: "+findKthSmallest(arr, k));
		
	}
	//this method is used to find kth smallest element in given unsorted array
	//time complexity for this solution is O(N log N) and auxilary space complexity is O(1)
	public static int findKthSmallest(int[] arr, int k) {
		int result =0;
		//sort the array
		Arrays.sort(arr); //O(N log N)
		//returning k-1th index value from the array.
		result = arr[k-1];
		return result;
	}

}
