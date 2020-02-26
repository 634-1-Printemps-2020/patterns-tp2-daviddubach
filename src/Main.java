import game.Game;
import player.Player;

public class Main {

  public static void main(String[] args) {
    Game game = new Game();

    game.addPlayer(new Player(1));
    game.addPlayer(new Player(2));
    game.addPlayer(new Player(3));
    game.addPlayer(new Player(4));
    game.addPlayer(new Player(5));

    game.play();

    System.out.println(game.getHistory());
    System.out.println(game.getStatistics());

    System.out.println(game.getSpecificHistory(new Player(1)));

  }

}
