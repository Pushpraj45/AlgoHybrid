public class Compare {
    public static void main(String[] args){
        String s1 = "Tony";
        String s2 = "Tony";

        String s3 = new String("Tony");

        if (s1==s2){  // ye keval object level par dekhta hai same hai ki nahi
            System.out.print("Strings are equal ");
        }
        else{
            System.out.print("Strings are not equal ");
        }
          if (s1==s3){  // Due to interning concept
            System.out.print("Strings are equal ");
        }
        else{
            System.out.print("Strings are not equal ");
        }

        if (s1.equals(s3)){ // this we have to write at time of checking
            System.out.println("Strings are equal ");
        }
        else{
            System.out.println("Not Equals ");
        }


    }
}
