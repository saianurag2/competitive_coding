// import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//  * Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class BinTreeLevelOrdTraversal2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> op = new ArrayList<List<Integer>>();
        return op;
    }
    public static void main(String []args){
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String tree = br.readLine();
        // String[] nodesAsString = tree.trim().split(",");
        // int n = nodesAsString.length;
        // ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        // for(int i = 0; i < n; ++i){
        //     input.add(Integer.parseInt(nodesAsString[i]));

        // }
        List<List<Integer>> b = levelOrderBottom(null);
        System.out.println(b);
    }
    
}