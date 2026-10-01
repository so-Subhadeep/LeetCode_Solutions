class Solution {
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while(s.charAt(i)==' ') i--;
        int cnt=0;
        for(int j=i;j>=0;j--){
            if(s.charAt(j)==' ') break;
            cnt++;
        }
        return cnt;
    }
}