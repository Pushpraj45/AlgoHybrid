public class LargestOddnum {
    public static String largestOddNumber(String num){
        StringBuilder sb=new StringBuilder();
        int max=num.charAt(0);
        for(int i=0; i<num.length(); i++){
            if (num.charAt(i)%2!=0){
                sb.append(num.charAt(i));
            }

        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(largestOddNumber("45"));
    }
}
