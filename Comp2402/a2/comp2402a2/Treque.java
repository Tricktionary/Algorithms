 package comp2402a2;

import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 */
public class Treque<T> extends AbstractList<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	Factory<T> f;

	/*
	 * First Half of the array 
	 */
	ArrayDeque<T> front;

	/*
	 * Second Half of the array 
	 */
	ArrayDeque<T> back;


	public Treque(Class<T> t) {
		// Put your own code here
		front = new ArrayDeque<T>(t);
		back  = new ArrayDeque<T>(t);
		f     = new Factory<T>(t);
	}

	public T get(int i) {
		if (i < 0 || i > size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (i < front.size()) {
			return front.get(i);
		}
		 else {
			return back.get(i-front.size());
		}
	}

	public T set(int i, T x) {
		if (i < 0 || i > size() - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (i < front.size()) {
			return front.set(i, x);
		} 
		else {
			return back.set(i-front.size(), x);
		}
	}

	public void add(int i, T x) {
		if (i < 0 || i > size()){
			throw new IndexOutOfBoundsException();
		}
		if (i < front.size()) {
			front.add(i, x);
		}
		else {
			back.add(i-front.size(), x);
		}
		balance();		
		
	}

	public boolean add(T x){
		back.add(back.size(),x);
		balance();
		return(true);

	}
	

	public T remove(int i) {
		if (i < 0 || i > size() - 1){
			throw new IndexOutOfBoundsException();
			}
		T x;
		if (i < front.size()) {
			x = front.remove(i);
		} 
		else {
			x = back.remove(i-front.size());
		}
		balance();
		return x;
	}

	public int size(){
		return (front.size() + back.size());
	}


	public void balance(){
		if( Math.abs(front.size()-back.size()) >1 ){    //difference is greater than 1 

			if (front.size() > back.size()){
				back.add(0,front.remove(front.size()-1));
			}
			else {
				front.add(front.size(), back.remove(0));
			}
		}
	}
 
	public static void main(String[] args) {
		List<Integer> tr = new Treque<Integer>(Integer.class);
		int K = 1000000;
		Stopwatch s = new Stopwatch();
		System.out.print("Appending " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Prepending " + K + " items...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			tr.add(0, i);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Midpending(?!) " + K + " items...");
		System.out.flush();
		s.start();
		for (int i = 0; i < K; i++) {
			tr.add(tr.size()/2);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");


		System.out.print("Removing " + K + " items from the back...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			tr.remove(tr.size()-1);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the front...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			tr.remove(0);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.print("Removing " + K + " items from the middle...");
		System.out.flush();

		 
		for (int i = 0; i < K; i++) {
			//System.out.println(tr.size()/2);
			tr.remove(tr.size()/2);
		}
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
	}



}

