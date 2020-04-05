import java.util.ArrayList;
import java.util.List;

public class Boards {

    public int nrTokens;
    List<Token> tokenList = new ArrayList<>();

    public Boards(int nrTokens) {
        this.nrTokens = nrTokens;
        for (int i = 0; i <= nrTokens; i++) {
            tokenList.add(new Token(i));
        }
    }

    public int getNrTokens() {
        return nrTokens;
    }

    public void setNrTokens(int nrTokens) {
        this.nrTokens = nrTokens;
    }


}
