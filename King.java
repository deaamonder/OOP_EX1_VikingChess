import java.util.ArrayList;

public class King extends ConcretePiece{
    Player Owner;
    int Number;
    int Movekilled;
    Position Pos;
    ArrayList<Position> Moveh= new ArrayList<>();
    public King(Position pos,Player owner){
        Pos=pos;
        Owner = owner;
    }

    @Override
    public Player getOwner(){
        return this.Owner;
    }
    @Override
    public String getType(){
        return "♔";
    }
    public void Moved(Position a){
        Moveh.add(a);
    }
    public void Setpos(Position a){
        this.Pos=a;
    }
    public Position Getpos(){
        return Pos;
    }
    public void setMovekilled(int a){
        this.Movekilled=a;
    }
    public void setNumber(int n){this.Number=n;}
    public int getNumber(){return this.Number;}
}
