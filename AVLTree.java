package lab1;

public class AVLTree {
		
		private StudentNode root;
		
		public AVLTree () {
			setRoot(null);
		}
		
		public void insert (StudentNode node) {
			
			if (node == null)
				return;
			//making sure both left and right of the node are null
			node.setLeft(null);
			node.setRight(null);
			
			if (root == null)
				root = node;
			else {
				//Start with the root and look for a spot to insert
				//i.e. Traverse the tree and look for the proper spot to insert node
				StudentNode cursor = getRoot ();
				while (true) {
					StudentNode parent = cursor;
					//Question: insert to the left or right?
					if (node.getId() < cursor.getId()) {
						cursor = cursor.getLeft();
						//if the left child has no children, insert!
						if (cursor == null) {
							parent.setLeft(node);
							parent=rebalance(parent);
							return;
						}
					
					}
					else if (node.getId() > cursor.getId()) {
						cursor = cursor.getRight();
						//if the right child has no children, insert
						if (cursor == null) {
							parent.setRight(node);
							parent=rebalance(parent);
							return;
						}
						
					}
					else {
						System.out.println("This student already exists!");
						return;   //the  node is not added if the id already exists
					}
					
				}
			}
		}
		public void printPreOrder () {
			TraversePreOrder (getRoot());
		}
		public void printInOrder () {
			TraverseInOrder (getRoot());
		}
		public void printPostOrder () {
			TraversePostOrder (getRoot());
		}
		
		private void TraversePreOrder (StudentNode cursor) {    //Node, left subtree, right subtree 
			
			if (cursor != null) {
				System.out.println(cursor);
				TraverseInOrder (cursor.getLeft());
				TraverseInOrder (cursor.getRight());	
			}
		}
		
		private void TraverseInOrder (StudentNode cursor) {    //Nodes in ascending order
			
			if (cursor != null) {
				
				TraverseInOrder (cursor.getLeft());
				System.out.println(cursor);
				TraverseInOrder (cursor.getRight());	
			}
		}
		private void TraversePostOrder (StudentNode cursor) {    //Left, right, node		
			if (cursor != null) {
				
				TraverseInOrder (cursor.getLeft());
				TraverseInOrder (cursor.getRight());	
				System.out.println(cursor);
			}
		}
	
		public int getBalance(StudentNode n) {
			if (n != null) {
				return (getHeight(n.getLeft()) - getHeight(n.getRight()));
			}
			return 0;
		}
		
		
		public int getHeight(StudentNode n) {
			if (n != null) {
				return n.getHeight();
			}
			return 0;
		}
		
		
		public StudentNode rightRotate(StudentNode y) {
			StudentNode x = y.getLeft();
			StudentNode T2 = x.getRight();

			// Rotation
			x.setRight(y);
			y.setLeft(T2);

			// update their heights
			x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
			y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

			return x;
		}

		public StudentNode leftRotate(StudentNode x) {
			StudentNode y = x.getRight();
			StudentNode T2 = y.getLeft();

			// Rotation
			y.setLeft(x);
			x.setRight(T2);

			// update their heights
			x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
			y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

			return y;
		}
		
	
		
		private StudentNode rebalance(StudentNode z) {
		z.setHeight(Math.max(getHeight(z.getLeft()), getHeight(z.getRight())) + 1);
			int balance = getBalance(z);
			if (balance > 1) {
				if (z.getRight().getRight().getHeight() > z.getRight().getLeft().getHeight()) {
					z = leftRotate(z);
				} else {
					z.setRight(rightRotate(z.getRight()));
					z = leftRotate(z);
				}
			} else if (balance < -1) {
				if ((z.getLeft().getLeft().getHeight()) > z.getLeft().getRight().getHeight()) {
					z = rightRotate(z);
				} else {
					z.setLeft(leftRotate(z.getLeft()));
					z = rightRotate(z);
				}
			}
			return z;
		}
		
		public StudentNode getRoot() {
			return root;
		}

		public void setRoot(StudentNode root) {
			this.root = root;
		}
		
		
		public void inorder(StudentNode root) {
			if (root != null) {
				inorder(root.getLeft());
				System.out.print(" " + root.getId());
				inorder(root.getRight());
			}
		}

		
		
	
	}

	




