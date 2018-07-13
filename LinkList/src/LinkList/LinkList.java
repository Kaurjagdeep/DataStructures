package LinkList;

import java.util.ArrayList;

import LinkList.LinkListNode;

public class LinkList {

	LinkListNode headNode;

	public LinkList() {
		headNode = null;
	}

	public ArrayList<Integer> getAllValues() {

		if (headNode != null) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			LinkListNode currentNode = headNode;
			while (currentNode != null) {
				arrayList.add(currentNode.getNodeValue());
				currentNode = currentNode.getNextNode();
			}
			return arrayList;
		} else
			return null;

	}

	public int getLength() {
		int size = 0;
		LinkListNode currentNode = headNode;
		if (headNode != null) {
			while (currentNode != null) {
				size++;
				currentNode = currentNode.getNextNode();
			}
		}
		return size;
	}

	public LinkListNode getLastNode() {
		if (headNode == null)
			return null;
		LinkListNode currentNode = headNode;
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}

	public LinkListNode getNode(int position) throws Exception {
		if (headNode == null)
			return null;

		if (position >= getLength()) {
			throw new Exception("Position is greater than or equal to the length of list.");
		} else if (position < 0) {
			throw new Exception("Position is negative. It must be >= 0 ");
		}

		LinkListNode currentNode = headNode;
		int counter = 0;
		while (counter < position) {
			currentNode = currentNode.getNextNode();
			counter++;
		}
		return currentNode;

	}

	public void addNodeToEnd(int val) {
		LinkListNode newNode = new LinkListNode(val);
		LinkListNode listLastNode = getLastNode();
		if (listLastNode == null) {
			headNode = newNode;
		} else {
			listLastNode.setnextNode(newNode);
		}
	}

	public void addNodeAtPosition(int val, int position) throws Exception {
		LinkListNode newNode = new LinkListNode(val);
		LinkListNode previousPositionNode = null;
		// Position to add can be 0 to n
		
		if(position < 0 || position > getLength())
		{
			throw new Exception("Position to Add MUST be >= 0 AND <= length of list.");
		}
		
		// Handle adding a node in the beginning
		// Note: We need to allow addition to empty list for position 0. 
		if(position==0) {
			newNode.setnextNode(headNode);
			headNode=newNode;
		}
		else {
			// Position > 0. Note that length >= 1
			try {
				previousPositionNode = getNode(position-1); // 100
				newNode.setnextNode(previousPositionNode.getNextNode());
				previousPositionNode.setnextNode(newNode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteNode(int position) throws Exception{
		if (position<0 || position >=getLength())
			throw new Exception("Delete Position Must be >= 0 and less than Length of list");
		if (getLength()==0)
			throw new Exception("Deletion not allowed on empty list.");
		LinkListNode toDeleteNode= getNode(position);
		if(position==0) {
			headNode= toDeleteNode.getNextNode();
		}
		else {
			LinkListNode previousNode= getNode(position-1);
			previousNode.setnextNode(toDeleteNode.getNextNode());
		}
		toDeleteNode=null;
	}

public void updateNode(int val, int position) throws Exception{
	if (position<0 || position >=getLength())
		throw new Exception("Update Position Must be >= 0 and less than Length of list");
	if (getLength()==0)
		throw new Exception("Updation is not allowed on empty list.");
	LinkListNode toUpdateNode= getNode(position);
	toUpdateNode.setnodeValue(val);
	
}
	public static void main(String[] args) {
		LinkList list = new LinkList();
		ArrayList<Integer> result = null;
		try {
		    list.addNodeAtPosition(11, 0);
			list.addNodeAtPosition(21, 1);
			list.addNodeAtPosition(31, 2);
			
	     //   list.addNodeAtPosition(13, 2);
			result = list.getAllValues();
			System.out.println("List after Adding a node");
			for (int i = 0; result != null && i < result.size(); i++) {
				System.out.println("Position:" + i + "   Value:" + result.get(i));
			}
			
			//list.deleteNode(0);
			result = list.getAllValues();
			System.out.println("List after Deleting a node");
			if (result == null)
				System.out.println("List is Empty after deletion");
			for (int i = 0; result != null && i < result.size(); i++) {
				System.out.println("Position:" + i + "   Value:" + result.get(i));
			}
			list.updateNode(100, 1);
			result = list.getAllValues();
			System.out.println("List after Updating a node");
			if (result == null)
				System.out.println("List is Empty");
			for (int i = 0; result != null && i < result.size(); i++) {
				System.out.println("Position:" + i + "   Value:" + result.get(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
