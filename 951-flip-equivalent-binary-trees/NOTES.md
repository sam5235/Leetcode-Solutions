public boolean flipEquiv(TreeNode root1, TreeNode root2) {
if(root1 == null && root2 == null) return true;
if(root1 != null && root2 != null && root1.val != root2.val) return false;
if(root1 != null && root1.left != null && root1.right != null){
if(  root2 != null && root2.left == null || root2.right == null) return false;
if( root2 != null && root1.left.val == root2.left.val && root1.right.val == root2.right.val){
return  flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
}
if( root2 != null && root1.left.val == root2.right.val && root1.right.val == root2.left.val){
TreeNode temp = root1.right;
root1.right= root1.left;
root1.left = temp;
return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
}
}
else if(root1 != null && root1.left != null){
if( root2 != null && root2.right == null && root2.left != null && root1.left.val == root2.left.val){
return flipEquiv(root1.left, root2.left);
}
if( root2 != null && root2.left == null && root2.right != null && root1.left.val == root2.right.val){
root1.right = root1.left;
root1.left = null;
return flipEquiv(root1.right, root2.right);
}
}
else if(root1 != null && root1.right != null){
if( root2 != null && root2.left == null && root2.right != null && root1.right.val == root2.right.val){
return flipEquiv(root1.right, root2.right);
}
if( root2 != null && root2.right == null && root2.left != null && root1.right.val == root2.left.val){
root1.left = root1.right;
root1.right = null;
return flipEquiv(root1.left, root2.left);
}
}
if(root1 != null && root2 != null && root1.left == null && root1.right == null &&   root2.left == null && root2.right == null) return true;
return false;
}