/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 *
 * @author ROHANME
 */
public class SortingDemo2 {
        public static void main(String args[]) {
        int n = 25;
        int[] arr = new int[n];
        IntStream.range(0, n - 1).forEach(i -> arr[i] = (int) ((10000) * Math.random()));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(quickSort(arr)));
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
        //System.out.println(Arrays.toString(bubbleSort(arr)));
    }
 public static int[] bubbleSort(int[] arr){
	if(arr == null){
		return null;
	}
	int len = arr.length;
	int[] newArr = Arrays.copyOf(arr, len);
	for(int i = len-1; i > 0; --i){
		boolean swapMade = false;
		for(int j = 1; j <= i; ++j){
			if(newArr[j] < newArr[j-1]){
				swapMade = true;
				int temp = newArr[j];
				newArr[j] = newArr[j-1];
                                newArr[j-1] = temp;
			}
		}
		if(!swapMade){
			break;
		}
	}
	return newArr;
}


public static int[] selectionSort(int[] arr){
	if(arr == null){
		return null;
	}
	int len = arr.length;
	int[] newArr = Arrays.copyOf(arr, len);
	for(int i = 0; i < len; ++i){
		int ind = i;
		for(int j = i+1; j < len; ++j){
			if(newArr[ind] > newArr[j]){
				ind = j;
			}
		}
		int temp = newArr[ind];
		newArr[ind] = newArr[i];
		newArr[i] = temp;
	}
        return newArr;
}

public static int[] insertionSort(int[] arr){
	if(arr == null){
		return null;
	}
	int len = arr.length;
	int[] newArr = Arrays.copyOf(arr, len);
	for(int i = 1; i < len; ++i){
		for(int j = i-1; j >= 0; --j){
			if(newArr[j] > newArr[j+1]){
				int temp = newArr[j+1];
                                newArr[j+1] = newArr[j];
				newArr[j] = temp;
			}
		}
	}
	return newArr;
}

public static int[] quickSort(int[] arr){
	if(arr == null){
		return null;
	}
	int len = arr.length;
	int[] newArr = Arrays.copyOf(arr, len);
	partitionRandom(newArr, 0, len-1);
        return newArr;
}

public static void partitionRandom(int[] arr, int startInd, int endInd){
	int incInd = startInd;
	int decInd = endInd;
	if(startInd >= endInd){
		return;
	}
        int pivotInd = ThreadLocalRandom.current().nextInt(startInd, endInd+1);
	while(decInd >= pivotInd && incInd <= pivotInd){
		while(arr[decInd] > arr[pivotInd]){
			--decInd;
		}
		while(arr[incInd] < arr[pivotInd]){
			++incInd;
		}
		if(decInd >= incInd){
			int temp = arr[decInd];
			arr[decInd] = arr[incInd];
			arr[incInd] = temp;
                        --decInd;
                        ++incInd;
		}
	}
	partitionRandom(arr, startInd, decInd);
	partitionRandom(arr, incInd, endInd);
}

public static int[] mergeSort(int[] arr, int startInd, int endInd){
	if(arr == null){
		return null;
	}
	if(startInd > endInd){
		return new int[0];
	}
        if(startInd == endInd){
            return new int[]{arr[startInd]};
        }
	int len = arr.length;
	int mid = (startInd+endInd)/2;
	return merge(mergeSort(arr, startInd, mid), mergeSort(arr, mid+1, endInd));
}

public static int[] merge(int[] arr, int[] arr1){
	int i = 0;
	int j = 0;
        int len = arr.length;
        int len1 = arr1.length;
	int k = 0;
	int[] newArr = new int[len+len1];
	while(i < len && j < len1){
		if(arr[i] < arr1[j]){
			newArr[k++] = arr[i++];
		}
		else{
			newArr[k++] = arr1[j++];
		}
	}
	
	while(i < len){
		newArr[k++] = arr[i++];
	}
	
	while(j < len1){
		newArr[k++] = arr1[j++];
	}
	
	return newArr;
}

}
