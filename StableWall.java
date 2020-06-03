import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
// Problem Link
// Google Kickstart Round C 2020
// https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003379bb
public class StableWall
{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static String buildOrder(char[][] wall){
        int row = wall.length-1;
        int col = wall[0].length-1;
        Map<Character,ArrayList<Character>> parent = new HashMap<Character,ArrayList<Character>>();
        for(int i = row;i>-1;i--){
            for(int j = col; j>-1;j--){
                if(i < row){
                    if(wall[i][j] == wall[i+1][j]){
                        continue;
                    }
                    if(parent.containsKey(wall[i][j])){
                        if(!parent.get(wall[i][j]).contains(wall[i+1][j])){
                            parent.get(wall[i][j]).add(wall[i+1][j]);
                        }
                    }else{
                            ArrayList<Character> pl = new ArrayList<Character>();
                            pl.add(wall[i+1][j]);
                            parent.put(wall[i][j], pl);
                        }
                    
                }else if(!parent.containsKey(wall[i][j])){
                   parent.put(wall[i][j],new ArrayList<Character>()); 
                }
            }
        }
        //debug
        int loops = parent.size();
        // Iterator<Character> it = parent.keySet().iterator();
        // while(it.hasNext()){
        //     char curr = it.next();
        //     System.out.println("Parent of "+curr+": "+parent.get(curr)); 
        // }
        //end
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> visited = new ArrayList<Character>();
        Iterator<Character> iter;
        for(int count = 0; count < loops;count++){
            if(parent.isEmpty())
                break;
            iter = parent.keySet().iterator();
            while(iter.hasNext()){
                char c = iter.next();
                if(parent.get(c).isEmpty()){
                    Iterator<ArrayList<Character>> iterVal = parent.values().iterator();
                    ArrayList<Character> val;
                    while(iterVal.hasNext()){
                         val = iterVal.next();
                        if(val.contains(c))
                            val.remove(Character.valueOf(c));
                    }
                    visited.add(c);
                    sb.append(c);
                    iter.remove();
                }
            }
        }
        for(ArrayList<Character> rem : parent.values()){
            if(rem.size() > 0)
                return "-1"; 
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        FastReader s=new FastReader();
        int testCases = s.nextInt();
        int t = 1;
        while(t<=testCases){
            int row = s.nextInt();
            int col = s.nextInt();
            char[][] wall = new char[row][col];
            for(int r = 0;r < row;r++){
                wall[r] = s.nextLine().toCharArray();
            }
            // code begins here
            String rcv = buildOrder(wall);
            System.out.println("Case #"+t+": "+rcv);
            t++;
        }
    }
}
