class Solution {
    class Pair {
        char task;
        int freq;

        Pair(char task, int freq) {
            this.task = task;
            this.freq = freq;
        }
    }

    class Cooldown {
        char task;
        int freq;
        int time;

        Cooldown(char task, int freq, int time) {
            this.task = task;
            this.freq = freq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(new Pair((char)('A' + i), count[i]));
            }
        }
        Queue<Cooldown> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;

            if (!q.isEmpty() && q.peek().time <= time) {
                Cooldown curr = q.poll();
                pq.add(new Pair(curr.task, curr.freq));
            }


            if (!pq.isEmpty()) {

                Pair curr = pq.poll();

                curr.freq--;
                if (curr.freq > 0) {
                    q.add(new Cooldown(
                        curr.task,
                        curr.freq,
                        time + n + 1
                    ));
                }

            }
        }

        return time;
    }
}