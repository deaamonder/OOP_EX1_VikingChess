import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.*;

public class GameLogic implements PlayableLogic {

    ConcretePiece[][] board = new ConcretePiece[11][11];

    Player player1;
    Player player2;
    King kings;
    Pawn[] Attacker;
    Pawn[] Defender;
    ArrayList<Position> MoveH;
    int nummoves;

    public GameLogic() {
        Attacker = new Pawn[25];
        Defender = new Pawn[14];
        player1 = new ConcretePlayer(1);
        player2 = new ConcretePlayer(2);
        kings = new King(new Position(5, 5), player1);
        MoveH = new ArrayList<>();
        board = newGameboard();
    }

    public ConcretePiece[][] newGameboard() {
        /*int cnt = 1;
        int cnta = 1;
        board = new ConcretePiece[11][11];
        board[5][5]=kings;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 10) {
                    if (j > 2 && j < 8) {
                        if(i==10){
                            if(j==3){
                                cnt=8;
                            }
                            if(j==4){
                                cnt=10;
                            }
                            if(j==5){
                                cnt=14;
                            }
                            if(j==6){
                                cnt=16;
                            }
                            if(j==7){
                                cnt=18;
                            }
                        }
                        if(i==0){
                            if(j==3){
                                cnt=7;
                            }
                            if(j==4){
                                cnt=9;
                            }
                            if(j==5){
                                cnt=11;
                            }
                            if(j==6){
                                cnt=15;
                            }
                            if(j==7){
                                cnt=17;
                            }
                        }
                        Pawn a = new Pawn(new Position(j, i), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(j, i));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 1 || i == 9) {
                    if (j == 5) {
                        if (i == 1) {
                            cnt = 12;
                        }
                        if (i == 9) {
                            cnt = 13;
                        }
                        Pawn a = new Pawn(new Position(j, i), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(j, i));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 3 || i == 7) {
                    if (j == 5) {
                        if (i == 3) {
                            cnta = 5;
                        }
                        if (i == 7) {
                            cnta = 9;
                        }
                        Pawn a = new Pawn(new Position(j, i), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(j, i));
                        Defender[cnta] = a;
                    }
                    if (j == 0 || j == 10) {
                        if (i == 3) {
                            if (j == 0) {
                                cnt = 1;
                            }
                            if (j == 10) {
                                cnt = 20;
                            }
                        }
                        if (i == 7) {
                            if (j == 0) {
                                cnt = 0;
                            }
                            if (j == 10) {
                                cnt = 24;
                            }
                        }
                        Pawn a = new Pawn(new Position(j, i), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(j, i));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 4 || i == 6) {
                    if (j == 0 || j == 10) {
                        if (j == 10) {
                            if (i == 4) {
                                cnt = 21;
                            }
                            if (i == 6) {
                                cnt = 23;
                            }
                        }
                        if (j == 0) {
                            if (i == 4) {
                                cnt = 2;
                            }
                            if (i == 6) {
                                cnt = 4;
                            }
                        }
                        Pawn a = new Pawn(new Position(j, i), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(j, i));
                        Attacker[cnt] = a;
                    }
                    if (j > 3 && j < 7) {
                        if (j == 4) {
                            if (i == 4) {
                                cnta = 2;
                            }
                            if (i == 6) {
                                cnta = 4;
                            }
                        }
                        if (j == 5) {
                            if (i == 6) {
                                cnta = 2;
                            }
                            if (i == 6) {
                                cnta = 8;
                            }
                        }
                        if (j == 6) {
                            if (i == 4) {
                                cnta = 10;
                            }
                            if (i == 6) {
                                cnta = 12;
                            }
                        }
                        Pawn a = new Pawn(new Position(j, i), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(j, i));
                        Defender[cnta ] = a;
                    }
                }
                if (i == 5) {
                    if ( j < 2 || j > 8 ) {
                        if(j==1){
                            cnt=6;
                        }
                        if(j==0){
                            cnt=3;
                        }
                        if(j==9){
                            cnt=19;
                        }
                        if(j==10){
                            cnt=22;
                        }
                        Pawn a = new Pawn(new Position(j, i), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(j, i));
                        Attacker[cnt ] = a;
                    }
                    if (j > 2 && j < 8 && j != 5) {
                        if(j==3){
                            cnta=1;
                        }
                        if(j==4){
                            cnta=3;
                        }
                        if(j==6){
                            cnta=11;
                        }
                        if(j==7){
                            cnta=13;
                        }
                        Pawn a = new Pawn(new Position(j, i), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(j, i));
                        Defender[cnta] = a;
                    }
                }
            }
        }
        int cnt1=0;
        int cnt2=0;
        for(Pawn a : Attacker){
            if(a!=null){
                cnt1++;
            }
        }
        for(Pawn a : Defender){
            if(a!=null){
                cnt2++;
            }
        }
        Pawn[] newattacker = new Pawn[cnt1];
        Pawn[] newdefender = new Pawn[cnt2];
        cnt1=0;
        cnt2=0;
        for(Pawn a : Attacker){
            if(a!=null){
                newattacker[cnt1]=a;
                cnt1++;
            }
        }
        for(Pawn a : Defender){
            if(a!=null){
                newdefender[cnt2]=a;
                cnt2++;
            }
        }
        Attacker=newattacker;
        Defender=newdefender;
        return board;*/

        //*******************
        int cnt = 1;
        int cnta = 1;
        board = new ConcretePiece[11][11];
        board[5][5] = kings;
        kings.setNumber(7);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 10) {
                    if (j > 2 && j < 8) {
                        if (i == 10) {
                            if (j == 3) {
                                cnt = 8;
                            }
                            if (j == 4) {
                                cnt = 10;
                            }
                            if (j == 5) {
                                cnt = 14;
                            }
                            if (j == 6) {
                                cnt = 16;
                            }
                            if (j == 7) {
                                cnt = 18;
                            }
                        }
                        if (i == 0) {
                            if (j == 3) {
                                cnt = 7;
                            }
                            if (j == 4) {
                                cnt = 9;
                            }
                            if (j == 5) {
                                cnt = 11;
                            }
                            if (j == 6) {
                                cnt = 15;
                            }
                            if (j == 7) {
                                cnt = 17;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(i, j));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 1 || i == 9) {
                    if (j == 5) {
                        if (i == 1) {
                            cnt = 12;
                        }
                        if (i == 9) {
                            cnt = 13;
                        }
                        Pawn a = new Pawn(new Position(i, j), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(i, j));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 3 || i == 7) {
                    if (j == 5) {
                        if (i == 3) {
                            cnta = 5;
                        }
                        if (i == 7) {
                            cnta = 9;
                        }
                        Pawn a = new Pawn(new Position(i, j), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(i, j));
                        Defender[cnta] = a;
                    }
                    if (j == 0 || j == 10) {
                        if (i == 3) {
                            if (j == 0) {
                                cnt = 1;
                            }
                            if (j == 10) {
                                cnt = 20;
                            }
                        }
                        if (i == 7) {
                            if (j == 0) {
                                cnt = 5;
                            }
                            if (j == 10) {
                                cnt = 24;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(i, j));
                        Attacker[cnt] = a;
                    }
                }
                if (i == 4 || i == 6) {
                    if (j == 0 || j == 10) {
                        if (j == 10) {
                            if (i == 4) {
                                cnt = 21;
                            }
                            if (i == 6) {
                                cnt = 23;
                            }
                        }
                        if (j == 0) {
                            if (i == 4) {
                                cnt = 2;
                            }
                            if (i == 6) {
                                cnt = 4;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(i, j));
                        Attacker[cnt] = a;
                    }
                    if (j > 3 && j < 7) {
                        if (j == 4) {
                            if (i == 4) {
                                cnta = 2;
                            }
                            if (i == 6) {
                                cnta = 4;
                            }
                        }
                        if (j == 5) {
                            if (i == 6) {
                                cnta = 8;
                            }
                            if (i == 4) {
                                cnta = 6;
                            }
                        }
                        if (j == 6) {
                            if (i == 4) {
                                cnta = 10;
                            }
                            if (i == 6) {
                                cnta = 12;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(i, j));
                        Defender[cnta] = a;
                    }
                }
                if (i == 5) {
                    if (j < 2 || j > 8) {
                        if (j == 1) {
                            cnt = 6;
                        }
                        if (j == 0) {
                            cnt = 3;
                        }
                        if (j == 9) {
                            cnt = 19;
                        }
                        if (j == 10) {
                            cnt = 22;
                        }
                        Pawn a = new Pawn(new Position(i, j), player2);
                        this.board[j][i] = a;
                        a.setNumber(cnt);
                        a.moved(new Position(i, j));
                        Attacker[cnt] = a;
                    }
                    if (j > 2 && j < 8 && j != 5) {
                        if (j == 3) {
                            cnta = 1;
                        }
                        if (j == 4) {
                            cnta = 3;
                        }
                        if (j == 6) {
                            cnta = 11;
                        }
                        if (j == 7) {
                            cnta = 13;
                        }
                        Pawn a = new Pawn(new Position(i, j), player1);
                        this.board[j][i] = a;
                        a.setNumber(cnta);
                        a.moved(new Position(i, j));
                        Defender[cnta] = a;
                    }
                }
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (Pawn a : Attacker) {
            if (a != null) {
                cnt1++;
            }
        }
        for (Pawn a : Defender) {
            if (a != null) {
                cnt2++;
            }
        }
        Pawn[] newattacker = new Pawn[cnt1];
        Pawn[] newdefender = new Pawn[cnt2];
        cnt1 = 0;
        cnt2 = 0;
        for (Pawn a : Attacker) {
            if (a != null) {
                newattacker[cnt1] = a;
                cnt1++;
            }
        }
        for (Pawn a : Defender) {
            if (a != null) {
                newdefender[cnt2] = a;
                cnt2++;
            }
        }
        Attacker = newattacker;
        Defender = newdefender;
        return board;
    }

    @Override
    public boolean move(Position a, Position b) {
        if (a.Getcol() != b.Getcol()) {
            if (a.Getrow() != b.Getrow()) {
                return false;
            }
        }
        if (isSecondPlayerTurn()) {
            if (board[a.Getrow()][a.Getcol()].getOwner() == player1) {
                return false;
            }
        }
        if (!isSecondPlayerTurn()) {
            if (board[a.Getrow()][a.Getcol()].getOwner() == player2) {
                return false;
            }
        }

        if (a.Getrow() == b.Getrow() && b.Getcol() > a.Getcol()) {
            for (int i = a.Getcol() + 1; i < b.Getcol(); i++) {
                if (this.board[a.Getrow()][i] != null) {
                    return false;
                }
            }
        }
        if (a.Getrow() == b.Getrow() && b.Getcol() < a.Getcol()) {
            for (int i = b.Getcol(); i < a.Getcol(); i++) {
                if (this.board[a.Getrow()][i] != null) {
                    return false;
                }
            }
        }
        if (a.Getcol() == b.Getcol() && b.Getrow() > a.Getrow()) {
            for (int i = a.Getrow() + 1; i <= b.Getrow(); i++) {
                if (this.board[i][a.Getcol()] != null) {
                    return false;
                }
            }
        }
        if (a.Getcol() == b.Getcol() && b.Getrow() < a.Getrow()) {
            for (int i = b.Getrow(); i < a.Getrow(); i++) {
                if (this.board[i][a.Getcol()] != null) {
                    return false;
                }
            }
        }

        if (Objects.equals(getPieceAtPosition(a).getType(), "♔")) {
            kings.Setpos(b);
            board[a.Getrow()][a.Getcol()] = null;
            board[b.Getrow()][b.Getcol()] = kings;
            nummoves++;
            MoveH.add(a);
            MoveH.add(b);
            kings.Moved(b);
            return true;
        } else {
            boolean pl = board[a.Getrow()][a.Getcol()].getOwner().isPlayerOne();
            Pawn newp;
            if (pl) {
                newp = new Pawn(b, player1);
                for (Pawn pawn : Defender) {
                    if (pawn != null && pawn.getPos().Getcol() == a.Getcol() && pawn.getPos().Getrow() == a.Getrow()) {
                        pawn.setPos(b);
                    }
                }
            } else {
                newp = new Pawn(b, player2);
                for (Pawn pawn : Attacker) {
                    if (pawn != null && pawn.getPos().Getcol() == a.Getcol() && pawn.getPos().Getrow() == a.Getrow()) {
                        pawn.setPos(b);
                    }
                }
            }
            board[b.Getrow()][b.Getcol()] = newp;
            this.board[a.Getrow()][a.Getcol()] = null;
            MoveH.add(a);
            MoveH.add(b);
        }
        nummoves++;
        //checking for kills
        checkkills(b);
        if (isGameFinished()) {
            printAllData();
        }
        return true;
    }

    public void checkkills(Position b) {
        for (int i = 0; i < 11; i++)
            for (int j = 0; j < 11; j++) {
                if (j == 0 || j == 10 || i == 0 || i == 10) {
                    if (j == 0) {
                        if (board[j][i] != null && Objects.equals(board[j][i].getType(), "♔") && board[j + 1][i] != null && board[j][i + 1] != null && board[j][i - 1] != null) {
                            if (board[j + 1][i].getOwner() == player2 && board[j][i + 1].getOwner() == player2 && board[j][i - 1].getOwner() == player2) {
                                for (Pawn pawn : Attacker) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        pawn.killed();
                                        kings.setMovekilled(nummoves);
                                        board[j][i] = null;
                                        kings.Pos = null;
                                    }
                                }
                            }
                        }
                        if (board[j][i] != null && board[j + 1][i] != null && !Objects.equals(board[j][i].getType(), "♔") && !Objects.equals(board[j + 1][i].getType(), "♔")) {
                            if (board[j][i].getOwner() != board[j + 1][i].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == player2) {
                                    for (Pawn pawn : Attacker) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Defender) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == i && pawn1.getPos().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : Defender) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Attacker) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (j == 10) {
                        if (board[j][i] != null && Objects.equals(board[j][i].getType(), "♔")) {
                            if (board[j][i - 1] != null && board[j - 1][i] != null && board[j][i + 1] != null && board[j - 1][i].getOwner() == player2 && board[j][i + 1].getOwner() == player2 && board[j][i - 1].getOwner() == player2) {
                                for (Pawn pawn : Attacker) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        pawn.killed();
                                        board[j][i] = null;
                                        kings.setMovekilled(nummoves);
                                        kings.Pos = null;
                                    }
                                }
                            }
                        }
                        if (board[j][i] != null && board[j - 1][i] != null && !Objects.equals(board[j][i].getType(), "♔")) {
                            if (board[j][i].getOwner() != board[j - 1][i].getOwner() && !Objects.equals(board[j - 1][i].getType(), "♔")) {
                                if (getPieceAtPosition(b).getOwner() == player2) {
                                    for (Pawn pawn : Attacker) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Defender) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == i && pawn1.getPos().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : Defender) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Attacker) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i == 0) {
                        if (board[j][i] != null && Objects.equals(board[j][i].getType(), "♔")) {
                            if (board[j - 1][i] != null && board[j][i + 1] != null && board[j + 1][i] != null &&
                                    board[j - 1][i].getOwner() == player2 && board[j][i + 1].getOwner() == player2 && board[j + 1][i].getOwner() == player2) {
                                for (Pawn pawn : Attacker) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        board[j][i] = null;
                                        kings.Setpos(null);
                                        kings.setMovekilled(nummoves);
                                        board[j][i] = null;
                                    }
                                }
                            }
                        }
                        if (board[j][i] != null && board[j][i + 1] != null && !Objects.equals(board[j][i + 1].getType(), "♔")) {
                            if (board[j][i].getOwner() != board[j][i + 1].getOwner() && !Objects.equals(board[j][i].getType(), "♔")) {
                                if (getPieceAtPosition(b).getOwner() == player2) {
                                    for (Pawn pawn : Attacker) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn2 : Defender) {
                                                if (pawn2 != null && pawn2.getPos().Getrow() == i && pawn2.getPos().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : Defender) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Attacker) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i == 10) {
                        if (board[j][i] != null && Objects.equals(board[j][i].getType(), "♔") && board[j - 1][i] != null && board[j][i] != null) {
                            if (board[j - 1][i].getOwner() == player2 && board[j][i - 1].getOwner() == player2 && board[j + 1][i].getOwner() == player2) {
                                for (Pawn pawn : Attacker) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        kings.Setpos(null);
                                        kings.setMovekilled(nummoves);
                                        board[j][i] = null;
                                    }
                                }
                            }
                        } else {
                            if (board[j][i] != null && !Objects.equals(board[j][i].getType(), "♔") && board[j][i - 1] != null && !Objects.equals(board[j][i - 1].getType(), "♔")
                                    && board[j][i].getOwner() != board[j][i - 1].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == player1) {
                                    for (Pawn pawn : Defender) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Attacker) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.Movekilled = nummoves;
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : Attacker) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Defender) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == i && pawn1.getPos().Getcol() == j && pawn1.getPos().Getrow() == pawn.getPos().Getrow()) {
                                                    pawn.killed();
                                                    pawn1.Movekilled = nummoves;
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (board[j][i] != null && board[j][i].getType().equals("♔")) {
                        if (board[j][i - 1] != null && board[j - 1][i] != null && board[j + 1][i] != null && board[j][i + 1] != null &&
                                board[j - 1][i].getOwner() == player2 && board[j + 1][i].getOwner() == player2 && board[j][i + 1].getOwner() == player2 && board[j][i - 1].getOwner() == player2) {
                            for (Pawn a : Attacker) {
                                if (a != null && a.getPos().Getrow() == b.Getrow() && a.getPos().Getcol() == b.Getcol()) {
                                    kings.Setpos(null);
                                    kings.setMovekilled(nummoves);
                                    board[j][i] = null;
                                }
                            }
                        }
                    }
                    if (board[j][i] != null && board[j][i - 1] != null && board[j][i + 1] != null && !Objects.equals(board[j][i - 1].getType(), "♔")
                            && !Objects.equals(board[j][i + 1].getType(), "♔") && !Objects.equals(board[j][i].getType(), "♔")) {
                        if (board[j][i].getOwner() != board[j][i - 1].getOwner() && board[j][i].getOwner() != board[j][i + 1].getOwner()) {
                            if (board[j][i].getOwner() == player1) {
                                for (Pawn pawn : Attacker) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        for (Pawn pawn1 : Defender) {
                                            if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                pawn.killed();
                                                pawn1.setMovekilled(nummoves);
                                                board[j][i] = null;
                                            }
                                        }
                                    }
                                }
                            } else {
                                for (Pawn pawn : Defender) {
                                    if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                        for (Pawn pawn1 : Attacker) {
                                            if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                pawn.killed();
                                                pawn1.setMovekilled(nummoves);
                                                board[j][i] = null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (board[j][i] != null && board[j - 1][i] != null && !Objects.equals(board[j][i].getType(), "♔") && board[j + 1][i] != null
                                && !Objects.equals(board[j - 1][i].getType(), "♔") && !Objects.equals(board[j + 1][i].getType(), "♔")) {
                            if (board[j][i].getOwner() != board[j - 1][i].getOwner() && board[j][i].getOwner() != board[j + 1][i].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == player2) {
                                    for (Pawn pawn : Attacker) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Defender) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : Defender) {
                                        if (pawn != null && pawn.getPos().Getcol() == b.Getcol() && pawn.getPos().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : Attacker) {
                                                if (pawn1 != null && pawn1.getPos().Getrow() == j && pawn1.getPos().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(nummoves);
                                                    board[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    @Override
    public ConcretePiece getPieceAtPosition(Position position) {
        return this.board[position.Getrow()][position.Getcol()];
    }

    public Player getFirstPlayer() {
        return this.player1;
    }

    public Player getSecondPlayer() {
        return this.player2;
    }


    public boolean isGameFinished() {
        Position kingp = kings.Getpos();
        if (kingp == null) {
            player2.won();
            player2.setlastwin();
            return true;
        }
        if (kingp.Getrow() == 10 && (kingp.Getcol() == 0 || kingp.Getcol() == 10)) {
            player1.won();
            player1.setlastwin();
            return true;
        }
        if (kingp.Getrow() == 0 && (kingp.Getcol() == 0 || kingp.Getcol() == 10)) {
            player1.won();
            player1.setlastwin();
            return true;
        }
        int cnt = 0;
        for (Pawn a : Attacker) {
            if (a.Movekilled == 0) {
                return false;
            }
            cnt++;
        }
        if (cnt == 24) {
            return true;
        }
        cnt = 0;
        for (Pawn a : Defender) {
            if (a.Movekilled == 0) {
                return false;
            }
            cnt++;
        }
        if (cnt == 13) {
            return true;
        }
        return false;
    }


    public boolean isSecondPlayerTurn() {
        return this.nummoves % 2 == 0;
    }

    @Override
    public void reset() {
        Attacker = new Pawn[25];
        Defender = new Pawn[14];
        new GameLogic();
        board = newGameboard();
        nummoves = 0;
    }

    @Override
    public void undoLastMove() {
        if (nummoves > 0) {
            Position lastPos = MoveH.get(MoveH.size() - 1);
            Position beforeLastPos = MoveH.get(MoveH.size() - 2);
            Pawn newPawn;
            Pawn retPawn;
            for (int i = 0; i < 2; i++) {
                for (Pawn pawn : Attacker) {
                    if (pawn != null && pawn.Movekilled == nummoves) {
                        retPawn = pawn;
                        board[pawn.getPos().Getrow()][pawn.getPos().Getcol()] = retPawn;
                        pawn.setMovekilled(0);
                    }
                }
                for (Pawn pawn : Defender) {
                    if (pawn != null && pawn.Movekilled == nummoves) {
                        retPawn = pawn;
                        board[pawn.getPos().Getrow()][pawn.getPos().Getcol()] = retPawn;
                        pawn.setMovekilled(0);
                    }
                }
            }
            if (isSecondPlayerTurn()) {
                newPawn = new Pawn(beforeLastPos, player1);
            } else {
                newPawn = new Pawn(beforeLastPos, player2);
            }
            board[beforeLastPos.Getrow()][beforeLastPos.Getcol()] = newPawn;
            board[lastPos.Getrow()][lastPos.Getcol()] = null;
            MoveH.remove(MoveH.size() - 1);
            MoveH.remove(MoveH.size() - 1);
            nummoves--;
        }
    }

    @Override
    public int getBoardSize() {
        return board[0].length;
    }

    private void printAllData() {
        printPieceData();
        line();
        printEatsData();
        line();
        printSumMovesData();
        line();
        printPositionData();
        line();
    }

    private void printPieceData() {
        Comparator<Pawn> pawnComparator = ((o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (o1.moveH.size() > o2.moveH.size()) {
                return 1;
            }
            if (o1.moveH.size() < o2.moveH.size()) {
                return -1;
            } else {
                if (o1.GetNumber() > o2.GetNumber()) {
                    return 1;
                }
                return -1;
            }
        }
        );
        Pawn kingdata = new Pawn(new Position(5, 5), player1);
        int cnt = 1;
        for (Position a : kings.Moveh) {
            if (cnt == 1) {
                cnt = 0;
                kingdata.moved(new Position(5, 5));
                continue;
            }
            kingdata.moved(a);
        }
        kingdata.setNumber(7);
        Pawn[] newDef = new Pawn[Defender.length + 1];
        for (int i = 0; i <= Defender.length; i++) {
            if (i == Defender.length) {
                newDef[i] = kingdata;
                break;
            }
            if (Defender[i] != null) {
                newDef[i] = Defender[i];
            }


        }
        Arrays.sort(Attacker, pawnComparator);
        Arrays.sort(newDef, pawnComparator);

        Pawn[] winner;
        Pawn[] loser;

        if (isSecondPlayerTurn()) {
            winner = newDef;
            loser = Attacker;
            for (Pawn pawn : winner) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    if (pawn.GetNumber() == 7) {
                        System.out.print("K" + pawn.GetNumber() + ": [");
                    } else {
                        System.out.print("D" + pawn.GetNumber() + ": [");
                    }
                    for (int i = 0; i < pawn.moveH.size(); i++) {
                        if (i != pawn.moveH.size() - 1) {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
            for (Pawn pawn : loser) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    System.out.print("A" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.moveH.size(); i++) {
                        if (i != pawn.moveH.size() - 1) {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
        } else {
            winner = Attacker;
            loser = newDef;
            for (Pawn pawn : winner) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    System.out.print("A" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.moveH.size(); i++) {
                        if (i != pawn.moveH.size() - 1) {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
            for (Pawn pawn : loser) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    if (pawn.number == 7)
                        System.out.print("K" + pawn.GetNumber() + ": [");
                    else
                        System.out.print("D" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.moveH.size(); i++) {
                        if (i != pawn.moveH.size() - 1) {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.moveH.get(i).Getcol() + ", " + pawn.moveH.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
        }
    }


    private void printEatsData() {
        Comparator<Pawn> killsCompare = (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (o2.getKills() > o1.getKills()) {
                return 1;
            }
            if (o1.getKills() > o2.getKills()) {
                return -1;
            }
            return 0;
        };

        Arrays.sort(Attacker, killsCompare);
        Arrays.sort(Defender, killsCompare);

        Pawn[] winner;
        Pawn[] loser;

        if (isSecondPlayerTurn()) {
            winner = Defender;
            loser = Attacker;
        } else {
            winner = Attacker;
            loser = Defender;
        }

        for (Pawn pawn : winner) {
            if (pawn != null && pawn.getKills() >= 1) {
                System.out.println("A" + pawn.GetNumber() + ": " + pawn.getKills() + " kills");
            }
        }
        for (Pawn pawn : loser) {
            if (pawn != null && pawn.getKills() >= 1) {
                System.out.println("D" + pawn.GetNumber() + ": " + pawn.getKills() + " kills");
            }
        }
    }

    private void printSumMovesData() {
        Comparator<Pawn> disCompare = (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (o1.Summoves() == o2.Summoves()) {
                if (o1.GetNumber() == o2.GetNumber()) {
                    if (o1.getOwner().islastwin()) {
                        return -1;
                    }
                    return 1;
                } else {
                    return Integer.compare(o1.GetNumber(), o2.GetNumber());
                }
            }
            return Integer.compare(o2.Summoves(), o1.Summoves());
        };
        Pawn kingdata = new Pawn(new Position(5, 5), player1);
        int cnt = 1;
        for (Position a : kings.Moveh) {
            if (cnt == 1) {
                cnt = 0;
                kingdata.moved(new Position(5, 5));
                continue;
            }
            kingdata.moved(a);
        }
        kingdata.setNumber(7);

        Pawn[] newDef = new Pawn[Defender.length + 1];
        for (int i = 0; i <= Defender.length; i++) {
            if (i == Defender.length) {
                newDef[i] = kingdata;
                continue;
            }
            if (Defender[i] != null) {
                newDef[i] = Defender[i];

            }
        }
        Pawn[] Allpawn = new Pawn[newDef.length + Attacker.length];
        int cntpawn = 0;
        for (Pawn a : Attacker) {
            Allpawn[cntpawn++] = a;
        }
        for (Pawn a : newDef) {
            Allpawn[cntpawn++] = a;
        }
        Arrays.sort(Allpawn, disCompare);
        for (Pawn pawn : Allpawn) {
            if (pawn != null && pawn.Summoves() >= 1) {
                if (pawn.getOwner() == getSecondPlayer())
                    System.out.println("A" + pawn.GetNumber() + ": " + pawn.Summoves() + " squares");
                if (pawn.getOwner() == getFirstPlayer())
                    if (pawn.GetNumber() == 7)
                        System.out.println(("K" + pawn.GetNumber() + ": " + pawn.Summoves() + " squares"));
                    else
                        System.out.println(("D" + pawn.GetNumber() + ": " + pawn.Summoves() + " squares"));
            }
        }

    }

    private void line() {
        for (int i = 0; i < 75; i++) {
            System.out.print("*");
            if (i == 74) {
                System.out.println("");
            }
        }
    }

    private void printPositionData() {
        ArrayList<Position> finalsteps = new ArrayList<>();
        int[][] howManySteps = new int[11][11];
        boolean[][] isStepOver = new boolean[11][11];
        for (Position a : kings.Moveh) {
            for (int j = 0; j < isStepOver.length; j++) {
                for (int k = 0; k < isStepOver.length; k++) {
                    isStepOver[j][k] = false;
                }
            }
            if (!isStepOver[a.Getrow()][a.Getcol()]) {
                howManySteps[a.Getrow()][a.Getcol()]++;
                isStepOver[a.Getrow()][a.Getcol()] = true;
            }
        }
        for (Pawn pawn : Attacker) {
            if (pawn == null) {
                continue;
            }
            for (int j = 0; j < isStepOver.length; j++) {
                for (int k = 0; k < isStepOver.length; k++) {
                    isStepOver[j][k] = false;
                }
            }
            for (int i = 0; i < pawn.moveH.size(); i++) {
                if (!isStepOver[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()]) {
                    howManySteps[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()]++;
                    isStepOver[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()] = true;
                }
            }
        }
        for (Pawn pawn : Defender) {
            if (pawn == null) {
                continue;
            }
            for (int j = 0; j < isStepOver.length; j++) {
                for (int k = 0; k < isStepOver.length; k++) {
                    isStepOver[j][k] = false;
                }
            }
            for (int i = 0; i < pawn.moveH.size(); i++) {
                if (!isStepOver[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()]) {
                    howManySteps[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()]++;
                    isStepOver[pawn.moveH.get(i).Getrow()][pawn.moveH.get(i).Getcol()] = true;
                }
            }
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (howManySteps[i][j] > 1) {
                    Position a = new Position(j, i, howManySteps[i][j]);
                    finalsteps.add(a);
                }
            }
        }
        Comparator<Position> positionComparator = (p1, p2) -> {
            if (p1.Getsteps() > p2.Getsteps()) return -1;
            if (p1.Getsteps() < p2.Getsteps()) return 1;
            else {
                if (p1.Getrow() > p2.Getrow())
                    return 1;
                else if (p1.Getrow() == p2.Getrow())
                    if (p1.Getcol() > p2.Getcol())
                        return 1;

            }
            return 0;
        };

        finalsteps.sort(positionComparator);

        for (int i = 0; i < finalsteps.size(); i++) {
            System.out.println("(" + finalsteps.get(i).Getcol() + ", " + finalsteps.get(i).Getrow() + ")" + finalsteps.get(i).Getsteps() + " pieces");
        }
    }

}