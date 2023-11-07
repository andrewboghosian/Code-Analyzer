/*
Andrew Boghosian
COMP 282
Professor Mani Heravi
Project 1 - Code Analyzer
November 5, 2023
*/
import java.io.File;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SinglyLinkedList {
	private Node head;
	public SinglyLinkedList() {this.head = null;}

	public void insertBack(String data) {
		Node node = new Node(data);

		if(head == null) {head = node;} else {
			Node tmp = head;
			while(tmp.getNext() != null) {tmp = tmp.getNext();}
			tmp.setNext(node);
		} 
	}


	public boolean addFromDirect(String fileName, String pathDirectory) {
		//Throw exception in case file does not exist
		try (FileReader fileReader = new FileReader(pathDirectory + "/" + fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String line;
			//Make regex pattern to detect forms of "#include "xxxxx.(end extenstion we want)""
			Pattern includePattern = Pattern.compile("#include\s\"([A-z0-9]+(.cpp|.cxx|.c|.hpp|.hxx|.h))\"");

			//Iterate through each line of the file
			while((line = bufferedReader.readLine()) != null) {
				Matcher matcher = includePattern.matcher(line);
				//When we find our pattern, insert the filename to the back
				if(matcher.find()) {
                	String includedFileName = matcher.group(1);
                	this.insertBack(includedFileName);
				}
			}
		} catch (IOException e) {
			System.out.println("Theres an error");
		}

		return true;
	}

	//Checks the files in the linked list to see if there are other inclusions
	public boolean checkFiles(String pathDirectory, String directFile) {
		if(head == null) {return false;}
		Node tmp = head;
		//Go through linked list
		while(tmp != null) {
			File includedFile = new File(pathDirectory, tmp.getData());
			//Check if file in directory exists already in linked list
			if(includedFile.exists() && includedFile.isFile()) {
				try (FileReader fileReader = new FileReader(pathDirectory + "/" + tmp.getData());
					BufferedReader bufferedReader = new BufferedReader(fileReader)) {

					String line;
					String fileName = tmp.getData();
					Pattern includePattern = Pattern.compile("#include\s\"([A-z0-9]+(.cpp|.cxx|.c|.hpp|.hxx|.h))\"");
					//Check if there are more inclusions
					while((line = bufferedReader.readLine()) != null) {
						Matcher matcher = includePattern.matcher(line);
						if(matcher.find()) {
		                	String includedFileName = matcher.group(1);
		                	if(find(includedFileName)) {
		                		System.out.println("----------------------------------");
		                		System.out.println(fileName + " includes " + includedFileName);
		                		System.out.println(directFile + " includes " + includedFileName);
		                		System.out.println("----------------------------------");
		                	} else {this.insertBack(includedFileName);}
						}
					}
				} catch (IOException e) {
					System.out.println("There's an error in checkFiles");
					return false;
					}
				}
			else {
				System.out.println("The file " + tmp.getData() + " does not exist in the directory.");
			}

			tmp = tmp.getNext();
			}
		return true;
	}

	public boolean find(String fileName) {
		if(head == null) {return false;}
		Node tmp = head;
		while(tmp != null) {
			if(fileName.equals(tmp.getData())) {
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	public void print() {
		if(head == null) {
			System.out.println("List is empty");
		}
		else{
			Node tmp = head;
			System.out.println("----------------------------------");
			while(tmp != null) {
				System.out.println(tmp.getData());
				tmp = tmp.getNext();
			}
			System.out.println("----------------------------------");
		}
	}
}