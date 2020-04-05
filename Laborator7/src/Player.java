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

    public synchronized void extractToken(Token extracted) {
        extractedTokens.add(Token extracted);
    }

    @Override
    public void run() {
        if (board.nrTokens > 0) {
            Random rand = new Random();
            int n = rand.nextInt(board.nrTokens)+1;
            /*am avut si o tentativa de a evita de a lua de doua ori acelasi token
            if(!(board.tokenList.contains(n)))
                while(!(board.tokenList.contains(n)))
                    n = rand.nextInt(board.nrTokens);*/
            Token extracted = new Token(n);
            extractToken(extracted); 
            board.nrTokens--;
            board.tokenList.remove(extracted);
            
            System.out.println(this.name + "a luat piesa" + n);
            if (board.nrTokens == 0)
                System.out.println(this.name + " a castigat");
        }
        else
            System.out.println("nu mai exista piese de extras");

    }

}


