import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            hashMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            Integer index = hashMap.get(callings[i]);
            hashMap.put(callings[i], index - 1);

            String tmp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = tmp;

            hashMap.put(players[index], index);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            resultList.add(entry.getKey());
        }

        return resultList.toArray(new String[0]);
    }
}
