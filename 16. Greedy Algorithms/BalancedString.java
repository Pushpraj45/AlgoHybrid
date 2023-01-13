public class BalancedString {
    public int balancedStringSplit(String str) {
        if(str.length()==0){
            return 0;
        }
        int r=0, l=0;
        int ans=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='R'){
                r++;
            }
            else if(str.charAt(i)=='L'){
                l++;
            }
            if(r==l){
                ans++;
            }
        }
        return ans;
    }
    // can call this function from main function

}
