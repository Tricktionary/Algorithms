package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

public class Part3 {
 
 /**
  * Your code goes here - see Part0 for an example
  * @param r the reader to read from
  * @param w the writer to write to
  * @throws IOException
  */
 public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
  // Your code goes here - see Part0 for an example
   
   List<String> list = new ArrayList<String>();        //Creates List 
   
   int spot = 0;
   for (String line = r.readLine(); line != null; line = r.readLine()){
    list.add(line); 
    if(list.get(spot).isEmpty()){                     //If empty 
       if(spot>=67){                                   //and greater than 67
         w.println(list.get(spot-67));                 //Append / Print?       
       }
     }
    if(spot>=67){
      list.remove(spot-67);
    }
    else{
      spot++;
    }
   }
   /*
   int size = list.size();        //Get size of list                      
   
   for (int spot = 0; spot <size ; spot++){            //Run it through until it gets ths max size
     if(list.get(spot).isEmpty()){                     //If empty 
       if(spot>=67){                                   //and greater than 67
         w.println(list.get(spot-67));                 //Append / Print?       
       }
     }
      if(spot>=67){
        list.remove(spot-67);
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
