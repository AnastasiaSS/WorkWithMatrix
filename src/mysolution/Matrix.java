package mysolution;

/**
 * Created by Настя on 04.07.2017.
 */
public class Matrix {
    private float[][] matrix;
    private int row;
    private int column;
    public Matrix(){
    }
    public Matrix(float[][] matrix){
        if(matrix!=null) {
            this.matrix = matrix.clone();
            this.row = matrix.length;
            this.column = matrix[0].length;
        }
    }
    public Matrix plus(Matrix matrix){
        if(this!=null && matrix!=null){
            if(this.row==matrix.row && this.column==matrix.column){
                float[][] result=new float[this.row][this.column];
                for (int i=0; i<this.row; i++){
                    for (int j=0; j<this.column; j++){
                        result[i][j]=this.matrix[i][j]+matrix.matrix[i][j];
                    }
                }
                return new Matrix(result);
            }
        }
        return null;
    }
    public Matrix multiply(Matrix matrix){
        if(this!=null && matrix!=null){
            if(this.column==matrix.row){
                float[][] result=new float[this.row][matrix.column];
                for (int i=0; i<this.row; i++){
                    for (int j=0; j<matrix.column; j++){
                        for (int k=0; k<matrix.row; k++) {
                            result[i][j]+=this.matrix[i][k]*matrix.matrix[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        return null;
    }
    public Matrix transpose(){
        if (this!=null){
            float[][] result=new float[this.column][this.row];
            for (int i=0; i<this.row; i++){
                for (int j=0; j<this.column; j++){
                    result[j][i]=this.matrix[i][j];
                }
            }
            return new Matrix(result);
        }
        return null;
    }
    public void print(){
        if(this!=null){
            for (float[] row : this.matrix) {
                for (float cell : row) {
                    System.out.format("%-8.3f  ", cell);
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        float[][] af=new float[][]{{-1.0f,-2.0f, 1},{5,9,-8}};
        Matrix a=new Matrix(af);
        float[][] bf=new float[][]{{10.0f,-25.0f, 98},{3,0,-14}};
        Matrix b=new Matrix(bf);
        Matrix pl=a.plus(b);
        pl.print();

        float[][] afl=new float[][]{{-1.0f,2.0f, -3,0},{5,4,-2,1},{-8,11,-10,-5}};
        Matrix al=new Matrix(afl);
        float[][] bfl=new float[][]{{-9,3},{6,20},{7,0},{12,-4}};
        Matrix bl=new Matrix(bfl);
        Matrix mult=al.multiply(bl);
        mult.print();
        
        Matrix tran=bl.transpose();
        tran.print();
    }
}
