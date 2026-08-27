class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = target.toCharArray();

        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            if (freq[cur] > 0) {
                freq[cur]--;
                continue;
            }

            for (int k = cur + 1; k < 26; k++) {
                if (freq[k] > 0) {
                    ans[i] = (char) ('a' + k);
                    freq[k]--;

                    int pos = i + 1;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[pos++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }

                    return new String(ans);
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                int old = target.charAt(j) - 'a';
                freq[old]++;

                for (int k = old + 1; k < 26; k++) {
                    if (freq[k] > 0) {
                        ans[j] = (char) ('a' + k);
                        freq[k]--;

                        int pos = j + 1;

                        for (int c = 0; c < 26; c++) {
                            while (freq[c] > 0) {
                                ans[pos++] = (char) ('a' + c);
                                freq[c]--;
                            }
                        }

                        return new String(ans);
                    }
                }
            }

            return "";
        }

        for (int j = n - 1; j >= 0; j--) {
            int old = target.charAt(j) - 'a';
            freq[old]++;

            for (int k = old + 1; k < 26; k++) {
                if (freq[k] > 0) {
                    ans[j] = (char) ('a' + k);
                    freq[k]--;

                    int pos = j + 1;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            ans[pos++] = (char) ('a' + c);
                            freq[c]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}