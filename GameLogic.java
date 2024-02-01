import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class GameLogic implements PlayableLogic {

    private ConcretePiece[][] gameBoard = new ConcretePiece[11][11];

    private Player P1;
    private Player P2;
    private King theKing;
    private Pawn[] attacker;
    private Pawn[] defender;
    private ArrayList<Position> moveHistory;
    private int numOfMoves;

    public GameLogic() {
        attacker = new Pawn[25];
        defender = new Pawn[14];
        P1 = new ConcretePlayer(1);
        P2 = new ConcretePlayer(2);
        theKing = new King(new Position(5, 5), P1);
        moveHistory = new ArrayList<>();
        gameBoard = fillGameBoard();
    }

    public ConcretePiece[][] fillGameBoard() {
        int countA = 1;
        int countB = 1;
        gameBoard = new ConcretePiece[11][11];
        gameBoard[5][5] = theKing;
        theKing.setNumber(7);
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 10) {
                    if (j > 2 && j < 8) {
                        if (i == 10) {
                            if (j == 3) {
                                countA = 8;
                            }
                            if (j == 4) {
                                countA = 10;
                            }
                            if (j == 5) {
                                countA = 14;
                            }
                            if (j == 6) {
                                countA = 16;
                            }
                            if (j == 7) {
                                countA = 18;
                            }
                        }
                        if (i == 0) {
                            if (j == 3) {
                                countA = 7;
                            }
                            if (j == 4) {
                                countA = 9;
                            }
                            if (j == 5) {
                                countA = 11;
                            }
                            if (j == 6) {
                                countA = 15;
                            }
                            if (j == 7) {
                                countA = 17;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), P2);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countA);
                        a.moved(new Position(i, j));
                        attacker[countA] = a;
                    }
                }
                if (i == 1 || i == 9) {
                    if (j == 5) {
                        if (i == 1) {
                            countA = 12;
                        }
                        if (i == 9) {
                            countA = 13;
                        }
                        Pawn a = new Pawn(new Position(i, j), P2);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countA);
                        a.moved(new Position(i, j));
                        attacker[countA] = a;
                    }
                }
                if (i == 3 || i == 7) {
                    if (j == 5) {
                        if (i == 3) {
                            countB = 5;
                        }
                        if (i == 7) {
                            countB = 9;
                        }
                        Pawn a = new Pawn(new Position(i, j), P1);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countB);
                        a.moved(new Position(i, j));
                        defender[countB] = a;
                    }
                    if (j == 0 || j == 10) {
                        if (i == 3) {
                            if (j == 0) {
                                countA = 1;
                            }
                            if (j == 10) {
                                countA = 20;
                            }
                        }
                        if (i == 7) {
                            if (j == 0) {
                                countA = 5;
                            }
                            if (j == 10) {
                                countA = 24;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), P2);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countA);
                        a.moved(new Position(i, j));
                        attacker[countA] = a;
                    }
                }
                if (i == 4 || i == 6) {
                    if (j == 0 || j == 10) {
                        if (j == 10) {
                            if (i == 4) {
                                countA = 21;
                            }
                            if (i == 6) {
                                countA = 23;
                            }
                        }
                        if (j == 0) {
                            if (i == 4) {
                                countA = 2;
                            }
                            if (i == 6) {
                                countA = 4;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), P2);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countA);
                        a.moved(new Position(i, j));
                        attacker[countA] = a;
                    }
                    if (j > 3 && j < 7) {
                        if (j == 4) {
                            if (i == 4) {
                                countB = 2;
                            }
                            if (i == 6) {
                                countB = 4;
                            }
                        }
                        if (j == 5) {
                            if (i == 6) {
                                countB = 8;
                            }
                            if (i == 4) {
                                countB = 6;
                            }
                        }
                        if (j == 6) {
                            if (i == 4) {
                                countB = 10;
                            }
                            if (i == 6) {
                                countB = 12;
                            }
                        }
                        Pawn a = new Pawn(new Position(i, j), P1);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countB);
                        a.moved(new Position(i, j));
                        defender[countB] = a;
                    }
                }
                if (i == 5) {
                    if (j < 2 || j > 8) {
                        if (j == 1) {
                            countA = 6;
                        }
                        if (j == 0) {
                            countA = 3;
                        }
                        if (j == 9) {
                            countA = 19;
                        }
                        if (j == 10) {
                            countA = 22;
                        }
                        Pawn a = new Pawn(new Position(i, j), P2);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countA);
                        a.moved(new Position(i, j));
                        attacker[countA] = a;
                    }
                    if (j > 2 && j < 8 && j != 5) {
                        if (j == 3) {
                            countB = 1;
                        }
                        if (j == 4) {
                            countB = 3;
                        }
                        if (j == 6) {
                            countB = 11;
                        }
                        if (j == 7) {
                            countB = 13;
                        }
                        Pawn a = new Pawn(new Position(i, j), P1);
                        this.gameBoard[j][i] = a;
                        a.setPawnNumber(countB);
                        a.moved(new Position(i, j));
                        defender[countB] = a;
                    }
                }
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (Pawn a : attacker) {
            if (a != null) {
                cnt1++;
            }
        }
        for (Pawn a : defender) {
            if (a != null) {
                cnt2++;
            }
        }
        Pawn[] newattacker = new Pawn[cnt1];
        Pawn[] newdefender = new Pawn[cnt2];
        cnt1 = 0;
        cnt2 = 0;
        for (Pawn a : attacker) {
            if (a != null) {
                newattacker[cnt1] = a;
                cnt1++;
            }
        }
        for (Pawn a : defender) {
            if (a != null) {
                newdefender[cnt2] = a;
                cnt2++;
            }
        }
        attacker = newattacker;
        defender = newdefender;
        return gameBoard;
    }

    @Override
    public boolean move(Position a, Position b) {
        if (a.Getcol() != b.Getcol()) {
            if (a.Getrow() != b.Getrow()) {
                return false;
            }
        }
        if (isSecondPlayerTurn()) {
            if (gameBoard[a.Getrow()][a.Getcol()].getOwner() == P1) {
                return false;
            }
        }
        if (!isSecondPlayerTurn()) {
            if (gameBoard[a.Getrow()][a.Getcol()].getOwner() == P2) {
                return false;
            }
        }

        if (a.Getrow() == b.Getrow() && b.Getcol() > a.Getcol()) {
            for (int i = a.Getcol() + 1; i < b.Getcol(); i++) {
                if (this.gameBoard[a.Getrow()][i] != null) {
                    return false;
                }
            }
        }
        if (a.Getrow() == b.Getrow() && b.Getcol() < a.Getcol()) {
            for (int i = b.Getcol(); i < a.Getcol(); i++) {
                if (this.gameBoard[a.Getrow()][i] != null) {
                    return false;
                }
            }
        }
        if (a.Getcol() == b.Getcol() && b.Getrow() > a.Getrow()) {
            for (int i = a.Getrow() + 1; i <= b.Getrow(); i++) {
                if (this.gameBoard[i][a.Getcol()] != null) {
                    return false;
                }
            }
        }
        if (a.Getcol() == b.Getcol() && b.Getrow() < a.Getrow()) {
            for (int i = b.Getrow(); i < a.Getrow(); i++) {
                if (this.gameBoard[i][a.Getcol()] != null) {
                    return false;
                }
            }
        }

        if (Objects.equals(getPieceAtPosition(a).getType(), "♔")) {
            theKing.Setpos(b);
            gameBoard[a.Getrow()][a.Getcol()] = null;
            gameBoard[b.Getrow()][b.Getcol()] = theKing;
            numOfMoves++;
            moveHistory.add(a);
            moveHistory.add(b);
            theKing.Moved(b);
            return true;
        } else {
            boolean pl = gameBoard[a.Getrow()][a.Getcol()].getOwner().isPlayerOne();
            Pawn newp;
            if (pl) {
                newp = new Pawn(b, P1);
                for (Pawn pawn : defender) {
                    if (pawn != null && pawn.getPawnPosition().Getcol() == a.Getcol() && pawn.getPawnPosition().Getrow() == a.Getrow()) {
                        pawn.setPawnPosition(b);
                    }
                }
            } else {
                newp = new Pawn(b, P2);
                for (Pawn pawn : attacker) {
                    if (pawn != null && pawn.getPawnPosition().Getcol() == a.Getcol() && pawn.getPawnPosition().Getrow() == a.Getrow()) {
                        pawn.setPawnPosition(b);
                    }
                }
            }
            gameBoard[b.Getrow()][b.Getcol()] = newp;
            this.gameBoard[a.Getrow()][a.Getcol()] = null;
            moveHistory.add(a);
            moveHistory.add(b);
        }
        numOfMoves++;
        //checking for kills
        checkForKills(b);
        if (isGameFinished()) {
            printAllData();
        }
        return true;
    }

    public void checkForKills(Position b) {
        for (int i = 0; i < 11; i++)
            for (int j = 0; j < 11; j++) {
                if (j == 0 || j == 10 || i == 0 || i == 10) {
                    if (j == 0) {
                        if (gameBoard[j][i] != null && Objects.equals(gameBoard[j][i].getType(), "♔") && gameBoard[j + 1][i] != null && gameBoard[j][i + 1] != null && gameBoard[j][i - 1] != null) {
                            if (gameBoard[j + 1][i].getOwner() == P2 && gameBoard[j][i + 1].getOwner() == P2 && gameBoard[j][i - 1].getOwner() == P2) {
                                for (Pawn pawn : attacker) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        pawn.killed();
                                        theKing.setMovekilled(numOfMoves);
                                        gameBoard[j][i] = null;
                                        theKing.kingPosition = null;
                                    }
                                }
                            }
                        }
                        if (gameBoard[j][i] != null && gameBoard[j + 1][i] != null && !Objects.equals(gameBoard[j][i].getType(), "♔") && !Objects.equals(gameBoard[j + 1][i].getType(), "♔")) {
                            if (gameBoard[j][i].getOwner() != gameBoard[j + 1][i].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == P2) {
                                    for (Pawn pawn : attacker) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : defender) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == i && pawn1.getPawnPosition().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : defender) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : attacker) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (j == 10) {
                        if (gameBoard[j][i] != null && Objects.equals(gameBoard[j][i].getType(), "♔")) {
                            if (gameBoard[j][i - 1] != null && gameBoard[j - 1][i] != null && gameBoard[j][i + 1] != null && gameBoard[j - 1][i].getOwner() == P2 && gameBoard[j][i + 1].getOwner() == P2 && gameBoard[j][i - 1].getOwner() == P2) {
                                for (Pawn pawn : attacker) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        pawn.killed();
                                        gameBoard[j][i] = null;
                                        theKing.setMovekilled(numOfMoves);
                                        theKing.kingPosition = null;
                                    }
                                }
                            }
                        }
                        if (gameBoard[j][i] != null && gameBoard[j - 1][i] != null && !Objects.equals(gameBoard[j][i].getType(), "♔")) {
                            if (gameBoard[j][i].getOwner() != gameBoard[j - 1][i].getOwner() && !Objects.equals(gameBoard[j - 1][i].getType(), "♔")) {
                                if (getPieceAtPosition(b).getOwner() == P2) {
                                    for (Pawn pawn : attacker) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : defender) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == i && pawn1.getPawnPosition().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : defender) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : attacker) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i == 0) {
                        if (gameBoard[j][i] != null && Objects.equals(gameBoard[j][i].getType(), "♔")) {
                            if (gameBoard[j - 1][i] != null && gameBoard[j][i + 1] != null && gameBoard[j + 1][i] != null &&
                                    gameBoard[j - 1][i].getOwner() == P2 && gameBoard[j][i + 1].getOwner() == P2 && gameBoard[j + 1][i].getOwner() == P2) {
                                for (Pawn pawn : attacker) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        gameBoard[j][i] = null;
                                        theKing.Setpos(null);
                                        theKing.setMovekilled(numOfMoves);
                                        gameBoard[j][i] = null;
                                    }
                                }
                            }
                        }
                        if (gameBoard[j][i] != null && gameBoard[j][i + 1] != null && !Objects.equals(gameBoard[j][i + 1].getType(), "♔")) {
                            if (gameBoard[j][i].getOwner() != gameBoard[j][i + 1].getOwner() && !Objects.equals(gameBoard[j][i].getType(), "♔")) {
                                if (getPieceAtPosition(b).getOwner() == P2) {
                                    for (Pawn pawn : attacker) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn2 : defender) {
                                                if (pawn2 != null && pawn2.getPawnPosition().Getrow() == i && pawn2.getPawnPosition().Getcol() == j) {
                                                    pawn.killed();
                                                    pawn.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : defender) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : attacker) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i == 10) {
                        if (gameBoard[j][i] != null && Objects.equals(gameBoard[j][i].getType(), "♔") && gameBoard[j - 1][i] != null && gameBoard[j][i] != null) {
                            if (gameBoard[j - 1][i].getOwner() == P2 && gameBoard[j][i - 1].getOwner() == P2 && gameBoard[j + 1][i].getOwner() == P2) {
                                for (Pawn pawn : attacker) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        theKing.Setpos(null);
                                        theKing.setMovekilled(numOfMoves);
                                        gameBoard[j][i] = null;
                                    }
                                }
                            }
                        } else {
                            if (gameBoard[j][i] != null && !Objects.equals(gameBoard[j][i].getType(), "♔") && gameBoard[j][i - 1] != null && !Objects.equals(gameBoard[j][i - 1].getType(), "♔")
                                    && gameBoard[j][i].getOwner() != gameBoard[j][i - 1].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == P1) {
                                    for (Pawn pawn : defender) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : attacker) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.Movekilled = numOfMoves;
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : attacker) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : defender) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == i && pawn1.getPawnPosition().Getcol() == j && pawn1.getPawnPosition().Getrow() == pawn.getPawnPosition().Getrow()) {
                                                    pawn.killed();
                                                    pawn1.Movekilled = numOfMoves;
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (gameBoard[j][i] != null && gameBoard[j][i].getType().equals("♔")) {
                        if (gameBoard[j][i - 1] != null && gameBoard[j - 1][i] != null && gameBoard[j + 1][i] != null && gameBoard[j][i + 1] != null &&
                                gameBoard[j - 1][i].getOwner() == P2 && gameBoard[j + 1][i].getOwner() == P2 &&
                                gameBoard[j][i + 1].getOwner() == P2 && gameBoard[j][i - 1].getOwner() == P2) {
                            for (Pawn a : attacker) {
                                if (a != null && a.getPawnPosition().Getrow() == b.Getrow() && a.getPawnPosition().Getcol() == b.Getcol()) {
                                    theKing.Setpos(null);
                                    theKing.setMovekilled(numOfMoves);
                                    gameBoard[j][i] = null;
                                }
                            }
                        }
                    }
                    if (gameBoard[j][i] != null && gameBoard[j][i - 1] != null && gameBoard[j][i + 1] != null && !Objects.equals(gameBoard[j][i - 1].getType(), "♔")
                            && !Objects.equals(gameBoard[j][i + 1].getType(), "♔") && !Objects.equals(gameBoard[j][i].getType(), "♔")) {
                        if (gameBoard[j][i].getOwner() != gameBoard[j][i - 1].getOwner() && gameBoard[j][i].getOwner() != gameBoard[j][i + 1].getOwner()) {
                            if (gameBoard[j][i].getOwner() == P1) {
                                for (Pawn pawn : attacker) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        for (Pawn pawn1 : defender) {
                                            if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                pawn.killed();
                                                pawn1.setMovekilled(numOfMoves);
                                                gameBoard[j][i] = null;
                                            }
                                        }
                                    }
                                }
                            } else {
                                for (Pawn pawn : defender) {
                                    if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                        for (Pawn pawn1 : attacker) {
                                            if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                pawn.killed();
                                                pawn1.setMovekilled(numOfMoves);
                                                gameBoard[j][i] = null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if (gameBoard[j][i] != null && gameBoard[j - 1][i] != null && !Objects.equals(gameBoard[j][i].getType(), "♔") && gameBoard[j + 1][i] != null
                                && !Objects.equals(gameBoard[j - 1][i].getType(), "♔") && !Objects.equals(gameBoard[j + 1][i].getType(), "♔")) {
                            if (gameBoard[j][i].getOwner() != gameBoard[j - 1][i].getOwner() && gameBoard[j][i].getOwner() != gameBoard[j + 1][i].getOwner()) {
                                if (getPieceAtPosition(b).getOwner() == P2) {
                                    for (Pawn pawn : attacker) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : defender) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    for (Pawn pawn : defender) {
                                        if (pawn != null && pawn.getPawnPosition().Getcol() == b.Getcol() && pawn.getPawnPosition().Getrow() == b.Getrow()) {
                                            for (Pawn pawn1 : attacker) {
                                                if (pawn1 != null && pawn1.getPawnPosition().Getrow() == j && pawn1.getPawnPosition().Getcol() == i) {
                                                    pawn.killed();
                                                    pawn1.setMovekilled(numOfMoves);
                                                    gameBoard[j][i] = null;
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
        return this.gameBoard[position.Getrow()][position.Getcol()];
    }

    public Player getFirstPlayer() {
        return this.P1;
    }

    public Player getSecondPlayer() {
        return this.P2;
    }


    public boolean isGameFinished() {
        Position kingPosition = theKing.Getpos();
        if (kingPosition == null) {
            P2.won();
            P2.setlastwin();
            return true;
        }
        if (kingPosition.Getrow() == 10 && (kingPosition.Getcol() == 0 || kingPosition.Getcol() == 10)) {
            P1.won();
            P1.setlastwin();
            return true;
        }
        if (kingPosition.Getrow() == 0 && (kingPosition.Getcol() == 0 || kingPosition.Getcol() == 10)) {
            P1.won();
            P1.setlastwin();
            return true;
        }
        int cnt = 0;
        for (Pawn a : attacker) {
            if (a.Movekilled == 0) {
                return false;
            }
            cnt++;
        }
        if (cnt == 24) {
            return true;
        }
        cnt = 0;
        for (Pawn a : defender) {
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
        return this.numOfMoves % 2 == 0;
    }

    @Override
    public void reset() {
        attacker = new Pawn[25];
        defender = new Pawn[14];
        new GameLogic();
        gameBoard = fillGameBoard();
        numOfMoves = 0;
    }

    @Override
    public void undoLastMove() {
        if (numOfMoves > 0) {
            Position lastPos = moveHistory.get(moveHistory.size() - 1);
            Position beforeLastPos = moveHistory.get(moveHistory.size() - 2);
            Pawn newPawn;
            Pawn retPawn;
            for (int i = 0; i < 2; i++) {
                for (Pawn pawn : attacker) {
                    if (pawn != null && pawn.Movekilled == numOfMoves) {
                        retPawn = pawn;
                        gameBoard[pawn.getPawnPosition().Getrow()][pawn.getPawnPosition().Getcol()] = retPawn;
                        pawn.setMovekilled(0);
                    }
                }
                for (Pawn pawn : defender) {
                    if (pawn != null && pawn.Movekilled == numOfMoves) {
                        retPawn = pawn;
                        gameBoard[pawn.getPawnPosition().Getrow()][pawn.getPawnPosition().Getcol()] = retPawn;
                        pawn.setMovekilled(0);
                    }
                }
            }
            if (isSecondPlayerTurn()) {
                newPawn = new Pawn(beforeLastPos, P1);
            } else {
                newPawn = new Pawn(beforeLastPos, P2);
            }
            gameBoard[beforeLastPos.Getrow()][beforeLastPos.Getcol()] = newPawn;
            gameBoard[lastPos.Getrow()][lastPos.Getcol()] = null;
            moveHistory.remove(moveHistory.size() - 1);
            moveHistory.remove(moveHistory.size() - 1);
            numOfMoves--;
        }
    }

    @Override
    public int getBoardSize() {
        return gameBoard[0].length;
    }

    private void printAllData() {
        printPieceData();
        starLine();
        printEatsData();
        starLine();
        printSumMovesData();
        starLine();
        printPositionData();
        starLine();
    }

    private void printPieceData() {
        Comparator<Pawn> pawnComparator = ((o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            if (o1.pawnMoveHistory.size() > o2.pawnMoveHistory.size()) {
                return 1;
            }
            if (o1.pawnMoveHistory.size() < o2.pawnMoveHistory.size()) {
                return -1;
            } else {
                if (o1.GetNumber() > o2.GetNumber()) {
                    return 1;
                }
                return -1;
            }
        }
        );
        Pawn kingdata = new Pawn(new Position(5, 5), P1);
        int cnt = 1;
        for (Position a : theKing.KingMoveHistory) {
            if (cnt == 1) {
                cnt = 0;
                kingdata.moved(new Position(5, 5));
                continue;
            }
            kingdata.moved(a);
        }
        kingdata.setPawnNumber(7);
        Pawn[] newDef = new Pawn[defender.length + 1];
        for (int i = 0; i <= defender.length; i++) {
            if (i == defender.length) {
                newDef[i] = kingdata;
                break;
            }
            if (defender[i] != null) {
                newDef[i] = defender[i];
            }


        }
        Arrays.sort(attacker, pawnComparator);
        Arrays.sort(newDef, pawnComparator);

        Pawn[] winner;
        Pawn[] loser;

        if (isSecondPlayerTurn()) {
            winner = newDef;
            loser = attacker;
            for (Pawn pawn : winner) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    if (pawn.GetNumber() == 7) {
                        System.out.print("K" + pawn.GetNumber() + ": [");
                    } else {
                        System.out.print("D" + pawn.GetNumber() + ": [");
                    }
                    for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                        if (i != pawn.pawnMoveHistory.size() - 1) {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
            for (Pawn pawn : loser) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    System.out.print("A" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                        if (i != pawn.pawnMoveHistory.size() - 1) {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
        } else {
            winner = attacker;
            loser = newDef;
            for (Pawn pawn : winner) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    System.out.print("A" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                        if (i != pawn.pawnMoveHistory.size() - 1) {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + ")");
                        }
                    }
                    System.out.println("]");
                }
            }
            for (Pawn pawn : loser) {
                if (pawn != null && pawn.Summoves() >= 1) {
                    if (pawn.pawnNumber == 7)
                        System.out.print("K" + pawn.GetNumber() + ": [");
                    else
                        System.out.print("D" + pawn.GetNumber() + ": [");
                    for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                        if (i != pawn.pawnMoveHistory.size() - 1) {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + "), ");
                        } else {
                            System.out.print("(" + pawn.pawnMoveHistory.get(i).Getcol() + ", " + pawn.pawnMoveHistory.get(i).Getrow() + ")");
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
            if (o2.getNumOfKills() > o1.getNumOfKills()) {
                return 1;
            }
            if (o1.getNumOfKills() > o2.getNumOfKills()) {
                return -1;
            }
            return 0;
        };

        Arrays.sort(attacker, killsCompare);
        Arrays.sort(defender, killsCompare);

        Pawn[] winner;
        Pawn[] loser;

        if (isSecondPlayerTurn()) {
            winner = defender;
            loser = attacker;
        } else {
            winner = attacker;
            loser = defender;
        }

        for (Pawn pawn : winner) {
            if (pawn != null && pawn.getNumOfKills() >= 1) {
                System.out.println("A" + pawn.GetNumber() + ": " + pawn.getNumOfKills() + " kills");
            }
        }
        for (Pawn pawn : loser) {
            if (pawn != null && pawn.getNumOfKills() >= 1) {
                System.out.println("D" + pawn.GetNumber() + ": " + pawn.getNumOfKills() + " kills");
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
        Pawn kingdata = new Pawn(new Position(5, 5), P1);
        int cnt = 1;
        for (Position a : theKing.KingMoveHistory) {
            if (cnt == 1) {
                cnt = 0;
                kingdata.moved(new Position(5, 5));
                continue;
            }
            kingdata.moved(a);
        }
        kingdata.setPawnNumber(7);

        Pawn[] newDef = new Pawn[defender.length + 1];
        for (int i = 0; i <= defender.length; i++) {
            if (i == defender.length) {
                newDef[i] = kingdata;
                continue;
            }
            if (defender[i] != null) {
                newDef[i] = defender[i];

            }
        }
        Pawn[] Allpawn = new Pawn[newDef.length + attacker.length];
        int cntpawn = 0;
        for (Pawn a : attacker) {
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
    private void printPositionData() {
        ArrayList<Position> finalsteps = new ArrayList<>();
        int[][] howManySteps = new int[11][11];
        boolean[][] isStepOver = new boolean[11][11];
        for (Position a : theKing.KingMoveHistory) {
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
        for (Pawn pawn : attacker) {
            if (pawn == null) {
                continue;
            }
            for (int j = 0; j < isStepOver.length; j++) {
                for (int k = 0; k < isStepOver.length; k++) {
                    isStepOver[j][k] = false;
                }
            }
            for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                if (!isStepOver[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()]) {
                    howManySteps[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()]++;
                    isStepOver[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()] = true;
                }
            }
        }
        for (Pawn pawn : defender) {
            if (pawn == null) {
                continue;
            }
            for (int j = 0; j < isStepOver.length; j++) {
                for (int k = 0; k < isStepOver.length; k++) {
                    isStepOver[j][k] = false;
                }
            }
            for (int i = 0; i < pawn.pawnMoveHistory.size(); i++) {
                if (!isStepOver[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()]) {
                    howManySteps[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()]++;
                    isStepOver[pawn.pawnMoveHistory.get(i).Getrow()][pawn.pawnMoveHistory.get(i).Getcol()] = true;
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

    private void starLine() {
        for (int i = 0; i < 75; i++) {
            System.out.print("*");
            if (i == 74) {
                System.out.println("");
            }
        }
    }

}