import java.util.ArrayList;
import java.util.List;

class ListAllSubsets {
    // public int power(int b , int e){
    //     if(b==1)
    //         return 1;
    //     else if(e == 0 && b!=0)
    //         return 1;
    //     else{
    //         int res = 1;
    //         while(e>0){
    //             res = res*b;
    //             --e;
    //         }
    //         return res;
    //     }
    // }
    public int power(int e){
        int res = 1;
        while(e>0){
            res*=2;
            --e;
        }
        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int subsetLen = this.power(len);
        List<List<Integer>>subsets = new ArrayList<List<Integer>>(subsetLen);
        for(int i = 0; i <len; ++i){
            int den = this.power(i+1);
            int interval = subsetLen/den;
            int start = 0;
            for(; start<subsetLen;){
                if((start/interval)%2 == 0)
                    for(int j= 0; j<interval;j++){
                        if(start+j >= subsets.size())
                            subsets.add(start+j, new ArrayList<Integer>());
                        subsets.get(start+j).add(nums[i]);
                    }
                start+=interval;
            } 
        }
        subsets.add(new ArrayList<Integer>());
        return subsets;
    }
}