class Solution {
    public String smallestPalindrome(String s) {
        if (s.length() <= 3) return s;
        String zz = "";
        if (s.length() % 2 != 0) {
            zz = String.valueOf(s.charAt(s.length() / 2));
        }
        String s1 = s.substring(0, s.length() / 2);
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        String reversed = new StringBuilder(sorted).reverse().toString();

        if (zz.length() > 0) {
            return sorted + zz + reversed;
        }
        return sorted + reversed;
    }
}