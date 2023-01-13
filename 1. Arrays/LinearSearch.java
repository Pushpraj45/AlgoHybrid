public class LinearSearch {
    public static void main(String[] args){
        int nums[] = {2,4,6,8,10};
        int key = 10;
        System.out.println(linearSearch(nums,key));
    }

    public static int linearSearch(int nums[], int key){
        for (int i=0; i<nums.length; i++){
            if (nums[i]==key){
                return i;
            }
        }
        return -1;
    }
}
