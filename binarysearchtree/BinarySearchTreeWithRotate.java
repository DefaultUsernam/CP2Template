// Ulises Cantor
// Period 5
// 12/12/2025
// Menchukov
// Computer Programming 3
// Creates rotation methods for a rotateable binary search tree

package binarysearchtree;

public class BinarySearchTreeWithRotate<E extends Comparable<E>>
    extends BST {

  // rotates the tree such that the subRoot is replaced with it's left child with
  // subRoot becoming the right child of the new subRoot. prev now points to the
  // new subRoot.

  public BinarySearchTreeWithRotate() {
    super();
  }
  /*
   * Algorithm for rotation (toward the right):
   * Save value of root.left (temp = root.left)
   * Set root.left to value of root.left.right
   * Set temp.right to root
   * Set root to temp
   */

  // Precondition: rotate tree exists
  // Postcondition: rotates the tree to the right according to tree rotation
  public void rotateRight(Node subRoot, Node prev) {
    
    Node temp = subRoot.left;
    subRoot.left = temp.right;
    temp.right = subRoot;



    if (prev == null){
      root = temp;
    }
    else if (prev.right == subRoot) {
      prev.right = subRoot.left;
    }
    else if (prev.left == subRoot) {
      prev.right = subRoot.left;
    }
  }

  // rotates the tree such that the subRoot is replaced with it's right child with
  // subRoot becoming the left child of the new subRoot. prev now points to the
  // new subRoot.

  // Precondition: rotate tree exists
  // Postcondition: rotates the tree to the left according to tree rotation
  public void rotateLeft(Node subRoot, Node prev) {
    
    Node temp = subRoot.right;
    subRoot.right = temp.left;
    temp.left = subRoot;



    if (prev == null){
      root = temp;
    }
    else if (prev.right == subRoot) {
      prev.left = subRoot.right;
    }
    else if (prev.left == subRoot) {
      prev.left = subRoot.right;
    }
}
    }