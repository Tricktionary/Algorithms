package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class Part1 {
 
 /**
  * Your code goes here - see Part0 for an example
  * @param r the reader to read from
  * @param w the writer to write to
  * @throws IOException
  */
 public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
  // Your code goes here - see Part0 for an example
   
  /*
   List<String> list = new ArrayList<String>();        //Creates List 
   
   for (String line = r.readLine(); line != null; line = r.readLine()){
     list.add(line);                                                     //Adds Line to list
   }

   int size = list.size()-1;             //Get the size of list after making it 
     
   for(int i = size ; i >=0 ; i--){    //Go from the last element to the first
     w.println(list.get(i));
   }
  */
   

   Deque<String> deque = new ArrayDeque<String>();
   
   for (String line = r.readLine(); line != null; line = r.readLine()){
     deque.add(line);                                                     //Adds Line to list
   }

   while(deque.peekLast() != null){                //Check If the last is null
     w.println(deque.getLast());                  //Add last Element
     deque.removeLast();                          //Remove last element
   }
   

   
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
     //r = new BufferedReader(new FileReader("./tests/Test1-01.in"));
     //w = new PrintWriter(new FileWriter("//tests//Test1-01.out"));
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
