import java.lang.Math;

// https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
public class ArrangingCoinsV2{
    public static int arrangeCoins(int n) {
        double x = (Math.sqrt((8*(long)n)+1)-1)/2;
        System.out.println(x);
        int y = (int)x ;
        System.out.println(y);
        return y;
    }
    public static void main(String []args){
        ArrangingCoinsV2.arrangeCoins(1804289383);
        System.out.println(Integer.MAX_VALUE);
    }

}