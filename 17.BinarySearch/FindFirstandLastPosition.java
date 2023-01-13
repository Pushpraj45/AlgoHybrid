//package BinarySearch;

public class FindFirstandLastPosition {
    public int[] searchRange(int[] nums, int target) {

        int[] ans={-1,-1};
        int start=search(nums, target, true);
        int end=search(nums, target, false);

        ans[0]=start;
        ans[1]=start;

        return ans;

    }

//    this function just returns the index value of target
    int search(int[] nums, int target, boolean findstartindex){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
//        int[] ans={-1,-1};

        while (start<=end){
//            find the middle element
            int mid=start+(end-start)/2;
            if (target<nums[mid]){
                end=mid-1;
            }
            else if (target>nums[mid]){
                start=mid+1;
            }
            else{
//                potential ans found
                ans = mid;
                if (findstartindex){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }

            }
        }
        return ans;
    }
        public static void main(String[] args){

        }
    
}
