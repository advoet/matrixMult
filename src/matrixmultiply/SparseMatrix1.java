/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiply;
/**
 *
 * @author advoet
 */
public class SparseMatrix1 implements intMatrix{
    private final int rows, cols;
    private final LinkedList<Integer> data;
    
    private class Node{
        int row, col, value;
    }
    
    public SparseMatrix1(){
        data = new LinkedList();
        rows = 0; cols = 0;
    }
    
    public SparseMatrix1(LinkedList<Integer> data){
        
    }
}
