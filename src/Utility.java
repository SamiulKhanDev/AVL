public  class Utility
{


    private final void updateHeightAndBalance(TreeNode node)
    {
        int lh = (node.left==null?-1:node.left.height);
        int rh = (node.right==null?-1:node.right.height);

        int myBalance = lh-rh;
        int myHeight = Math.max(lh,rh)+1;

        node.balance = myBalance;
        node.height = myHeight;
    }

    private final TreeNode rightRotation(TreeNode A)
    {
        //this function will rotate ll type structure to right

        TreeNode B = A.left;
        TreeNode bright = B.right;

        B.right = A;
        A.left = bright;
        updateHeightAndBalance(A);
        updateHeightAndBalance(B);
        return B;
    }

    private final TreeNode leftRotation(TreeNode A)
    {
        //this function will rotate rr type structure to left
        TreeNode B = A.right;
        TreeNode bleft = B.left;

        B.left = A;
        A.right = bleft;
        updateHeightAndBalance(A);
        updateHeightAndBalance(B);
        return B;
    }

    private final TreeNode getRotationHelper(TreeNode node)
    {
        updateHeightAndBalance(node);

        if(node.balance==2)//ll,lr
        {
            if(node.left.balance==1)//ll
            {
                return rightRotation(node);
            }
            else if(node.left.balance==-1)//lr
            {
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        else if(node.balance==-2)//rr,rl
        {
            if(node.right.balance==-1)//rr
            {
                return leftRotation(node);
            }
            else if(node.right.balance==1)//rl
            {
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }


        return node;

    }


    public final TreeNode getRotation(TreeNode node)
    {
        return getRotationHelper(node);
    }



}
