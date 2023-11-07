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

public class CodeAnalyzer {
	public static void main(String[] args) {
		String pathDirectory = "";

		//Takes the argument in the terminal and reads what is after the '-i'. Stores it as path. 
		//If there is an invalid path, it will print out an error message
		if (args.length >= 2 && "-i".equals(args[0])) {
            pathDirectory = args[1];
            //System.out.println("Path: " + pathDirectory);
        } else {
            System.out.println("Invalid usage. Please use: java Main -i [path]");
        }

        //Store folder as a file using the path
		File folder = new File(pathDirectory);
		//make regex pattern to match with the correct type of files we want
		Pattern includePattern = Pattern.compile("([A-z0-9]+(.cpp|.cxx|.c|.hpp|.hxx|.h))");

		//Go through each file in the directory, if they match with the type of file we want, we add it to the linked list
		for(File f : folder.listFiles()) {
			Matcher matcher = includePattern.matcher(f.getName());

			if(matcher.find()) {
				//Make a new linked list for every file we have in the directory. When we iterate through a file, the previous linked list is destroyed and a new one replaces it.
				SinglyLinkedList linkedList = new SinglyLinkedList();
				//.groupt(1) seperates our pattern recognition and makes a string of only what we want
				String fileName = matcher.group(1);
				//Add whatever #include is in the fileName
				linkedList.addFromDirect(fileName, pathDirectory);
				linkedList.checkFiles(pathDirectory, f.getName());
			}

		}

	}
	
}


