
public class AVL<T>
{
	private AVLNode<T> root;
	private int height;

	public AVL(AVLNode<T> root)
	{
		this.root = root;
	}
	public AVLNode turnRight(AVLNode node1)
	{ //Right rotation
		AVLNode node2 = node1.getLeftChild();
		AVLNode node3 = node2.getRightChild();
		node2.setRightChild(node1);//rotation
		node1.setLeftChild(node3);//rotation
		node1.updateHeight(1 + Math.max(height(node1.getLeftChild()),height(node1.getRightChild())));
		node2.updateHeight(1 + Math.max(height(node2.getLeftChild()),height(node2.getRightChild())));
		return node2;
	}
	public AVLNode turnLeft(AVLNode node2)
	{
		AVLNode node1 = node2.getRightChild();
		AVLNode node3 = node1.getLeftChild();
		node1.setLeftChild(node2);//rotation
		node2.setRightChild(node3);//rotation
		node2.updateHeight(1 + Math.max(height(node2.getLeftChild()),height(node2.getRightChild())));//update height
		node1.updateHeight(1 + Math.max(height(node1.getLeftChild()),height(node1.getRightChild())));//update height
		return node1;
	}


		public void insert(int key, T data)
		{

			AVLNode current = root;


			while (current.getKey() != key)
			{
				if (current.getKey() < key) {
					if (current.getRightChild() == null) {
						AVLNode leaf = new AVLNode(key, data, null, null, current);
						current.setRightChild(leaf);
					} else {   //if (current.getRightChild() != null)  ###
						current = current.getRightChild();
					}
				} else {    // if current.getKey > key ###
					if (current.getLeftChild() == null) {
						AVLNode leaf = new AVLNode(key, data, null, null, current);
						current.setLeftChild(leaf);

					} else { //if (current.getLeftChild != null)
						current = current.getLeftChild();
					}
				}

			}
			current.updateHeight(1 + Math.max(height(current.getLeftChild()), height(current.getRightChild())));
			int balance = getBalance(current);
			//Left Left Case
			if (balance > 1 && key < current.getLeftChild().getKey())
				current=turnRight(current);

			// Right Right Case
			if (balance < -1 && key > current.getRightChild().getKey())
				current=turnLeft(current);

			// Left Right Case
			if (balance > 1 && key > current.getLeftChild().getKey()) {
				current.setLeftChild(turnLeft(current.getLeftChild()));
				current=turnRight(current);
			}

			// Right Left Case
			if (balance < -1 && key <current.getRightChild().getKey())
			{
				current.setRightChild(turnRight(current.getRightChild()));
				current=turnLeft(current);
			}
		}


			public boolean search(int key)
			{
				AVLNode current = root;
				while (current != null)
				{
					if (current.getKey() == key)
					{
						return true;
					}
					if (current.getKey() > key)
					{
						current = current.getLeftChild();
					}
					else
					{
						current = current.getRightChild();
					}
				}
				return false;
			}

			public AVLNode<T> getRoot()
			{
				return root;
			}

	public int height(AVLNode node)
	{
		if (node == null)
			return 0;
		return node.getHeight();
	}

	public int getBalance(AVLNode N)
	{
		if (N == null)
			return 0;

		return height(N.getLeftChild()) - height(N.getRightChild());
	}
}
