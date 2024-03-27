import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] split = s.split(" ");
        List<Integer> list = new ArrayList<>();

        for (String str :
                split) {
            list.add(Integer.parseInt(str));
        }

        list.sort(Integer::compareTo);
        
        return list.get(0) + " " + list.get(list.size() - 1);
        
    }
}