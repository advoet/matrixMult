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
public class ArrayMatrix implements intMatrix{
    private final int rows, cols;
    private final int[][] mat;
    
    public ArrayMatrix(){
        mat = new int[0][0];
        rows=0; cols=0;
    }
    //Assuming I will always be passed a rectangular array
    public ArrayMatrix(int[][] data){
        mat = data;
        rows = mat.length;
        cols = mat[0].length;
    }
    @Override
    public int getEntry(int i, int j){ return mat[i][j]; }
    @Override
    public ArrayMatrix setEntry(int i, int j, int entry){
        mat[i][j]=entry;
        return this;
    }
    @Override
    public int numRows(){ return rows; }
    @Override
    public int numCols(){ return cols; }
    @Override
    public ArrayMatrix transpose(){
        int[][] tp = new int[this.numCols()][this.numRows()];
        for (int i = 0; i < this.numCols(); i++){
            for (int j = 0; j < this.numRows(); j++){
                tp[j][i] = this.getEntry(i,j);
            }
        }
        return new ArrayMatrix(tp);
    }
    @Override
    public intMatrix plus(intMatrix B) {
        if (this.numRows()!= B.numRows() || this.numCols()!= B.numCols()){
            System.out.println("The matrices are not the same size");
            return this;
        }
        int[][] sum = new int[numRows()][numCols()];
        for (int i = 0; i < numRows(); i ++){
            for (int j = 0; j < numCols(); j++){
                sum[i][j] = this.getEntry(i, j) + B.getEntry(i, j);
            }
        }
        return new ArrayMatrix(sum);
    }
    @Override
    // returns the matrix (this)*B
    public intMatrix leftMultiply(intMatrix B) {
        assert this.numCols() == B.numRows();
        int[][] prod = new int[this.numRows()][B.numCols()];
        int sum = 0;
        for (int i = 0; i<this.numRows(); i++){
            for (int j = 0; j<this.numCols(); j++){
                for (int k = 0; k<B.numRows(); k++){
                    sum += this.getEntry(i,k)*B.getEntry(k, j);
                }
                prod[i][j]=sum;
                sum=0;
            }
        }
        return new ArrayMatrix(prod);
    }
    @Override
    // returns the matrix B*(this)
    public intMatrix rightMultiply(intMatrix B) {
        return B.leftMultiply(this);
    }
}
