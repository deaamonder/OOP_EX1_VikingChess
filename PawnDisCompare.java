import java.util.Comparator;

public class PawnDisCompare implements Comparator<Pawn> {
    @Override
    public int compare(Pawn o1, Pawn o2) {
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }
        if(o1.Summoves()==o2.Summoves()){
            if (o1.GetNumber() == o2.GetNumber()) {
                if(o1.getOwner().islastwin()){
                    return 1;
                }
                return -1;
            }
            else{
                return Integer.compare(o1.GetNumber(),o2.GetNumber());
            }
        }
        return Integer.compare(o1.Summoves(),o2.Summoves());
}
}