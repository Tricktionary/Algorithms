package comp2402a2;

import java.util.List;

public class Tester {
    public static boolean testPart1(List<Integer> ell) {
        // Put your tests here
        int K = 10;
        Stopwatch s = new Stopwatch();
        double time =0;

        ell.add(0,1);
        if(ell.get(0)!=1){
            return false;
        }

        //Appending 
        s.start();
        for(int i = 0; i < K ; i++){
            ell.add(i);
        }
        s.stop();
        time+=s.elapsedSeconds();
        

        //Correctness
        for (int i = 0 ; i < ell.size() ; i++){
            ell.set(i,i);
        }
        for(int i = 0 ; i < ell.size() ; i++){
            if(ell.get(i) != i){
                return false;
            }
        }


        //Prepending
        s.start();
        for(int i = 0; i < K ; i++){
            ell.add(i,i);
        }
        s.stop();
        time += s.elapsedSeconds();
 
        //midpending
        s.start();
        for(int i = 0 ; i < K; i++){
            ell.add(ell.size()/2);
        }
        s.stop();
        time+= s.elapsedSeconds();

        //Removing from front
        s.start();
        for (int i = 0; i < K; i++) {
            ell.remove(0);
        }
        s.stop();
        time+= s.elapsedSeconds();

        //removing from back
        s.start();
        for (int i = 0; i < K; i++) {
            ell.remove(ell.size()-1);
        }
        s.stop();
        time+=s.elapsedSeconds();

        //time 0.0004
        //Removing from mid 
        s.start();
        for (int i = 0; i < K ; i++) {   
            ell.remove(ell.size()/2);
        }
        s.stop();
        time += s.elapsedSeconds();

        if(time > 0.0002){
            return(false);
        }

        return true;
    }
    public static boolean testPart2(List<Integer> rad) {
        // Put your tests here

        if(rad.size() != 0){
            return false;
        }

        for(int i = 0; i <100 ; i++){
            rad.add(i,i);
        }

        for(int i = 0; i<100 ; i++){
            if(rad.get(i)!=i){
                return false;
            }
        }

        for(int i = 0 ; i<10 ;i++){
            rad.set(i,69);
        }

        for(int i = 0; i<10 ;i++){
            if(rad.get(i)!=69){
                return false ;
            }
        }

        for(int i = 50 ; i <= 56; i++){
            rad.add(i,21);
        }

        for(int i =50 ;i<=56 ;i++){
            if(rad.get(i)!=21){
                return false;
            }
        }

        for(int i = 100 ; i< 120; i++){
            rad.add(i,45);
        }
        for(int i = 100 ;i < 120;i++){
            if(rad.get(i)!=45){
                return false;
            }
        }

        for(int i = 0 ; i <=5 ; i++){
            rad.add(i,1169);
        }
        for(int i = 0 ; i <=5 ; i++){
            rad.remove(i);
        }

        for(int i=0 ; i<=5 ;i++){
            if(i==1169){
                return false;
            }
        }
        
        for(int i = 50 ; i <=55 ; i++){
            rad.add(i,1169);
        }
        for(int i = 50 ; i <=55 ; i++){
            rad.remove(i);
        }        

        for(int i=50 ; i<=55 ;i++){
            if(i==1169){
                return false;
            }
        }

        while(rad.size()!=0){
            rad.remove(0);
        }
        if(rad.size()!= 0){
            return false;
        }
        Stopwatch s = new Stopwatch();
        double time  = 0;
        int K =10000;
        s.start();
        for (int i = 0; i < K; i++) {
            rad.add(i);
        }
        s.stop();
        time += s.elapsedSeconds();
 
        s.start();
        for (int i = 0; i < K; i++) {
            rad.add(0, i);
        }
        s.stop();
        time+= s.elapsedSeconds();

        s.start();
        for (int i = 0; i < K; i++) {
            rad.remove(rad.size()-1);
        }
        s.stop();
        time+=s.elapsedSeconds();
 
        s.start();
        for (int i = 0; i < K; i++) {
            rad.remove(0);
        }
        s.stop(); 
        time+=s.elapsedSeconds();

        if(time > 1f ){
            return(false);
        }
 



        return(true);


    }

    public static boolean testPart3(AbstractTable<Integer> t) {
        // Put your tests here
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
}
