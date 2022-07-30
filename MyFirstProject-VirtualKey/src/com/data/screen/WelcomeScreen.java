package com.data.screen;
import java.util.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.data.virtualkey.lists.ScreenListing;
import com.data.virtualkey.lists.DirectoryListing;

public class WelcomeScreen implements StartScreening {
	public String welcome = "Welcome to the Virtual Project";
	public String name = "Developer: Bhavana Gudivada";
	private ArrayList<String> selectOne = new ArrayList<String>();
	
	public void print() {
		System.out.println(welcome);
		System.out.println(name);
		this.selectOption();
		
		
	}
	public WelcomeScreen() {
		selectOne.add("1.List of directories");
		selectOne.add("2.File Operations");
		selectOne.add("3.Exit");
		
		
	}
	public void selectOption() {
		System.out.println("Menu Options");
		for(String option:selectOne) {
			System.out.println(option);
		}
	}
	public void getSelect() {
		int option = 0;
		while((option=this.getOption())!=3) {
			this.goToSelection(option);
		}
		if(option==3) {
			System.out.println("Thank you....");
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

            case 1: 
                this.showFiles();
                this.print();
                break;



			  case 2: 
				  ScreenListing.setCurrentScreen(ScreenListing.FileOperationsScreen);
			      ScreenListing.getCurrentScreen().print();
			      ScreenListing.getCurrentScreen().getSelect(); 
			      this.print(); 
			      break;

              default:
                System.out.println("Invalid Option");
                break;
        }

    }
	public void showFiles() {
		 System.out.println("Presenting the Files list: ");
		 DirectoryListing.showFileList();
	 }

	
	

}
