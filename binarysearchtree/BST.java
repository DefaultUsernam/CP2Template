
package binarysearchtree;

import java.util.ArrayList;

public class BST {
  Node root;

  public BST() {
    root = null;
  }

  // Precondition: all numbers are unique
  // Postcondition: key is inserted as a node into the tree following binary
  // search tree logic where left is less and right is greater
  void insert(int key) {
    ArrayList<Node> allNodes = new ArrayList<Node>();
    if (root == null) {
      root = new Node(key);
    } else {
      Node curr = root;
      while (curr != null) {
        allNodes.add(curr);
        if (key < curr.key) {
          if (curr.left == null) {

            curr.left = new Node(key);
            allNodes.add(curr.left);
            break;

          }
          curr = curr.left;
        } else {

          if (curr.right == null) {

            curr.right = new Node(key);
            allNodes.add(curr.right);
            break;
          }
          curr = curr.right;
        }
      }
    }

      for (int i = allNodes.size() - 1; i >= 0; i--) {
        Node node = allNodes.get(i);
        Node parent = null;
        if (i - 1 >= 0) {
          parent = allNodes.get(i - 1);
        }
        int bal = balance(node);
        // Right heavy
        if (bal > 1) {
          // RL
          if (balance(node.right) < 0) {
            rotateRight(node.right, node);
          }
            rotateLeft(node, parent);
          }


        // Left heavy
        else if (bal < -1) {
          // LR
          if (balance(node.left) > 0) {
            printTree();
            rotateLeft(node.left, node);
            printTree();
          }
            rotateRight(node, parent);
          
        }
      }
    }

  

  // Precondition: valid int key
  // Postcondition: removes the node sharing the key, if it exists in the tree,
  // and returns the depth, if the key isn't in the tree, return -1
  int remove(int key) {
    ArrayList<Node> allNodes = new ArrayList<Node>();
      int depth = 0;
    if (!search(key)) {
      return -1;
    } else {
      Node curr = root;
      Node prev = curr;
      boolean isLeft = false;
      while (curr != null && curr.key != key) {
        allNodes.add(curr);
        prev = curr;
        if (key < curr.key) {
          curr = curr.left;
          isLeft = true;
        }
        if (key > curr.key) {
          curr = curr.right;
          isLeft = false;
        }
        depth++;
      }
      allNodes.add(curr);

      // if there are no nodes beneath the node that is to be removed, then just
      // remove it

      if (curr.right == null && curr.left == null) {
        if (curr == root) {
          root = null;
          return depth;
        }
        if (isLeft) {
          prev.left = null;

        } else {
          prev.right = null;

        }

      }

      // two children, copy the key to the current node, then remove the nextR node
      else if (curr.right != null && curr.left != null) {
        Node next = curr;
        Node nextR = curr.right;
        while (nextR.left != null) {
          next = nextR;
          nextR = nextR.left;
        }

        curr.key = nextR.key;

        if (next == curr) {
          next.right = nextR.right;
        } else {
          next.left = nextR.right;
        }

      }

      // if there is just one node that the node we want to remove is connected to,
      // route the previous node to the node that's connected to the node we want to
      // remove
      else {
        Node temp;
        if (curr.left != null) {
          temp = curr.left;

        } else {
          temp = curr.right;
        }

        if (curr == root) {
          root = temp;
        } else if (isLeft) {
          prev.left = temp;
        } else {
          prev.right = temp;
        }

      }
    }

    for (int i = allNodes.size() - 1; i >= 0; i--) {
      Node node = allNodes.get(i);
      Node parent = null;
      if (i - 1 >= 0) {
        parent = allNodes.get(i - 1);
      }
      int bal = balance(node);
      // Right heavy
      if (bal > 1) {
        // RL
        if (balance(node.right) < 0) {
          rotateRight(node.right, node);
        }
        // RR
        if (parent == null) {
          rotateLeft(node, parent);
          root = node.right;
        } else {

          rotateLeft(node, parent);
        }

      }

      // Left heavy
      else if (bal < -1) {
        // LR
        if (balance(node.left) > 0) {
          rotateLeft(node.left, node);
        }

        // LL
        if (parent == null) {
          rotateRight(node, parent);
          root = node.left;
        } else {
          rotateRight(node, parent);
        }
      }
    }

    return depth;

  }

