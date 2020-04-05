import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {
    public Game(int sizeBoard, int nrPlayers) throws InterruptedException {

        Boards table = new Boards(sizeBoard);
        List<Player> playerList = new ArrayList<>();
        while (nrPlayers > 0) {
            playerList.add(new Player("Rebecca" + nrPlayers, table));
            nrPlayers--;
        }
        while (table.nrTokens > 0)
        {
            for (Player player : playerList) {
                new Thread(player).start();
                new Thread(player).sleep((long) 100.0);
            }
        }
        System.out.println();
    }
}
