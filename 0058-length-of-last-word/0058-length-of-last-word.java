class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (s.charAt(i) == ' ') i--;

        int count = 0;

        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}