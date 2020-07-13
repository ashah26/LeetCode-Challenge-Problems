package July_Challenge_Problems.July_9;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val = val;

    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;
        int max = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);

            for(int i=0; i<size; i++){
                root = queue.poll();

                if (root.left != null){
                    root.left.val = root.val * 2;
                    queue.add(root.left);
                }
                if(root.right != null){
                    root.right.val = root.val * 2 + 1;
                    queue.add(root.right);

                }
            }
        }
        return max;
    }
}
