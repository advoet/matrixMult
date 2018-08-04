/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiply;

/**
 * For practice with interfaces, here is an interface for a matrix class
 * to be implemented with arrays, linked lists, and maybe a sparse matrix
 * @author advoet
 */
public interface intMatrix {
    //Should return the entri in row i and column j, indexed from 0
    abstract int getEntry(int i, int j);
    abstract intMatrix setEntry(int i, int j, int entry);
    abstract int numRows();
    abstract int numCols();
    abstract intMatrix transpose();
    abstract intMatrix plus(intMatrix B);
    abstract intMatrix leftMultiply(intMatrix B);
    abstract intMatrix rightMultiply(intMatrix B);
}
