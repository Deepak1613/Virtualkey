package com.data.virtualkey.lists;
import com.data.screen.*;
public class ScreenListing {
	public static WelcomeScreen StartScreen = new WelcomeScreen();
    public static FileOperations FileOperationsScreen = new FileOperations();



    public static StartScreening currentScreen = StartScreen;


    public static StartScreening getCurrentScreen() {
        return currentScreen;
    }


    public static void setCurrentScreen(StartScreening currentscreen) {
        currentScreen = currentscreen;
    }
}
