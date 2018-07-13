package LinkList;

import LinkList.LinkListNode;

public class LinkListNode {

	int nodeValue;
	LinkListNode nextNode;
	
	public LinkListNode(int Val) 
	{
		nodeValue=Val;
		nextNode=null;// TODO Auto-generated constructor stub
	}
	public LinkListNode() 
	{
		//nodeValue=0;
		nextNode=null;// TODO Auto-generated constructor stub
	}
	public void setnodeValue (int Val)
	{
		nodeValue=Val;
	}
	public void setnextNode(LinkListNode Node)
	{
		nextNode=Node;
	}
	public int getNodeValue()
	{
		return nodeValue;
	}
	public LinkListNode getNextNode()
	{
		return nextNode;
	}
	}