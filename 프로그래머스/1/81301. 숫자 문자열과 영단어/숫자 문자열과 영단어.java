import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(String s) {
        String sb = "";
        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("zero", 0);
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);
        hashMap.put("five", 5);
        hashMap.put("six", 6);
        hashMap.put("seven", 7);
        hashMap.put("eight", 8);
        hashMap.put("nine", 9);
        
        for (char x : s.toCharArray()) {
            sb += x;

            for (String num : hashMap.keySet()) {
                if (sb.equals(num)) {
                    sb = "";
                    str.append(hashMap.get(num));
                } else if (Character.isDigit(x)) {
                    sb = "";
                    str.append(x);
                    break;
                }
            }
        }
        int answer = 0;
        
        answer = Integer.parseInt(String.valueOf(str));
        return answer;
    }
}