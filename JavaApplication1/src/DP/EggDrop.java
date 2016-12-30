/*
The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.
 */
package DP;

import java.util.*;

/**
 *
 * @author rohan_000
 */
public class EggDrop{
	public static void main(String args[]){
		System.out.println(drop(3, 10));
	}
	
	static Map<String, Integer> map = new HashMap();
	static int drop(int eggsRemaining, int floorCount){
		if(floorCount <= 0){
			return 0;
		}
                if(eggsRemaining <= 0){
                    return Integer.MAX_VALUE;
                }
                if(eggsRemaining == 1){
                    return floorCount;
                }
                if(floorCount == 1){
                    return 1;
                }
		String key = eggsRemaining+"_"+floorCount;
		Integer minTrialsWrapper = map.get(key);
		if(minTrialsWrapper != null){
			return minTrialsWrapper;
		}
		int minTrials = Integer.MAX_VALUE;
		for(int i = 1; i < floorCount; ++i){
                        //Max used since we need worst case
                        int tempVal = Math.max(drop(eggsRemaining-1, floorCount - 1), drop(eggsRemaining, floorCount-i));
                        if(tempVal < Integer.MAX_VALUE){
                            minTrials = Math.min(minTrials, 1+tempVal);
                        }
		}
		map.put(key, minTrials);
		return minTrials;
	}
}