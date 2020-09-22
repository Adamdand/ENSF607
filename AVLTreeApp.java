package lab1;

public class AVLTreeApp {
	
		public static void main (String [] args) {
			
			System.out.println("AVLTree App");
			
			AVLTree AVLTree = new AVLTree();
			
			AVLTree.insert(new StudentNode ("Sarah", 10));
			AVLTree.insert(new StudentNode ("Bob", 20));
			AVLTree.insert(new StudentNode ("Sam", 30));
			AVLTree.insert(new StudentNode ("Joe", 40));
			
			AVLTree.insert(new StudentNode ("a", 50));
			AVLTree.insert(new StudentNode ("b", 25));
//			AVLTree.insert(new StudentNode ("c", 4));
//			AVLTree.insert(new StudentNode ("d", 3));
//			AVLTree.insert(new StudentNode ("e", 2));
//			AVLTree.insert(new StudentNode ("f", 1));
//			AVLTree.insert(new StudentNode ("f", 0));
//			
			AVLTree.printPreOrder();
			
			System.out.print("\n New Root of AVL Tree is : " + AVLTree.getRoot());
		
			
		}

	}



