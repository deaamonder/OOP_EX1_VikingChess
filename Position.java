public class Position{
    private int Colp,Rowp;
    int steps;
    public Position(int a,int b){
        Rowp=b;
        Colp=a;
    }
    public Position(int a,int b,int c){
        Rowp=b;
        Colp=a;
        steps=c;
    }
    int Getrow(){
        return Rowp;
    }
    int Getcol(){
        return Colp;
    }
    int Getsteps(){return steps;}

}
