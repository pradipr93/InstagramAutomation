package com.insta.utility;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.insta.base.BaseConfiguration;

public class ReadWriteFile  {
	
 

	
	public static String replaceSelected() {
		String comment="";
		
	    try {
	    	
	    	
	        // input the file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\insta\\configProperties\\CustomFile"));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;
	        
	        int indexFromFile = 1, i = 1;
	        int totalLineCount = 0;
	        
	        indexFromFile = Integer.parseInt(file.readLine());
	        
	        while ((line = file.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	            totalLineCount++;
	            
	            if(indexFromFile > i )
	            {
	            	i++;
	            }
	            else if(comment.equals(""))
	            {
	            	comment = line;
	            	indexFromFile++;
	            }
	        }
	        
	        if(indexFromFile > totalLineCount)
	        {
	        	indexFromFile = 1;
	        }
	        
	        file.close();
	        String inputStr = inputBuffer.toString();
	        
	        inputStr = (indexFromFile+"\n").concat(inputStr);

	        //System.out.println(inputStr); // display the original file for debugging
	        System.out.println("the comment is: " + comment);
	        System.out.println("the next index is: " + indexFromFile);

	        // logic to replace lines in the string (could use regex here to be generic)
	        
	        /*inputStr = inputStr.replace(replaceWith + "1", replaceWith + "0"); 
	        

	        // display the new file for debugging
	        System.out.println("----------------------------------\n" + inputStr);

	        // write the new string with the replaced line OVER the same file*/
	        FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\insta\\configProperties\\CustomFile");
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();
	        

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	    return comment;
	}
}
