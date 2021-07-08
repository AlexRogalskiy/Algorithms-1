import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    private static FastScanner sc;

    private static class FastScanner {
        private Scanner sc;

        FastScanner() {
            sc = new Scanner(System.in);
        }

        public int ni() {
            return sc.nextInt();
        }

        public String ns() {
            return sc.nextLine();
        }

        public long nl() {
            return sc.nextLong();
        }

        public double nd() {
            return sc.nextDouble();
        }
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static void ln() {
        print("\n");
    }

    private static void printf(String s, Object... data) {
        System.out.printf(s, data);
    }

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }

    // Given a binary tree, populate an array to represent the averages of all of its levels.

    private static void solve() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        println(getAverages(root));
    }

    private static List<Double> getAverages(TreeNode tree) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(tree);

        while (!qu.isEmpty()) {
            int size = qu.size();
            List<Integer> list = new ArrayList<>();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode front = qu.poll();
                sum += front.val;
                if (front.left != null) qu.offer(front.left);
                if (front.right != null) qu.offer(front.right);
            }
            res.add(sum / size);
        }
        return res;
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right; 

        TreeNode(int val) {
            this.val = val;
        }
    }
}