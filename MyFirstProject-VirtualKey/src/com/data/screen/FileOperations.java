package com.data.screen;
import com.data.virtualkey.method.PathDirectory;

import java.io.File;
import java.io.IOException;
import java.util.*;
public class FileOperations implements StartScreening{
    private PathDirectory dir = new PathDirectory(); 
    private ArrayList<String> operations = new ArrayList<>();

    public FileOperations() {
    	operations.add("1. Add a File");
        operations.add("2. Delete A File");
        operations.add("3. Search A File");
        operations.add("4. Return to Main Menu");
    }
    public void print() {
    	System.out.println("File Options Menu");
        for (String op : operations) {
            System.out.println(op);
        }

    }
    public void getSelect() {
    	int option = 0;
		while((option=this.getOption())!=4) {
			this.goToSelection(option);
		}
    }
    private int getOption() {
        Scanner sc = new Scanner(System.in);
			int  selectedOption= 0;
			try {
			     selectedOption = sc.nextInt();
			}
			catch (InputMismatchException ex) {

			 }
			return selectedOption;



	 }
    public void goToSelection(int option) {
    	switch(option) {

        case 1: // Add File
            this.addFile();

            this.print();
            break;
        case 2: // Delete File
            this.deleteFile();

            this.print();
            break;
        case 3: // Search File
            this.searchFile();
            this.print();
            break;
        default:
            System.out.println("Invalid Option");
            break;
    }
    }
    //File Operations Methods
    	public void addFile() {
    		System.out.println("Please Enter the filename to add: ");
    		String fileName = this.getFileName();
    		System.out.println("Name of the file you entered for adding is: "+fileName);
    		File file = new File("src/folders/"+fileName);
    		try {
				if(file.createNewFile()) {
					System.out.println("File is successfully created"+"\n"+"Name of the file created is: "+fileName);
					dir.getFiles().add(file);
				}
				else {
					System.out.println("Cannot add,this file already exists.");
				}
			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
    	}
    	public void deleteFile() {
    		System.out.println("Enter the file name to get delete: ");
    		String delFile = this.getFileName();
    		//System.out.println("You are deleting a file named: "+delFile)
    		 String name = "src/folders/"+delFile;
    		 File file  =new File(name);
    		 if(file.delete()) {
    			 System.out.println("Successfully,Deleted the File: " + file.getName());
   	    	  dir.getFiles().remove(file); 
    		 }
    		 else {
    			 System.out.println("Failed to delete file:" + delFile + ", file was not found."); 
    		 }
    	}
    	public void searchFile() {
    		Boolean found = false;
    		System.out.println("Please enter the file name: ");
    		String searchFile = this.getFileName();
    		System.out.println("Searching the file......");
    		ArrayList<File> files = dir.getFiles();
    		for(File e:files) {
    			if(e.getName().equals(searchFile)) {
    				System.out.println("Found the file: "+searchFile);
    				found = true;
    			}
    		}
    		if(found==false) {
        		System.out.println("File  not found");
        	}
    	}

    	   private String getFileName() {

    	        Scanner sc = new Scanner(System.in);
    	        return  sc.nextLine();

    	    }
}

