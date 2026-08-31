class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        ArrayList<Integer> unique = new ArrayList<>(map.keySet());
        Collections.sort(unique);
        for (int start : unique) {
            if (map.get(start) == 0) continue;

            int freq = map.get(start);

            for (int j = 0; j < groupSize; j++) {
                int card = start + j;

                if (!map.containsKey(card) || map.get(card) < freq) {
                    return false;
                }

                map.put(card, map.get(card) - freq);
            }
        }

        return true;
    }
}