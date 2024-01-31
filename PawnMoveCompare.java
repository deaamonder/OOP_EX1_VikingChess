import java.util.Comparator;

public class PawnMoveCompare implements Comparator<Pawn> {
    Pawn o1;
    Pawn o2;
    public PawnMoveCompare(){

    }

    @Override
    public int compare(Pawn o1, Pawn o2) {
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }

        return Integer.compare(o1.Summoves(),o2.Summoves());


    }
}