public class Position{
    private int col, row;
    int steps;
    public Position(int a,int b){
        row =b;
        col =a;
    }
    public Position(int a,int b,int c){
        row =b;
        col =a;
        steps=c;
    }
    int Getrow(){
        return row;
    }
    int Getcol(){
        return col;
    }
    int Getsteps(){return steps;}

}
