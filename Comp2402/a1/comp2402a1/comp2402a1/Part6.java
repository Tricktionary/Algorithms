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
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;


public class Part6 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example
		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		for (String line = r.readLine(); line != null; line = r.readLine()){
     		list.add(line);                                                     //Adds Line to list
   		}

   		for(int i =0 ; i < list.size(); i++){  //Go through the list
   			
   			if(map.containsKey(list.get(i))){     //If it does not have it
   				map.put(list.get(i), map.get(list.get(i))+1);
   			}
   			else{
   				map.put(list.get(i),1);
   			}
   		}

   		List<Map.Entry<String, Integer>> newList = new ArrayList<Map.Entry<String,Integer>>();
   		newList.addAll(map.entrySet());

   		Collections.sort(newList , new Comparator<Map.Entry<String,Integer>>() {
   				public int compare(Map.Entry<String,Integer> map1 , Map.Entry<String,Integer> map2){

   					if(map2.getValue().compareTo(map1.getValue()) == 0 ){
   						return(map1.getKey().compareTo(map2.getKey()));

   					} 
   					else{
   						return(map2.getValue().compareTo(map1.getValue()));
   					}
   				}
   		});
   		for (Map.Entry<String,Integer> s : newList){
   			w.println(s.getKey());
   		}
 



   		/*
   		List<String> word = new ArrayList<String>();
   		List<Integer> freq  =new ArrayList<Integer>();

 
   		for(String s : map.keySet()){
   			word.add(s);
   			freq.add(map.get(s));

   		}

   		boolean swap = true;
   		int tempI;
   		String tempS;
   		while(swap == true){
   			swap=false;
   			for(int i = 0;i < (word.size()-1) ; i++){
   				if(freq.get(i) < freq.get(i+1)){
   					tempS = word.get(i);
   					tempI = freq.get(i);
   					
   					word.set(i,word.get(i+1));
   					freq.set(i,freq.get(i+1));

   					word.set(i+1,tempS);
   					freq.set(i+1,tempI);

   					swap=true;

   				}
   			}
   		}

   		for (String text : word) {
            w.println(text);
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
