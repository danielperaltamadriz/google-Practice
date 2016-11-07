/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlepractice;

import java.util.LinkedList;

/**
 *
 * @author Daniel
 */
public class GooglePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        tNode grandpa = new tNode(1);
        tNode pa = new tNode(2);
        tNode mom = new tNode(3);
        tNode granchild1 = new tNode(4);
        tNode granchild2 = new tNode(5);
        tNode granchild3 = new tNode(6);
        tNode granchild4 = new tNode(7);
        
        pa.setRightAndLeft(granchild1, granchild2);
        mom.setRightAndLeft(null, granchild3);
        
        grandpa.setRightAndLeft(pa, mom);  
        
        LinkedList<LinkedList<Integer>> l = getchildrenLists(grandpa);
        printLists(l);
    }
    
    
    public static LinkedList<LinkedList<Integer>> getchildrenLists(tNode node){
        LinkedList<Integer> list =  new LinkedList();
        LinkedList<LinkedList<Integer>> lists = null;
        if(node == null)
            return null;
        
        if(node.getLeft() == null && node.getRight() == null){
            list.add(node.getValue());
            lists = new LinkedList();
            lists.add(list);
            return lists;
        }
        LinkedList<LinkedList<Integer>> listsRight = null;
        LinkedList<LinkedList<Integer>> listsLeft = null;
        
        if(node.getRight() != null)
            listsRight = getchildrenLists(node.getRight());
        if(node.getLeft() != null)
            listsLeft = getchildrenLists(node.getLeft());
        
        lists = mergeLists(listsRight, listsLeft);        
        
        list.add(node.getValue());
        lists.push(list);
        return lists;
    }
    
    public static LinkedList<LinkedList<Integer>> mergeLists(LinkedList<LinkedList<Integer>> right, LinkedList<LinkedList<Integer>> left){
        LinkedList<LinkedList<Integer>> lists = null;
        if(left == null)
            return right;
        
        if(right == null)
            return left;
        
        lists = new LinkedList();
        int rLength = right.size();
        int lLength = left.size();
        int length = rLength;
        if(lLength > length)
            length = lLength;
        
        for(int i = 0; i < length; i++){
            if(rLength <= i)
                lists.add(mergeList(null, left.get(i)));
            else if(lLength <= i)
                lists.add(mergeList(right.get(i), null));
            else
                lists.add(mergeList(right.get(i), left.get(i)));
        }                        
        return lists;
    }
    
    public static LinkedList<Integer> mergeList(LinkedList<Integer> left, LinkedList<Integer> right){
        LinkedList<Integer> list = null;
        if(left == null)
            return right;
        
        if(right == null)
            return left;
        
        list = right;
        for(int i = 0; i < left.size(); i++)
            list.add(left.get(i));
            
        return list;
    }
    
    
    public static void printLists(LinkedList<LinkedList<Integer>> l){
        for(int i = 0; i < l.size(); i++){
            for(int j = 0; j < l.get(i).size(); j++){
                System.out.print(l.get(i).get(j) + "-");
            }            
            System.out.print("\n");
        }
    }
     
    public static int getRandom(){
        return (int)(Math.random() * 10);
    } 
}