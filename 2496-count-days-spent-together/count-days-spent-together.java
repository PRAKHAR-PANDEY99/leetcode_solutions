
import java.util.*;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,0);
        map.put(2,31);
        map.put(3,59);
        map.put(4,90);
        map.put(5,120);
        map.put(6,151);
        map.put(7,181);
        map.put(8,212);
        map.put(9,243);
        map.put(10,273);
        map.put(11,304);
        map.put(12,334);
        int a=map.get(Integer.parseInt(arriveAlice.substring(0,2)))+Integer.parseInt(arriveAlice.substring(3,5));
        int b=map.get(Integer.parseInt(leaveAlice.substring(0,2)))+Integer.parseInt(leaveAlice.substring(3,5));
        int c=map.get(Integer.parseInt(arriveBob.substring(0,2)))+Integer.parseInt(arriveBob.substring(3,5));
        int d=map.get(Integer.parseInt(leaveBob.substring(0,2)))+Integer.parseInt(leaveBob.substring(3,5));
        int start=Math.max(a,c);
        int end=Math.min(b,d);
        if(start>end) return 0;
        return end-start+1;
    }
}
