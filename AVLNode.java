public class AVLNode<T> {
	private int key;
	private T data;
	private int height;
	private AVLNode<T> leftChild;
	private AVLNode<T> rightChild;
	private AVLNode<T> father;

	public AVLNode(int key, T data, AVLNode<T> leftChild, AVLNode<T> rightChild, AVLNode<T> father){
		this.key = key;
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.father = father;
		this.height = 1;
	}

	public AVLNode<T> getLeftChild(){
		return leftChild;
	}

	public AVLNode<T> getRightChild(){
		return rightChild;
	}

	public AVLNode<T> getFather(){
		return father;
	}

	public int getKey(){
		return key;
	}

	public T getData(){
		return data;
	}

	public int getHeight()
	{
		return height;
	}

	public void setRightChild(AVLNode<T> child) {
		this.rightChild = child;
	}

	public void setLeftChild(AVLNode<T> child) {
		this.leftChild = child;

	}

	public void updateHeight(int x)
	{
		height+=x;
	}

	public String toString() {

		String s = "";

		if (getLeftChild() != null){
			s+="(";
			s+=getLeftChild().toString();
			s+=")";
		}
		s+=getKey();

		if (getRightChild() != null){
			s+="(";
			s+=getRightChild().toString();
			s+=")";
		}

		return s;
	}
}
