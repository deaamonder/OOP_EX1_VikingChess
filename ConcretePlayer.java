public class ConcretePlayer implements Player{
    int id;
    int numwins;
    boolean islastwin=false;
    public ConcretePlayer(int a){
        id = a;

    }
   @Override
    public void won(){
        this.numwins++;
    }
    @Override
    public void setlastwin(){
        this.islastwin=true;
    }
    @Override
    public boolean islastwin(){
        return islastwin;
    }
    @Override
    public boolean isPlayerOne() {
        if(id==1){
            return true;
        }
        else return false;
    }

    @Override
    public int getWins() {
        return numwins;
    }
}
