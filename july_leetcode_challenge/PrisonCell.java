import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrisonCell {

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int prev, i;
        List<int[]> states = new ArrayList<int[]>();
        int[] updateCell = new int[8];
        for(i = 1; i <=N; ++i){
            if(containsState(states,cells)){
                break;
            }else{
                // System.out.print("Day: "+i);
                // System.out.println(Arrays.toString(cells));
                states.add(cells);
                for (int j = 1; j < 7; ++j) {
                    if(cells[j-1] == cells[j+1]) {
                        updateCell[j] = 1;
                    }else{
                        updateCell[j] = 0;
                    }
                }
                cells = updateCell.clone();
            }
        }
        if(i == N){
            return states.get(N-1);
        }
        else{
        int len = states.size();
        // int loopStart = states.indexOf(cells);
        // System.out.println("Start of loop: "+loopStart);
        int pending = N-i+1;
        int offset = pending%len;
        // System.out.println("len: "+len+" lS: "+loopStart+" pending: "+ pending+ " lsize: "+loopSize+" offset: "+offset);
        // System.out.println(pending);
        return states.get(offset);
        }
    }

    private static boolean containsState(List<int[]> states, int[] cells) {
        int size = states.size();
        for(int i = 0; i < size; ++i){
            if(Arrays.equals(states.get(i),cells))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};
        int N = 7;
        int[] ans = prisonAfterNDays(cells, N);
        System.out.println("Ans: "+Arrays.toString(ans));
    }
}