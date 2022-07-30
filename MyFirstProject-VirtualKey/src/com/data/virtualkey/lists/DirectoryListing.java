package com.data.virtualkey.lists;
import java.io.File;

import com.data.virtualkey.method.PathDirectory;
public class DirectoryListing {
      private static PathDirectory filedir = new PathDirectory();
      public static void showFileList() {
    	  filedir.addFiles();
    	  for(File file : DirectoryListing.getFileDirectory().getFiles()) {
    		  System.out.println(file.getName());
    	  }
      }
      public static PathDirectory  getFileDirectory() {
    	  return filedir;
      }
      public static void setFileDirectory(PathDirectory filedir) {
    	  DirectoryListing.filedir = filedir;
      }
}