  // Precondition: not really anything
  // Postcondition: returns the elements of the tree in the order from top to
  // bottom left to right, with spaces between rows
  public String toString() {
    if (root == null) {
      return "";
    }
    String retString = "";
    Node[] all = new Node[999999];
    int front = 0;
    int back = 0;

    all[back++] = root;
    while (front < back) {
      int rowSize = back - front;

      for (int i = 0; i < rowSize; i++) {
        Node curr = all[front++];
        retString = retString + curr.key + " ";
        if (curr.left != null) {
          all[back++] = curr.left;
        }
        if (curr.right != null) {
          all[back++] = curr.right;
        }
      }
      retString = retString + System.lineSeparator();
    }
    return retString;
  }

  // Precondition: a key and root are entered into the method
  // Postcondition: returns a boolean based on if the key exists within the root's
  // tree, as a public method
  public boolean search(int key) {
    return find(key, root);
  }

  // Precondition: a key and root are entered into the method
  // Postcondition: returns a boolean based on if the key exists within the root's
  // tree, as a private method
  private boolean find(int key, Node root) {
    if (root == null) {
      return false;
    } else if (root.key == key)
      return true;
    else if (key < root.key)
      return find(key, root.left);
    else
      return find(key, root.right);
  }

  // Add the following functions to your BST
  // Please use this code to verify your tree integrity
  public boolean isBSTOrNot() {
    return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
    // check for root is not null or not
    if (root == null) {
      return true;
    }
    // check for current node value with left node value and right node value and
    // recursively check for left sub tree and right sub tree
    if (root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key)
        && isBSTOrNot(root.right, root.key, maxValue)) {
      return true;
    }
    return false;
  }

  // please use the following pieces of code to display your tree in a more easy
  // to follow style (Note* you'll need to place the Trunk class in it's own file)
  public static void showTrunks(Trunk p) {
    if (p == null) {
      return;
    }

    showTrunks(p.prev);
    System.out.print(p.str);
  }

  public void printTree() {
    printTree(root, null, false);
  }

  private void printTree(Node root, Trunk prev, boolean isLeft) {
    if (root == null) {
      return;
    }

    String prev_str = "    ";
    Trunk trunk = new Trunk(prev, prev_str);

    printTree(root.right, trunk, true);

    if (prev == null) {
      trunk.str = "———";
    } else if (isLeft) {
      trunk.str = ".———";
      prev_str = "   |";
    } else {
      trunk.str = "`———";
      prev.str = prev_str;
    }

    showTrunks(trunk);
    System.out.println(" " + root.key);

    if (prev != null) {
      prev.str = prev_str;
    }
    trunk.str = "   |";

    printTree(root.left, trunk, false);
  }

  // Precondition: receives a node/null node that may be connected to a tree
  // Postcondition: returns the height of the node
  private int height(Node node) {
    if (node == null) {
      return -1;
    } else {
      return 1 + Math.max(height(node.right), height(node.left));
    }
  }

  // Precondition: receives an inputted node/null node
  // Postcondition: returns the balance at the specified node
  private int balance(Node node) {
    if (node == null) {
      return 0;
    } else {
      return height(node.right) - height(node.left);
    }

  }

  // Precondition: rotate tree exists
  // Postcondition: rotates the tree to the right according to tree rotation
  public void rotateRight(Node subRoot, Node prev) {

    Node temp = subRoot.left;
    subRoot.left = temp.right;
    temp.right = subRoot;

    if (prev == null) {
      root = temp;
    } else if (prev.right == subRoot) {
      prev.right = temp;
    } else if (prev.left == subRoot) {
      prev.left = temp;
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

    if (prev == null) {
      root = temp;
    } else if (prev.right == subRoot) {
      prev.right = temp;
    } else if (prev.left == subRoot) {
      prev.left = temp;
    }
  }

  // tests for the methods
  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(10);
    tree.insert(7);
    tree.insert(8);
     tree.insert(5);
     tree.insert(4);
    tree.insert(3);
    tree.insert(9);
     tree.insert(10);
     tree.insert(11);
    tree.insert(12);
    tree.insert(13);
     tree.printTree();
     System.out.println("Removing 7, depth" + tree.remove(7));
     System.out.println("Removing 11, depth" + tree.remove(11));
     System.out.println("Removing 3, depth" + tree.remove(3));

     tree.printTree();

    


  }
}
