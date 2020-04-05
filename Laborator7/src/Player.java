import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private String name;
    Token tokenExtracted;
    List<Token> extractedTokens = new ArrayList<>();
    private Boards board;

    public Boards getBoard() { return board; }

    public void setBoard(Boards board) {
        this.board = board;
    }

    public Player(String name, Boards board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void extractToken(int n) {
        extractedTokens.add(new Token(n));
    }

    @Override
    public void run() {
        if (board.nrTokens > 0) {
            Random rand = new Random();
            int n = rand.nextInt(board.nrTokens);
            extractToken(n);
            board.nrTokens--;
            Token extracted = new Token(n);
            board.tokenList.remove(extracted);
            System.out.println(this.name + "a luat piesa" + n);
            if (board.nrTokens == 0)
                System.out.println(this.name + " a castigat");
        }
        else
            System.out.println("nu mai exista piese de extras");

    }

}


