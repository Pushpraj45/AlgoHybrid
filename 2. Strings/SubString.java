public class SubString {
    public static void main(String[] args){
        String str = "helloWorld";
        System.out.println(Substring(str,2,4));
//        Inbuilt function
        System.out.println(str.substring(0,5));
    }

    public static String Substring(String str, int si, int ei){
        String substr = "";
        for (int i=si; i<ei; i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
}
