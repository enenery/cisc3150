import java.io.File;
import java.util.*;
import javafx.util.*;
/**
	cisc3150
	hw8
	direction: Write a program that goes through your file system and outputs a tree 
	diagram of all of your directories in a file called dir_tree.txt. The 
	methods in the File class will probably come in very handy. For a sample 
	output, check out this webpage: http://www.computerhope.com/treehlp.htm 
	Make sure you get the indentation right/tree branches right.
	@author erii sugimoto
	@since 11/11/2017.
*/
public class DirectoryLister{
	public static void main(String args[]){
		
		final String fileName = "/Users/Erii/Desktop/GitHub/cisc3150";
		File file = new File(fileName);
		Stack<Pair<Integer, File>> s = new Stack<Pair<Integer, File>>();
		Pair<Integer, File> pair = new Pair<Integer, File>(0, file);
		System.out.println(fileName + ":");
		s.push(pair);
		
		while(!s.isEmpty()){
			pair = s.pop();
	
			for(int i = 0; i < pair.getKey(); i++){
				if(pair.getKey() == 1){
					System.out.println("|----" + pair.getValue().getName());
				}else{
					if(i == 0){
						System.out.print("|    ");
					}else{
						if(i == pair.getKey()-1){
							System.out.println("|----" + pair.getValue().getName());
						}else
							System.out.print("     ");
					}
				}
			}
			
			File[] fileArray = pair.getValue().listFiles();
			
			if(fileArray != null){
				for(int i = fileArray.length-1; i >= 0 ; i--){
					s.push(new Pair(pair.getKey()+1, fileArray[i]));
				}
			}
			
		}
		
	}
}