package july_leetcode_challenge;
public class ArrangingCoinsV1{
    public static int arrangeCoins(int n) {
        if(n==0)
            return 0;
        long N = n;
        long sum;
        for(int i = n;i>0;i--){
            // System.out.println(i);
            sum = firstXNumberSum(i);
            if(N < sum & N >=sum-i)
                return i-1;
            else if(N>=sum)
                return i;
        }
        return -1;
    }
    public static long firstXNumberSum(long x){
        return (x*(x+1))/2;    
    }
    public static void main(String []arg){
        System.out.println(arrangeCoins(1804289383));
    }
}