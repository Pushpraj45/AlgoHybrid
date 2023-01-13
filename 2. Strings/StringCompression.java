public class StringCompression {
    public static void main(String[] args){
        //    StringBuilder
    StringBuilder sb = new StringBuilder("");
    for (char ch='a'; ch<='z'; ch++){
        sb.append(ch);
//        abcedf...z
    }  // O(26)
        System.out.println(sb);

    String newStr="aaabbbxxccc";
        System.out.println(compress(newStr));

    }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<str.length(); i++){
            Integer count = 1; // so that we can add this in our string
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;  // n operations due to this i
            }
            sb.append(str.charAt(i)); // last character ko bhi add karna tha bro
            if (count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

}
