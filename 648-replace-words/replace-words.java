class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        HashSet<String> set = new HashSet<>();

        for (String s : dictionary) {
            set.add(s);
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder ss = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {

            char ch = sentence.charAt(i);

            if (ch != ' ') {

                ss.append(ch);

                if (set.contains(ss.toString())) {
                    ans.append(ss);
                    
                    while (i + 1 < sentence.length() && sentence.charAt(i + 1) != ' ') {
                        i++;
                    }
                }

            } else {

                if (!set.contains(ss.toString())) {
                    ans.append(ss);
                }

                ans.append(' ');
                ss.setLength(0);
            }
        }

        if (ss.length() > 0 && !set.contains(ss.toString())) {
            ans.append(ss);
        }

        return ans.toString();
    }
}