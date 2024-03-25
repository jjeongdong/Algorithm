import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Character[] strings = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        for (Character string : strings) {
            hashMap.put(string, 0);
        }


        for (int i = 0; i < survey.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);

            if (choices[i] == 1) {
                hashMap.put(c1, hashMap.getOrDefault(c1, 0) + 3);
            } else if (choices[i] == 2) {
                hashMap.put(c1, hashMap.getOrDefault(c1, 0) + 2);
            } else if (choices[i] == 3) {
                hashMap.put(c1, hashMap.getOrDefault(c1, 0) + 1);
            } else if (choices[i] == 5) {
                hashMap.put(c2, hashMap.getOrDefault(c2, 0) + 1);
            } else if (choices[i] == 6) {
                hashMap.put(c2, hashMap.getOrDefault(c2, 0) + 2);
            } else if (choices[i] == 7) {
                hashMap.put(c2, hashMap.getOrDefault(c2, 0) + 3);
            }
        }

        System.out.println(hashMap);

        if (hashMap.get('R') >= hashMap.get('T')) sb.append('R');
        else sb.append('T');

        if (hashMap.get('C') >= hashMap.get('F')) sb.append('C');
        else sb.append('F');

        if (hashMap.get('J') >= hashMap.get('M')) sb.append('J');
        else sb.append('M');

        if (hashMap.get('A') >= hashMap.get('N')) sb.append('A');
        else sb.append('N');

        return sb.toString();
    }
}