  package comp2402a2;

/**
 */
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;

public class Table<T> implements AbstractTable<T> {
	/**
	 * You decide on the instance variables you need.
	 */

	Factory<T> f;

	List<List<T>> table;

	int sizeRow;
	int sizeCol;
	//int ToadStack=3;

	public Table(Class<T> t) {
		// Put your own code here
		table = new ArrayList<List<T>>();
		sizeRow = 0;
		sizeCol = 0;

	}

	public int rows() {
		return sizeRow;                        //Gets the array list and returns the size 
	}

	public int cols() {
		return sizeCol;                        //Returns the size of the table == col 
	}


	public T get(int i, int j) {
		if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1) throw new IndexOutOfBoundsException();
		return(table.get(i).get(j));   //Get the row that contains the col that contains the item
	}

	public T set(int i, int j, T x) {
		if (i < 0 || i > rows() - 1 || j < 0 || j > cols()-1) throw new IndexOutOfBoundsException();
		T save ;
		save = get(i,j);             //Get the Item and save it   
		table.get(i).set(j,x);       //Go to the row the set col at the position to the value 
		return save;                 //Return value 
	}

	public void addRow(int i) {
		if (i < 0 || i > rows()) throw new IndexOutOfBoundsException();
		
		table.add(i, new ArrayList<T>());     //Adds a new Row to position i 

		for(int m = 0 ; m < cols(); m++){     //Fill the newly added row with nulls 
			table.get(i).add(m,null);
		}

		sizeRow++;
	}

	public void removeRow(int i) {                                
		if (i < 0 || i > rows() - 1) throw new IndexOutOfBoundsException();

		table.remove(i);          //Removes the row the data structure will deal with the shifting 
		sizeRow--;

	}

	public void addCol(int j) {
		if (j < 0 || j > cols()) throw new IndexOutOfBoundsException();

		for(int m =0; m<rows() ; m++){   
			table.get(m).add(j,null);    //Reverse Works ? 
		}

		sizeCol++;

	}

	public void removeCol(int j) {
		for(int m = 0 ; m<rows() ; m++){
			table.get(m).remove(j);
		}
		sizeCol--;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows(); i++) {
			for (int j = 0; j < cols(); j++) {
				sb.append(String.valueOf(get(i, j)));
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/* Here is the expected output from this main function:
		1111 null null null null null 
		null 2222 null null null null
		null null 3333 null null null
		null null null 4444 null null
		null null null null 5555 null
		null null null null null 6666
		7777 null null null null null
		null 8888 null null null null
		null null 9999 null null null

		1111 null null null null null null
		null 2222 null null null null null
		null null null 3333 null null null
		null null null null null null null
		null null null null 4444 null null
		null null null null null 5555 null
		null null null null null null 6666
		7777 null null null null null null
		null 8888 null null null null null
		null null null 9999 null null null
	*/

	public static void main(String[] args) {
		int nrows = 9, ncols = 6;
		Table<Integer> t = new Table<Integer>(Integer.class);

 		
 		for (int i = 0; i < nrows; i++) {
			t.addRow(t.rows());
		}

 		for (int i = 0; i < ncols; i++) {
			t.addCol(t.cols());
		}

		for (int i = 1; i <= nrows; i++) {
			t.set(i-1, (i-1)%t.cols(), 1111*i);
		}

		System.out.println(t.toString());
		t.addCol(2);
		t.addRow(3);

	}
}
