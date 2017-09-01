package comp2402a4;

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;


public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}
 
//	Part1

	public void inorderDraw() {
		assignLevels();                            // Sets Y coordinats

		GeometricTreeNode curr1 = firstNode();     // Gets the first node of the the tree
		int x = 0;					  			   // X-Coordinate 

		while(curr1 != null){		  			   // Traverse until you hit null
			curr1.position.x = x;                  // Sets the X coordinate
			x++;					  
			curr1 = nextNode(curr1);               // Moves to the next one
		}
	}
	
	
	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}
	
	
	/**
	 * Draw each node so that it's x-coordinate is as small
	 * as possible without intersecting any other node at the same level 
	 * the same as its parent's
	 */

//	Part2
	public void leftistDraw() {
		assignLevels();                            //Sets Y coordinates
		
		int x = 0;   
		int y = 0;                                 //Current Y value                             

		//BFS NON RECURSIVE ALGORYTHM
		Queue<GeometricTreeNode> q = new LinkedList<GeometricTreeNode>();
		q.add(r);
		
		while (!q.isEmpty()) {
			GeometricTreeNode u = q.remove();
			if(u.position.y != y){
				x = 0;
				y++;
			}
			u.position.x = x;                      //Setting coordinates 
			x++;
			if (u.left != nil){
				q.add(u.left);
			}
			if (u.right != nil){
				q.add(u.right);
			}

		}
		
	}
	
//	Part3
/*
	For Part 3, you want to compute the sizes of all subtrees in advance (using a post-order traversal)
	and store them in a HashMap. Then do a second traversal to compute the x and y coordinates.

	Expected:
	(0, 0)--------(2, 0)-(3, 0)
   	   |             |
	(0, 1)-(1, 1) (2, 1)

	Found:
	(0, 0)--------(0, 0)-(0, 0)
   	   |             |
	(0, 0)-(0, 0) (0, 0)


	Note:
	Determine the left child 
	Move to the left child 
	While moving to the left child set the Y and increment 
	if left cant go any deeper on the left child go up 
	while going up check the right and 
	Set the corrdinates Y will decrease every time you go up X will increase when you go right and never decrease
*/
	public void balancedDraw(){
		
		Map<GeometricTreeNode, Integer> map = new HashMap<GeometricTreeNode,Integer>();
		
		//1st TRAVERSE(GET SIZES AND STORE THE IN A HASHMAP)
		GeometricTreeNode u = r, prev = nil, next;
		while (u != nil) {
			if (prev == u.parent) {
				if (u.left != nil) next = u.left;
				else if (u.right != nil) next = u.right;
				else {
					map.put(u,1);
					next = u.parent;       //add1
				}
			} else if (prev == u.left) {
				if (u.right != nil) next = u.right;
				else {
					map.put(u, 1+map.get(u.left));
					next = u.parent;       //get u.left +1
					 
				}
			} else {
				if(u.left == null){
					map.put(u, 1 + map.get(u.right));
				}
				else {
					map.put(u, 1 + map.get(u.left) + map.get(u.right));
				}
				next = u.parent;           //Check if left node exist (get right node and left node and add 1)
			}
			prev = u;
			u = next;
		}

		//2nd TRAVERSE(SET THE X AND Y COORDINATES)
		//Not sure if this is right 
		u = r;
		prev = nil;

		int x = 0; 
		int y = 0;
		int maxX = 0;
		
		u.position.x = x;	                                                          
		u.position.y = y;	

		while(u != nil){
 

			if(prev == u.parent){

				if(u.right == nil && u.left == nil){                                             //GOING BACK
					next = u.parent;
		
					if(next !=null ){
						x = next.position.x;
						y = next.position.y;
					}
				}

				else if(u.right == nil){
					next = u.left;
					x = maxX+1;
					maxX++;
				}

				else if(u.left == nil){
					next = u.right;
					x = maxX+1;
					maxX++;
				}

				else{
					if (map.get(u.right) < map.get(u.left)){   //GOING LEFT 
						next = u.right;
					}
					else{                                     //GOING RIGHT
						next = u.left; 		
					}
					y++;
				}
			}

			else if(prev == u.left){                              //LEFT
				if(u.right == null || map.get(u.left) > map.get(u.right) ){
					next = u.parent;
					if(next != null){
						x = next.position.x;
						y = next.position.y;
					}
				}

				else{
					next = u.right;
					x = maxX+1;
					maxX++;
				}
			}

			else if(prev == u.right){                                 //RIGHT
				if(u.left == null || map.get(u.right) >= map.get(u.left) ){
					next = u.parent;
					if(next != null){
						x = next.position.x;
						y = next.position.y;
					}
				}
				else{
					next = u.left;
					x = maxX+1;
					maxX++;
				}
			}
			
			else{
				next = u.parent;
				if(next != null){
					x = next.position.x;
					y = next.position.y;
				}
			}

			prev = u;
			u = next;

			if(u != null){
				u.position.x = x;	                                                          
				u.position.y = y;	
			}
			
		}
	}	
		
	protected void assignLevels() {
		assignLevels(r, 0);
	}

	
	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}
	
	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}
	
}
