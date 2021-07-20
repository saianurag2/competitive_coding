package sep20;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;

class LC01 {
    static ArrayList<int[]> permutation = new ArrayList<int[]>();
    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        if(A[0] > 2) return "";
        if(A[1] > 5) return "";
        heapPermutation(A, 4, 4);
        // int[] temp = new int[4];
        int[] maxArr = new int[4];
        int max = 0;
        boolean sol = false;

        for(int[] seq : permutation){
            if(validTime(seq)){
                sol = true;
                if(max < timeToInt(seq)){
                    maxArr = seq;
                    max = timeToInt(seq);
                }
            }
        }
        if(sol){
            StringBuilder sb = new StringBuilder();
            sb.append(maxArr[0]);
            sb.append(maxArr[1]);
            sb.append(":");
            sb.append(maxArr[2]);
            sb.append(maxArr[3]);
            return sb.toString(); 
        }
        return "";
    }

    public static int timeToInt(int[] A){
        return 1000*A[0] + 100*A[1] + 10*A[2] + A[3];
    }

    public static boolean validTime(int[] A){
        boolean flag = false;
        if(A[2] < 6){
            if(A[0] < 3){
                if(A[0] == 2){
                    if(A[1] < 4)
                        flag = true;
                }
                else
                    flag = true;
            }
        }
        return flag;
    }

    //Generating permutation using Heap Algorithm 
    static void heapPermutation(int a[], int size, int n) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) 
            permutation.add(a.clone()); 
    
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(a, size-1, n); 
    
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                int temp = a[0]; 
                a[0] = a[size-1]; 
                a[size-1] = temp; 
            } 
    
            // If size is even, swap ith and last 
            // element 
            else
            { 
                int temp = a[i]; 
                a[i] = a[size-1]; 
                a[size-1] = temp; 
            } 
        } 
    }

    public static void main(String[] args){
        int[] ip = {1,2,3,4};
        String res = largestTimeFromDigits(ip);
        System.out.println(res);
    }
}


// import itertools
// print(list(itertools.permutations([1,2,3])))
