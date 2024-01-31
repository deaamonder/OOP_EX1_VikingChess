import java.util.ArrayList;

public class Pawn extends ConcretePiece{
    Player Owner;
    ArrayList<Position> moveH=new ArrayList<Position>();
    Position Pos;
    int kills;
    int number;
    int Movekilled;
    public Pawn(Position pos,Player owner){
        Pos=pos;
        Owner = owner;
    }
    public Pawn(Position pos,Player owner,int movekilled){
        Pos=pos;
        Owner = owner;
        Movekilled=movekilled;
    }
    public Position getPos(){
        return this.Pos;
    }
    public void setPos(Position newp){
        this.moveH.add(newp);
        this.Pos=newp;
    }
    @Override
    public Player getOwner(){
        return this.Owner;
    }
    public void killed(){
        this.kills++;
    }
    public void moved(Position a){
        this.moveH.add(new Position(a.Getcol(),a.Getrow()));
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
    public void setNumber(int a){
        this.number=a;
    }
    public void setMovekilled(int a){
        this.Movekilled=a;
    }
    public int Summoves(){
        int sum=0;
        if(this.moveH.size()>1){
        for(int i=0;i<moveH.size()-1;i++){
            int dist=0;
            dist=Math.abs(moveH.get(i).Getrow()-moveH.get(i+1).Getrow())+Math.abs(moveH.get(i).Getcol()-moveH.get(i+1).Getcol());
            sum+=dist;
        }}
        return sum;
    }
    public int GetNumber(){
        return this.number;
    }
    public boolean islastwin(){
        return this.Owner.islastwin();
    }
    public int getKills(){
        return this.kills;
    }

}
