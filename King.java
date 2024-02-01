import java.util.ArrayList;

public class King extends ConcretePiece {
    Player Owner;
    int Number;
    int Movekilled;
    Position kingPosition;
    ArrayList<Position> KingMoveHistory = new ArrayList<>();

    public King(Position pos, Player owner) {
        kingPosition = pos;
        Owner = owner;
        KingMoveHistory.add(pos);
    }

    @Override
    public Player getOwner() {
        return this.Owner;
    }

    @Override
    public String getType() {
        return "♔";
    }

    public void Moved(Position a) {
        KingMoveHistory.add(a);
    }

    public void Setpos(Position a) {
        this.kingPosition = a;
    }

    public Position Getpos() {
        return kingPosition;
    }

    public void setMovekilled(int a) {
        this.Movekilled = a;
    }

    public void setNumber(int n) {
        this.Number = n;
    }
}