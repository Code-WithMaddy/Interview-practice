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

	//class for Min Heap Objects
	class MinHeap{
		int[] heapArr; //Array in which heap will be stored
		int heapSize; //Array size of heap 
		
		//this will return parent node index of current index node
		int parent(int node){
			return (node-1)/2;
		}
		
		//this will return left child node index of current index node
		int left(int node){
			return (2*node)+1;
		}
		
		//this will return right child node index of current index node
		int right(int node){
			return (2*node)+2;
		}
		
		//this will return minimum element from the heap
		int getMin(){
			return heapArr[0];
		}
		
		//Constructor is used to create min heap from given input array 
		MinHeap(int[] a, int size){
			heapSize=size;
			heapArr=a;
			int index= (heapSize-1)/2;
			while(index>=0) {
				minHeapify(index);
				index--;
			}
		}
		
		//this method will extract minimum from the heap and heapify the
		//remaining heap after extraction of minimum node.
		int extractMin() {
			if(heapSize==0) {
				return Integer.MIN_VALUE;
			}
			
			int root = heapArr[0];
			
			if(heapSize>1) {
				heapArr[0]=heapArr[heapSize-1];
				minHeapify(0);
			}
			
			heapSize--;
			return root;
		}
		
		//method is used to heapify the remaining nodes of heap, means 
		//maintaing the property of min heap for remaining nodes.
		void minHeapify(int index) {
			int l = left(index);
			int r = right(index);
			int smallest =index;
			if(l<heapSize && heapArr[l]<heapArr[index]) {
				smallest = l;
			}
			if(r<heapSize && heapArr[r]<heapArr[smallest]) {
				smallest = r;
			}
			if(smallest!=index) {
				int t= heapArr[index];
				heapArr[index] = heapArr[smallest];
				heapArr[smallest]=t;
				minHeapify(smallest);
			}
		}
	}
	
	//Method is used to find the kth smallest element in given array using min heap
	int findKthSmallestUsingMinHeap(int[] arr , int n, int k) {
		//used to store the given array to min heap
		MinHeap min = new MinHeap(arr, n);
		
		//extracting the k-1 elements from min heap
		for(int i=0;i<k-1;i++) {
			min.extractMin();
		}
		//returning the root after extracting k-1 elements from min heap. 
		return min.getMin();
	}
	public static void main(String[] args) {
		//Initializing input
		int[] arr = {6,9,3,2,19,14};
		int k=4;
		//System.out.println(k+"th smallest element in given array is: "+findKthSmallest(arr, k));
		KthLargestSamllest obj = new KthLargestSamllest();
		System.out.println(k+"th smallest element in given array is: "+obj.findKthSmallestUsingMinHeap(arr, arr.length, k));
		
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
