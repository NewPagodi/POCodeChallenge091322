package com.revature.po.codechallenge;

import java.util.Arrays;

public class Main {
	
	static int reorderDigit(int a, String order) {
		int[] digits = new int[] {0,0,0,0,0, 0,0,0,0,0};
		
		int leftover = a;
		int curDigit = 0;
		
		while ( leftover > 0 ) {
			curDigit = leftover % 10;
			digits[curDigit] += 1;
			leftover /= 10;
		}
		
		int curBase = 1;
		int curInt = 0;
		
		if ( order.equals("asc") ) {
			
			// There's no need to compute leading 0s.
			for ( int i = 9 ; i > 0 ; --i ) {
				for ( int j  = 0 ; j < digits[i] ; ++j ) {
					curInt += curBase * i;
					curBase*=10;
				}
			}
		}
		else {
			for ( int i = 0 ; i < 10 ; ++i ) {
				for ( int j  = 0 ; j < digits[i] ; ++j ) {
					curInt += curBase * i;
					curBase*=10;
				}
			}
		}
		
		return curInt;
	}
	
	static public int[] reorderDigits(int[] arr, String order) {
		
		int[] arr2 = new int[arr.length];
		
		for ( int i = 0 ; i < arr.length ; ++i ) {
			arr2[i] = reorderDigit(arr[i], order);
		}
		
		return arr2;
	}
	
	
	static boolean canPartition(int... arr) {
		
		boolean partable = false;
		
		for ( int i = 0 ; i < arr.length ; ++i ) {
			int curProduct = 1;
			
			for ( int j = 0 ; j < arr.length ; ++j ) {
				if ( i != j ) {
					curProduct *= arr[j];
				}
			}
			
			if ( curProduct == arr[i] ) {
				partable = true;
				break;
			}
		}
		
		return partable;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[] {515, 341, 98, 44, 211};
		int[] arr2 = new int[] {515, 341, 98, 44, 211};
		int[] arr3 = new int[] {63251, 78221};
		int[] arr4 = new int[] {63251, 78221};
		int[] arr5 = new int[] {1, 2, 3, 4};
		int[] arr6 = new int[] {1, 2, 3, 4};

		System.out.println(Arrays.toString(reorderDigits(arr1, "asc")));
		System.out.println(Arrays.toString(reorderDigits(arr2, "desc")));
		System.out.println(Arrays.toString(reorderDigits(arr3, "asc")));
		System.out.println(Arrays.toString(reorderDigits(arr4, "desc")));
		System.out.println(Arrays.toString(reorderDigits(arr5, "asc")));
		System.out.println(Arrays.toString(reorderDigits(arr6, "desc")));

		System.out.println(canPartition(2, 8, 4, 1));
		System.out.println(canPartition(-1, -10, 1, -2, 20));
		System.out.println(canPartition(2, 8, 4, 1));
	}
}
