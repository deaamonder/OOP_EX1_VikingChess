import java.util.ArrayList;

public class Pawn extends ConcretePiece{
    Player Owner;
    ArrayList<Position> pawnMoveHistory =new ArrayList<Position>();
    Position pawnPosition;
    int numOfKills;
    int pawnNumber;
    int Movekilled;
    public Pawn(Position pawnPosition, Player owner){
        this.pawnPosition = pawnPosition;
        Owner = owner;
    }
    public Pawn(Position pawnPosition, Player owner, int movekilled){
        this.pawnPosition = pawnPosition;
        Owner = owner;
        Movekilled=movekilled;
    }
    public Position getPawnPosition(){
        return this.pawnPosition;
    }
    public void setPawnPosition(Position newp){
        this.pawnMoveHistory.add(newp);
        this.pawnPosition =newp;
    }
    @Override
    public Player getOwner(){
        return this.Owner;
    }
    public void killed(){
        this.numOfKills++;
    }
    public void moved(Position a){
        this.pawnMoveHistory.add(new Position(a.Getcol(),a.Getrow()));
    }
    @Override
    public String getType(){
        if(getOwner().isPlayerOne()){
            return "♙";
        }
        else{
            return "♟";
        }
    }
    public void setPawnNumber(int a){
        this.pawnNumber =a;
    }
    public void setMovekilled(int a){
        this.Movekilled=a;
    }
    public int Summoves(){
        int sum=0;
        if(this.pawnMoveHistory.size()>1){
        for(int i = 0; i< pawnMoveHistory.size()-1; i++){
            int dist=0;
            dist=Math.abs(pawnMoveHistory.get(i).Getrow()- pawnMoveHistory.get(i+1).Getrow())+Math.abs(pawnMoveHistory.get(i).Getcol()- pawnMoveHistory.get(i+1).Getcol());
            sum+=dist;
        }}
        return sum;
    }
    public int GetNumber(){
        return this.pawnNumber;
    }
    public boolean islastwin(){
        return this.Owner.islastwin();
    }
    public int getNumOfKills(){
        return this.numOfKills;
    }

}
