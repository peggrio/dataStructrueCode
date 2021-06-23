import java.util.Scanner;
import java.util.Stack;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode parent;
    TreeNode left;
    TreeNode right;


static void create(TreeNode parent, int data) {
    if (parent == null) {
        parent = new TreeNode();
        parent.val = data;
        return;
    } else {

        if (data < parent.val) {
            if (parent.left == null) {
                parent.left = new TreeNode();
                parent.left.val = data;
                parent.left.parent = parent;
            } else {
                create(parent.left, data);
            }
        } else if (data >= parent.val) {
            if (parent.right == null) {
                parent.right = new TreeNode();
                parent.right.val = data;
                parent.right.parent = parent;
            } else {
                create(parent.right, data);
            }
        }
    }
}

    //前序、中序、后序遍历二叉树
static void pre(TreeNode T){//前序
    if(T!=null){
        System.out.print(T.val+" ");
        pre(T.left);
        pre(T.right);
    }
}
static void in(TreeNode T){//中序
    if(T!=null){
        in(T.left);
        System.out.print(T.val+" ");
        in(T.right);
    }
}
static void rear(TreeNode T){//后序
    if(T!=null) {
        rear(T.left);
        rear(T.right);
        System.out.print(T.val + " ");
    }
}
//查找
static void search(TreeNode T,int aim){

    if(T==null){
        System.out.println("0"); //没找到
    }else if(T.val==aim){
        System.out.println("1");//找到了
    }else if(T.val<aim){
        search(T.right,aim);//小了，往右边找
    }else if(T.val>aim){
        search(T.left,aim);//大了，往左边找
    }
}

//中序遍历序列(非递归算法)
static void feidiguiIn(TreeNode T){
    Stack<TreeNode> stack=new Stack<>();
    while(T!=null||!stack.isEmpty()){
        while(T!=null){
            stack.push(T);
            T=T.left;
        }
        if(!stack.isEmpty()){
            T=stack.pop();
            System.out.print(T.val+" ");
            T=T.right;//这一步很关键
        }
    }
}

//层次遍历
static void layerTraverse(TreeNode T){
    if(T==null){
        return;
    }
    int depth=depth(T);
    for (int i = 1; i <= depth; i++) {
        levelOrder(T, i);
    }
}

    static void levelOrder(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.val + " ");
            return;
        }

        // 左子树
        levelOrder(Node.left, level - 1);
        // 右子树
        levelOrder(Node.right, level - 1);
    }
    //二叉树深度
static int depth(TreeNode Node) {
    if (Node == null) {
        return 0;
    }

    int l = depth(Node.left);
    int r = depth(Node.right);
    if (l > r) {
        return l + 1;
    } else {
        return r + 1;
    }
}
//交换各结点的左右子树
static TreeNode swap(TreeNode T){
// 先序遍历--从顶向下交换
        if (T == null) return null;
        // 保存右子树
        TreeNode rightTree = T.right;
        // 交换左右子树的位置
        T.right = swap(T.left);
        T.left = swap(rightTree);
        return T;
    }

    //统计叶子节点数
static int countleaf(TreeNode T){
    if(T==null){
        return 0;
    }else{
        if(T.left==null&&T.right==null){//T就是叶子节点
            return 1;
        }else{
           return  countleaf(T.left)+countleaf(T.right);
        }
    }
}


    public static void main(String[] args) {//函数主入口
        TreeNode T=new TreeNode();
        Scanner input=new Scanner(System.in);
        int nodeNumber=input.nextInt();//节点数

        for(int i=0;i<nodeNumber;i++) {//建树
            create(T,input.nextInt());
        }

        //前序、中序、后序遍历二叉树
        T=T.right;
        pre(T);
        System.out.println();
        in(T);
        System.out.println();
        rear(T);
        System.out.println();

        //查找关键字
        search(T,input.nextInt());
        search(T,input.nextInt());

        //插入节点
        create(T,input.nextInt());
        //前序、中序、后序遍历二叉树
        pre(T);
        System.out.println();
        in(T);
        System.out.println();
        rear(T);
        System.out.println();

        //插入新结点后的二叉树的中序遍历序列(非递归算法)
        feidiguiIn(T);
        System.out.println();

        //插入新结点后的二叉树的层次遍历序列
        layerTraverse(T);
        System.out.println();

        //第一次交换各结点的左右子树后的先、中、后序遍历序列
        TreeNode T1=swap(T);
        T.pre(T1);
        System.out.println();
        in(T1);
        System.out.println();
        rear(T1);
        System.out.println();

        //第二次交换各结点的左右子树后的先、中、后序遍历序列
        TreeNode T2=swap(T1);
        T.pre(T2);
        System.out.println();
        in(T2);
        System.out.println();
        rear(T2);
        System.out.println();

        //二叉树深度
        System.out.println(depth(T));

        //叶子结点数
        System.out.println(countleaf(T));
    }
}


