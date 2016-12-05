/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author rohan_000
 */
public class DiningPhilosophers implements Runnable {
    private int index;
    static DinerLock[] lockArr;
    static int n;
    
    DiningPhilosophers(int ind){
        index = ind;
    }
    
    public static void main(String args[]){
        n = 10;
        lockArr = new DinerLock[n-1];
        for(int i = 0; i < n-1; i++){
            lockArr[i] = new DinerLock();
        }
        
        for(int i = 0; i < n; i++){
            DiningPhilosophers dp = new DiningPhilosophers(i);
            Thread t = new Thread(dp, ""+i);
            t.start();
        }
    }
    @Override
    public void run() {
        int leftInd = index;
        int rightInd = index+1;
        if(rightInd > n-2){
            rightInd = 0;
        }
        if(leftInd > n-2){
            leftInd = 0;
        }
        try{
            boolean isEating = false;
            while(lockArr[leftInd].tryLock("left spoon"+leftInd) 
                    && lockArr[leftInd].isAvailable 
                    && lockArr[rightInd].isAvailable){
                //Thread.sleep((long)(1000*Math.random()));
                if(!lockArr[rightInd].tryLock("right spoon "+rightInd)){
                    lockArr[leftInd].unlock("left spoon "+leftInd);
                }
                else{
                    lockArr[rightInd].markUnAvailable();
                    lockArr[leftInd].markUnAvailable();
                    System.out.println(Thread.currentThread().getName() + " holds both spoons "+leftInd+" "+rightInd);
                    isEating = true;
                    break;
                }
                //Thread.sleep((long)(1000*Math.random()));
            }
            if(!isEating){
                System.out.println(Thread.currentThread().getName() + " cannot eat");
            }
            
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}

class DinerLock{
    boolean isLocked = false;
    boolean isAvailable = true;
    public synchronized boolean tryLock(String spoon) throws InterruptedException{
        if(isLocked){
            return false;
        }
        isLocked = true;
        System.out.println(Thread.currentThread().getName()+" has picked up "+spoon);
        return true;
    }
    
    public synchronized void unlock(String spoon) throws InterruptedException{
        isLocked = false;
        System.out.println(Thread.currentThread().getName()+" has given up "+spoon);
        //notify();
    }
    
    public boolean available(){
        return isAvailable;
    }
    
    public synchronized void markUnAvailable(){
        isAvailable = false;
    }
}
