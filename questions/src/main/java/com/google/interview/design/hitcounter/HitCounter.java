package com.google.interview.design.hitcounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HitCounter {
	Map<Integer,Integer> map;
    int hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap();
        hits = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits++;
        if(map.containsKey(timestamp)){
            map.put(timestamp,map.get(timestamp)+1);
        } else {
            map.put(timestamp,1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            if(key<=timestamp-300){
                hits -= map.get(key);
                iterator.remove();
            }
        }
        return hits;
    }
    /**
     * Your HitCounter object will be instantiated and called as such:
     * HitCounter obj = new HitCounter();
     * obj.hit(timestamp);
     * int param_2 = obj.getHits(timestamp);
     */
}
