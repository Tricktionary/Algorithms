
package comp2402a2;

import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
//import java.util.RootishArrayStack;
/**
 */

public class RootishArrayDeque<T> extends AbstractList<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	/**
	 * The type of objects stored in this list
	 */
	Factory<T> f;

	/**
	 * The number of elements in the list
	 */

	/**
	 * list
	 */
	RootishArrayStack<T> front;
	RootishArrayStack<T> back;
	Class<T> t; 

	//The front is reversed 
	//The Back is normal orientation

	public RootishArrayDeque(Class<T> t) {
		f         = new Factory<T>(t);
		front     = new RootishArrayStack<T>(t);
		back      = new RootishArrayStack<T>(t);
		this.t = t;
	}

	public T get(int i) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();
		if (i < front.size()) {
			return front.get(front.size()-i-1);
		}
		else {
			return back.get(i-front.size());
		}
		
	}

	public T set(int i, T x) {
		if (i < 0 || i > size() - 1) throw new IndexOutOfBoundsException();

		if (i < front.size()) {
			return front.set(front.size()-i-1, x);
		}
		else {	
			return back.set(i-front.size(), x);
		}
	}

 	public void add(int i, T x) {
		if (i < 0 || i > size()) throw new IndexOutOfBoundsException();

		if (i < front.size()) {
			front.add(front.size()-i, x);
		}
		else {
			back.add(i-front.size(), x);
		}
		balance();
	}


	public T remove(int i){
		T x;
		if (i < front.size()) {
			x = front.remove(front.size()-i-1);
		} 
		else {
			x = back.remove(i-front.size());
		}
		balance();
		return(x);
	}

	public int size() {
 		return(back.size()+front.size());
	}

	public void balance(){
		
		int n = size();

		if (3*front.size() < back.size()) {
			int s = n/2 - front.size();
			RootishArrayStack l1 = new RootishArrayStack<T>(t);
			RootishArrayStack l2 = new RootishArrayStack<T>(t);
			l1.addAll(back.subList(0,s));
			Collections.reverse(l1);
			l1.addAll(front);
			l2.addAll(back.subList(s, back.size()));
			front = l1;
			back = l2;
		} 
		else if (3*back.size() < front.size()){
			int s = front.size() - n/2;
 			RootishArrayStack l1 = new RootishArrayStack<T>(t);
			RootishArrayStack l2 = new RootishArrayStack<T>(t);
			l1.addAll(front.subList(s, front.size()));
			l2.addAll(front.subList(0, s));
			Collections.reverse(l2);
			l2.addAll(back);
			front = l1;
			back = l2;
			}
		

	}

	public static void main(String[] args) {
		List<Integer> rad = new RootishArrayDeque<Integer>(Integer.class);
		int K = 10;
		Stopwatch s = new Stopwatch();
		System.out.println("Appending " + K + " items...");
		System.out.flush();
		s.start();

		for (int i = 0; i < K; i++) {
			rad.add(i);
		}

		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
		System.out.println("Prepending " + K + " items...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			rad.add(0, i);
		}
		
		for(int i = 0; i < rad.size(); i++){
			System.out.print(rad.get(i));
		}
		System.out.println();
		
		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.println("Removing " + K + " items from the back...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			rad.remove(rad.size()-1);
		}

		for(int i = 0; i < rad.size(); i++){
			System.out.print(rad.get(i));
		}
		System.out.println();

		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");

		System.out.println("Removing " + K + " items from the front...");
		System.out.flush();
		for (int i = 0; i < K; i++) {
			rad.remove(0);
		}

		for(int i = 0; i < rad.size(); i++){
			System.out.print(rad.get(i));
		}
		System.out.println();

		s.stop();
		System.out.println("done (" + s.elapsedSeconds() + "s)");
		
	}

 
 
 
}
