import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedule {
    public static int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        Integer[] index = new Integer[len];
        int[] diff = new int[len];
        for(int i =0; i<len; i++){
            index[i]= i;
            diff[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(index, new Comparator<Integer> () {// indexes of array before sorting stored;
            public int compare (Integer a, Integer b) {
                return Integer.compare(diff[b],diff[a]);
            }
        });
        int minSum = 0;
        int halfPoint = len/2;
        for(int j = 0; j<len; j++){
            if(j < halfPoint)
                minSum = minSum + costs[index[j]][1];
            else
                minSum = minSum + costs[index[j]][0];
        }
        return minSum;
    }

    public static void main(String[] args){
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        int op = twoCitySchedCost(costs);
        System.out.println(op);
    }
}