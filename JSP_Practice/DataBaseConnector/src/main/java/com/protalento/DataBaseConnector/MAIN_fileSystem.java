package com.protalento.DataBaseConnector;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MAIN_fileSystem {
	public static void main(String[] args) {
		try {
			
			Path outFile = FileSystems.getDefault().getPath("src", "main", "UserGeneratedCSVs", "mySecondCSV_dbg.csv");
			FileSystem fileSystems = FileSystems.newFileSystem(outFile, Thread.currentThread().getContextClassLoader());
			
			for (Path path : fileSystems.getRootDirectories()) {
				System.out.println(path);
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		
		
		
	}
}
