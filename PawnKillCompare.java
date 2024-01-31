import java.util.Comparator;

public class PawnKillCompare implements Comparator<Pawn> {
    @Override
    public int compare(Pawn o1, Pawn o2) {
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }

        return Integer.compare(o1.getKills(),o2.getKills());
}
}