/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks.geometric;
import java.util.*;

/**
 *
 * @author ROHANME
 */
public class ClosestPair{
	public static void main(String[] args){
		Random rand = new Random();
		int n = 10;
		Point[] pArr = new Point[n];
		for(int i = 0; i < n; ++i){
                        pArr[i] = new Point();
			pArr[i].x = rand.nextInt(100);
			pArr[i].y = rand.nextInt(100);
		}
		long startTime = System.currentTimeMillis();
		Pair p = bruteForce(pArr);
		System.out.println("Brute force "+p+" "+(System.currentTimeMillis()-startTime));
		p = divideAndConquer(pArr);
		System.out.println("Divide and Conquer "+p+" "+(System.currentTimeMillis()-startTime));
	}
	
	public static Pair divideAndConquer(Point[] pArr){
		if(pArr.length <= 3){
			return bruteForce(pArr);
		}
		sortByXAxis(pArr);
		int mid = pArr.length/2;
		Point[] leftArrX = Arrays.copyOfRange(pArr, 0, mid);
		Point[] rightArrX = Arrays.copyOfRange(pArr, mid, pArr.length);
		Pair leftMinDistSq = divideAndConquer(leftArrX);
		Pair rightMinDistSq = divideAndConquer(rightArrX);
		Pair shortestDistPair = leftMinDistSq;
                long shortestDistSq = leftMinDistSq.distSq;
		if(rightMinDistSq.distSq < shortestDistSq){
                    shortestDistPair = rightMinDistSq;
                    shortestDistSq = rightMinDistSq.distSq;
		}

		Point midPair = pArr[mid+1];
		sortByYAxis(pArr);
		List<Point> tempList = new ArrayList();
		for(Point p: pArr){ //n
			if(p != midPair && p.x-midPair.x < shortestDistSq){
				tempList.add(p);
			}
		}
		
		Point[] tempArr = new Point[tempList.size()];
		tempList.toArray(tempArr);
		
		for(int i = 0; i < tempArr.length-1; ++i){//n
			for(int j = i+1; j < tempArr.length; ++j){
				if(tempArr[i].y - tempArr[j].y > shortestDistSq){
					break;
				}
				long tempDistSq = getDistanceSq(tempArr[i], tempArr[j]);
				if(getDistanceSq(tempArr[i], tempArr[j]) < shortestDistSq){
					shortestDistPair.p1 = tempArr[i];
					shortestDistPair.p2 = tempArr[j];
					shortestDistPair.distSq = tempDistSq;
				}
			}
		}
		return shortestDistPair;
	}
	
	public static void sortByXAxis(Point[] pArr){
		Arrays.sort(pArr, new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				if(p1 == null || p2 == null){
					return -1;
				}
				return p1.x - p2.x;
			}
		});
	}
	
	public static void sortByYAxis(Point[] pArr){
		Arrays.sort(pArr, new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				if(p1 == null || p2 == null){
					return -1;
				}
				return p1.y - p2.y;
			}
		});
	}
	
	public static Pair bruteForce(Point[] pArr){
		long shortestDistSq = Long.MAX_VALUE;
		Pair shortestPair = new Pair();
		for(int i = 0; i < pArr.length-1; ++i){
			for(int j = i+1; j < pArr.length; ++j){
				long distSq = getDistanceSq(pArr[i], pArr[j]);
				if(distSq < shortestDistSq){
					shortestPair.p1 = pArr[i];
					shortestPair.p2 = pArr[j];
					shortestPair.distSq = distSq;
                                        shortestDistSq = distSq;
				}
			}
		}
		return shortestPair;
	}
	
	public static long getDistanceSq(Point p1, Point p2){
		if(p1 == null || p2 == null){
			return Long.MAX_VALUE;
		}
		return (long)Math.pow(p1.x-p2.x, 2) + (long)Math.pow(p1.y-p2.y, 2);
	}
}

class Point{
	int x;
	int y;
        
        public String toString(){
            return x+" "+y;
        }
}

class Pair{
	Point p1;
	Point p2;
	long distSq;
	
	Pair(Point d1, Point d2, int distance){
		p1 = d1;
		p2 = d2;
		distSq = distance;
	}
	
	Pair(){
	}
        
        public String toString(){
            return p1+" "+p2+" "+Math.pow(distSq, 0.5);
        }
}

