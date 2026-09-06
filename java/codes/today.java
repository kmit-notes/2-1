// import java.util.*;
// public class today {
//     // List nums=new ArrayList<>()
    
// }
import java.util.*;

class today{
    public static void main(String[] args){
        int target=9;
        List nums=new ArrayList(Arrays.asList(2,7,11,15));
        List result=new ArrayList();
        // for (int i:nums){
        //     int j=i;
        //     for (j:nums){
        //         if (nums[i]+nums[j]==target){
        //             result.add(i);
        //             result.add(j);
        //         }
        //     }
        // }
        System.out.println("nums = "+nums+", target = "+target+" → Output: "+result);
        System.out.println(nums.get(0));
    }
}