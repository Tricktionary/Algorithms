package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.Deque;
import java.util.ArrayDeque;



public class Part7 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example

		
		Deque<String> deque = new ArrayDeque<String>();

		for (String line = r.readLine(); line != null; line = r.readLine()){
			
			while(deque.peekLast()!=null) {  //Itterate through a deque backwards

				if(line.compareTo(deque.peekLast()) >= 0){
					deque.removeLast();
				}
				else{
					break;
				}
			}

			deque.addLast(line);
		}

		for(String x : deque ){
			w.println(x);

		}
	}
	
	/*
		List<String>list = new ArrayList<String>();
   		//List<String>sortedList = new ArrayList<String>();

		for (String line = r.readLine(); line != null; line = r.readLine()){
			list.add(line);
		}
		String largest;
   		int spot = 0 ; 

   		int size = list.size();
		while(size > 0){
   	
   			largest = "";

   			for(int i = 0 ; i < size ; i++){
   				if(list.get(i).compareTo(largest) >= 0){
   					largest = list.get(i);
   					spot = i;	
   				}
   			}
   				w.println(largest);
   				list = list.subList(spot+1,size); //Reduce the sublist
   				size -= (spot+1);                 //Change the size 
	   			
		}
	   
    }
    */



/*
   		Collections.sort(sortedList,Collections.reverseOrder());


   		int size = list.size();
   		int spot = 0;
   		int i = 0;

   		while(size >0){

   			spot =  list.lastIndexOf(sortedList.get(i));  //Find the last know spot of the largest

   			if(spot < 0){                                 //not found
   				i++;
   			}

   			if(spot >= 0){
   				w.println(sortedList.get(i));
   				list = list.subList(spot+1,size); //Reduce the sublist
   				size -= (spot+1);                 //Change the size 
   				i++;
   			}
   		}
 }
*/
 

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
