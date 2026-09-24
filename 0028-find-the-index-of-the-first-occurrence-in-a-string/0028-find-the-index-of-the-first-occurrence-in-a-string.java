class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int[] lps = new int[needle.length()];
        int j = 0;

        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = lps[j - 1];
            }

            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int i = 0;
        j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }
}