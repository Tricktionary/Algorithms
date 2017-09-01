package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class Part5 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		for (String line = r.readLine(); line != null; line = r.readLine()){
			
			if(map.containsKey(line)){     //If it does not have it
   				map.put(line, map.get(line)+1);
   				w.println(map.get(line));
   			}
   			else{
   				map.put(line,1);
   				w.println(map.get(line));
   			}
   		}
/*
   		for(int i =0 ; i < list.size(); i++){  //Go through the list
   			
   			if(map.containsKey(list.get(i))){     //If it does not have it
   				map.put(list.get(i), map.get(list.get(i))+1);
   			}
   			else{
   				map.put(list.get(i),1);
   			}
   		}
*/

   	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			//System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
