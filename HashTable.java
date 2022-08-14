import java.util.LinkedList;
import java.util.ArrayList;


public class HashTable
{
	private ArrayList<LinkedList<ObjectWithCoordinates>> table;

	public HashTable()
	{
		table= new ArrayList<>();
	}
	
	public void insert(ObjectWithCoordinates object)
	{
		int index = hashFunc(object.getX(),object.getY());
		if (table.size()<=index || table.get(index) ==null)
		{
			LinkedList <ObjectWithCoordinates> list = new LinkedList<>();
			list.add(object);
			table.add(index,list);
		}
		else
		{
			table.get(index).add(object);
		}

	}

	public ObjectWithCoordinates search(int x, int y){
		int index = hashFunc(x,y);
		if(index <table.size() && table.get(index) != null )
		{
			for(ObjectWithCoordinates obj : table.get(index)) // if there is only 1 element in the linked list, the operation will take O(1) in the average case
			{
				if (obj.getX() == x && obj.getY() == y)
					return obj;
			}
		}
		return null;
	}

	public int hashFunc(int x, int y)
	{
		return ((x+y) % 11);
	}
}

