import java.util.*;
class checkBST{
static ArrayList<Integer> ar = new ArrayList<Integer>();
    public static void inOrder(Node root) {
            if (root == null) return;
            inOrder(root.left);
            ar.add(root.data);
            inOrder(root.right);
    }
    boolean checkBST(Node root) {
            inOrder(root);
            
            for(int i = 0;i<ar.size()-1;i++){
                if(ar.get(i)>=ar.get(i+1)){
                    return false;
                }
            }
        return true;
    }
}
