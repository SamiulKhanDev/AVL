import java.util.Scanner;

public class AvlTree
{
    private static Utility util;
    public static void main(String[] args)
    {
        TreeNode root = null;
        util = new Utility();
        Scanner scan = new Scanner(System.in);
        //unique value;
        int iteration = 100;
        while(iteration-->0)
        {
            int data = scan.nextInt();
            root = add(root,data);
            display(root);
            while (scan.nextInt()==1)
            {
                int d = scan.nextInt();
                root = deleteNode(root,d);
                display(root);

            }
        }


    }

    private static final TreeNode add(TreeNode root,int val)
    {
        if(root==null)
        {
            TreeNode nn = new TreeNode(val);
            return nn;
        }

        if(root.data>val)
        {
            root.left = add(root.left,val);
        }
        else
        {
            root.right = add(root.right,val);
        }
        return util.getRotation(root);
    }

    private static TreeNode deleteNode(TreeNode node,int val)
    {
        if (node==null) return null;

        if(node.data==val)
        {
            if(node.left!=null && node.right!=null)
            {
                int max = getMax(node.left);
                node.data = max;

                node.left = deleteNode(node.left,max);
            }
            else if(node.left==null)
            {
                return node.right;
            }
            else if(node.right==null)
            {
                return node.left;
            }
            else
            {
                return null;
            }
        }
        else if(node.data>val)
        {
            node.left = deleteNode(node.left,val);
        }
        else
        {
            node.right = deleteNode(node.right,val);
        }
        return util.getRotation(node);

    }

    private static int getMax(TreeNode node)
    {
        if(node==null) return Integer.MIN_VALUE;
        int left = getMax(node.right);
        return Math.max(left,node.data);
    }

    private static void display(TreeNode root)
    {
        if (root==null) return;

        System.out.println(root);
        display(root.left);
        display(root.right);
    }



}
