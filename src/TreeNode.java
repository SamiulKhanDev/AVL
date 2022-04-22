
public class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    int height;
    int balance;
    TreeNode(int data)
    {
        this.data = data;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append((this.left!=null?this.left.data:".")+" <- "+this.data+" -> "+(this.right!=null?this.right.data:"."));
        return sb.toString();
    }
}
