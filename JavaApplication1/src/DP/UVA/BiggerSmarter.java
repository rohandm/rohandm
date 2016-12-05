/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.UVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rohan_000
 */
public class BiggerSmarter {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        List<Elephant> eList = new ArrayList();
        String maxSeqStr = "";
        int maxSeq = 0;
        int n = scan.nextInt();
        int ind = 1;
        while(n != -1){
            Elephant el = new Elephant();
            el.setWeight(n);
            el.setIQ(scan.nextInt());
            el.setSeq(""+ind, 1);
            el.setIndex(ind++);
            eList.add(el);
            n = scan.nextInt();
            
        }
        Collections.sort(eList);
        Elephant[] elArr = (Elephant[])eList.toArray(new Elephant[eList.size()]);
        //System.out.println(Arrays.toString(elArr));
        int maxSeqCnt = 0;
        int maxSeqInd = 0;
        for(int i = 0; i < elArr.length; i++){
            for(int j = 0; j < i; j++){
                if(elArr[i].getWeight() >= elArr[j].getWeight() && elArr[i].getIQ() <= elArr[j].getIQ()){
                    if(elArr[i].getSeqCnt() < elArr[j].getSeqCnt()+1){
                        elArr[i].setSeq(elArr[j].getSeq()+"\n"+elArr[i].getIndex(), elArr[j].getSeqCnt()+1);
                    }
                }
            }
            if(elArr[i].getSeqCnt() > maxSeqCnt){
                maxSeqInd = i;
                maxSeqCnt = elArr[i].getSeqCnt();
            }
        }
        System.out.println(maxSeqCnt);
        System.out.println(elArr[maxSeqInd].getSeq());
    }
    
    static class Elephant implements Comparable<Object>{
        private int weight;
        private int iQ;
        private int index;
        private int seqCnt;
        private String seq;

        /**
         * @return the weight
         */
        public int getWeight() {
            return weight;
        }

        /**
         * @param weight the weight to set
         */
        public void setWeight(int weight) {
            this.weight = weight;
        }

        /**
         * @return the iQ
         */
        public int getIQ() {
            return iQ;
        }

        /**
         * @param iQ the iQ to set
         */
        public void setIQ(int iQ) {
            this.iQ = iQ;
        }

        /**
         * @return the index
         */
        public int getIndex() {
            return index;
        }

        /**
         * @param index the index to set
         */
        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * @return the seq
         */
        public String getSeq() {
            return seq;
        }
        
        public int getSeqCnt() {
            return seqCnt;
        }

        
        public void setSeq(String aSeq, int aSeqCnt){
            this.seq = aSeq;
            seqCnt = aSeqCnt;
        }

        @Override
        public int compareTo(Object o) {
            Elephant el = (Elephant)o;
            if(this.getWeight() > el.getWeight()){
                return 1;
            }
            if(this.getWeight() == el.getWeight()){
                return this.getIQ() - el.getIQ();
            }
            return -1;
        }
    }
}
