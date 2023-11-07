/*
Andrew Boghosian
COMP 282
Professor Mani Heravi
Project 1 - Code Analyzer
November 5, 2023
*/
/*
Node class that holds the name of the file along with the address of the next node(next file).
*/

public class Node {
	private String data;
	private Node next;

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(String data) {this(data, null);}

	public void setData(String data) {this.data = data;}
	public String getData() {return this.data;}
	public void setNext(Node next) {this.next = next;}
	public Node getNext() {return this.next;}
}