import java.util.ArrayList;



public class StudentSolution implements MyInterface
{
    public HashTable table = new HashTable();
    public AVL<Integer> xTree = new AVL<>();
    public AVL<Integer>  yTree = new AVL<>();

    public void insertDataFromDBFile(String objectName, int objectX, int objectY){

        xTree.insert(objectX, objectY);
        yTree.insert(objectY, objectX);
        ObjectWithCoordinates obj = new Point(objectX, objectY, objectName);
        table.insert(obj);

    }


    @Override
    public String[] secondSolution(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {
        String[] names1 = new String[10];
        int i = 0;
        ObjectWithCoordinates obj;
        ArrayList<AVLNode<Integer>> listX = new ArrayList<>();
        ArrayList<AVLNode<Integer>> listY = new ArrayList<>();
        AVL<Integer>  bigTree = new AVL<>();
        listX = coordSearch(xTree.getRoot(), leftTopX, rightBottomX, listX);
        listY = coordSearch(yTree.getRoot(), leftTopY, rightBottomY, listY);
        if (listX.size() > listY.size())
        {
            for (AVLNode<Integer> elementX : listX)
            {
                bigTree.insert(elementX.getKey(),elementX.getData());
            }
            for (AVLNode<Integer> elementY : listY)
            {
                if (bigTree.search(elementY.getData()) != null)
                {
                    obj = table.search(elementY.getData(), elementY.getKey());
                    names1[i] = (String) obj.getData();
                    i++;
                }
            }

        }


        if (listX.size() <= listY.size())
        {
            for (AVLNode<Integer> elementY : listY) {
                bigTree.insert(elementY.getKey(),elementY.getData());
            }
            for (AVLNode<Integer> elementX : listX) {
                if (bigTree.search(elementX.getData()) != null) {
                    obj = table.search(elementX.getKey(), elementX.getData());
                    names1[i] = (String) obj.getData();
                    i++;
            }
            }
        }
        return names1;

    }


    public String[] firstSolution(int leftTopX, int leftTopY, int rightBottomX,	int rightBottomY) {

        String[] names = new String[10];
        int i=0;
        ObjectWithCoordinates obj;
        ArrayList<AVLNode<Integer>> listX = new ArrayList<>();
        ArrayList<AVLNode<Integer>> listY = new ArrayList<>();
        listX = coordSearch(xTree.getRoot(), leftTopX, rightBottomX, listX);
        listY = coordSearch(yTree.getRoot(), leftTopY, rightBottomY, listY);
		for (AVLNode<Integer> XNODE : listX)
		{
			for (AVLNode<Integer> YNODE : listY)
			{
				if (XNODE.getKey() == YNODE.getData())
				{
                    obj = table.search(XNODE.getKey(), YNODE.getKey());
                    names[i] = (String) obj.getData();
                    i++;
                }

			}
        }
		return names;

		}


    public ArrayList<AVLNode<Integer>> coordSearch(AVLNode<Integer> node, int a, int b, ArrayList<AVLNode<Integer>> range) // a method that returns all the points in the range
    {

        if (node.getKey() >= a && node.getKey() <= b)
        {
            range.add(node);
            if (node.getLeftChild() != null)
            {
                coordSearch(node.getLeftChild(), a, b, range);
            }
            if (node.getRightChild() != null)
            {
                coordSearch(node.getRightChild(), a, b, range);
            }
        }

        if(node.getKey() < a && node.getRightChild() != null)
        {

            coordSearch(node.getRightChild(),a,b,range);
        }

        if (node.getKey() > b && node.getLeftChild() != null)
        {
            coordSearch(node.getLeftChild(), a, b, range);
        }
        return range;
    }
}