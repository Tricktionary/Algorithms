package comp2402a3;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {

  // Handy for testing correctness now that we know A2Table works
  public static <T> boolean tableEquals(Table<T> t1, Table<T> t2) {
    if (t1.rows() != t2.rows()) return false;
    if (t1.cols() != t2.cols()) return false;
    for (int i = 0; i < t1.rows(); i++) {
      for (int j = 0; j < t2.cols(); j++) {
        T x1 = t1.get(i, j);
        T x2 = t2.get(i, j);
        if (x1 != null && x2 == null) return false;
        if (x1 == null && x2 != null) return false;
        if (x1 != null && !x1.equals(x2)) return false;
      }
    }
    return true;
  }


  public static boolean testPart1(Table<Integer> t) {
    // put your testing code here
    
    t.addCol(0);
    if(t.cols() != 1){
        return(false);
    }
    t.addRow(0);
    if(t.rows() != 1){
            return(false);
        }
    
    int nrows = 9, ncols = 6;
    for (int i = 0; i < nrows; i++) {
      t.addRow(t.rows());
    }

    for (int i = 0; i < ncols; i++) {
      t.addCol(t.cols());
    }

    for (int i = 1; i <= nrows; i++) {
      t.set(i-1, (i-1)%t.cols(), 1111*i);
    }
    t.get(0,0);
    t.rows();
    t.cols();
    t.addCol(2);
    t.addRow(3);
    t.removeCol(0);
    t.removeRow(0);

    while(t.cols()>0){
      t.removeCol(0);
    }
    
    return true;
  }

  public static void testTable(Table<Integer> tab) {
    long start = System.nanoTime();
    boolean result = Tester.testPart1(tab);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + tab.getClass().getName());
  }


  public static boolean testPart2(List<Integer> ell) {
    
//**************** Checking for Correctness ********************************************************************************************
    for(int i = 0 ; i <=100 ; i+=5){
      ell.add(i,i);
    }
    
    for(int i = 0 ; i <= 100 ; i+=5){
      if(ell.get(i)!=i){
        return false;
      }
    }

    ell.remove(100);
    if (ell.get(100)!=null){
      return false;
    }

    if(ell.get(2)!=null){
      return false;
    }
    ell.add((Integer.MAX_VALUE)-1,69);
    if(ell.get((Integer.MAX_VALUE)-1) != 69){
      return false;
    }

    if(ell.size() != Integer.MAX_VALUE){
      return false;
    }

    return true;
  }

  public static void testDefaultList(List<Integer> ell) {
    long start = System.nanoTime();
    boolean result = Tester.testPart2(ell);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + ell.getClass().getName());

  }

}
