import java.lang.reflect.*;
import java.io.File;
import java.util.*;
import javafx.util.*;
import java.net.*;

/**
cisc3150 
hw10
direction:
Write a program that can handle plugins.

Your plugin interface is:

public abstract class myplugin{
        public void whoSaysHello(){}
        public void whoSaysBye(){}
}

Create two separate plugins from that abstract class. Place them in a
directory called plugin.

Your main program will search through the plugin directory looking for
plugin names, it'll then give the user an option whether they want to
execute the first plugin or the second plugin (print the plugin names on
the screen) And depending on the choice, it'll execute the two functions
in the chosen plugin.

I learned how to make File to URL here: https://stackoverflow.com/questions/6098472/pass-a-local-file-in-to-url-in-java
@author Erii Sugimoto
@since 12/10/2017
*/

public class Main{
	public static void main(String[] args) throws Throwable{
		final String fileName = "/Users/Erii/Desktop/GitHub/cisc3150/hw10/plugin";
		File file = new File(fileName);
		
		File[] childrenFiles = file.listFiles();
		ArrayList<String> pluginNames = new ArrayList<>();
		for(int i = 0; i < childrenFiles.length; i++){
			if(!childrenFiles[i].getName().contains(".java") && !childrenFiles[i].getName().contains("myplugin"))
				pluginNames.add(childrenFiles[i].getName().replace(".class", ""));				 
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("Here are the the options of plugin we can run for you:");
		
		for(int i = 0; i < pluginNames.size(); i++){
			System.out.println(pluginNames.get(i));
		}
		
		System.out.print("\nWhich one would you like us to run? -> ");
		String chosen = in.next();
		
		System.out.println("Great! We'll run " + chosen + ":\n");
		
		URL[] url = {file.toURI().toURL()};
		URLClassLoader urlcl = new URLClassLoader(url);
		Class<?> c = urlcl.loadClass(chosen);
		
		
		Object mya = c.newInstance();
		
		Method mtd = c.getMethod("whoSaysHello");
		mtd.invoke(mya);
		mtd = c.getMethod("whoSaysBye");
		mtd.invoke(mya);
	}
	
}
