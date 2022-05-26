package wyx;

public class moveZeroes {

    public void moveZeroes1(int[] nums) {
        boolean flag = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0 ) {
                flag = true;
                for(int j=i+1;flag && j<nums.length;j++) {
                    if(nums[j]!=0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        flag = false;
                    }
                }
            } 
        }
    }

}