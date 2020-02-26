package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules = new Rules();
    private Coin coin = Coin.getInstance();
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        if (!history.containsKey(player)){
            history.put(player, new ArrayList<CoinState>());
        }
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        for (Map.Entry<Player, List<CoinState>> entry : this.history.entrySet()) { // loop sur les joueur
            while(!this.rules.checkWin(entry.getValue())){ // joue jusqu'a gagner
                entry.getKey().play(this.coin);
                entry.getValue().add(this.coin.getState()); // ajout du résultat au joueur
            }
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
        int nbTotalLance = 0;
        int mostMoveToWin = Integer.MIN_VALUE;
        int fewerMoveToWin = Integer.MAX_VALUE;

        for (Map.Entry<Player, List<CoinState>> entry : this.history.entrySet()) {
            if(entry.getValue().size() > mostMoveToWin){
                mostMoveToWin = entry.getValue().size();
            }
            if (entry.getValue().size() < fewerMoveToWin){
                fewerMoveToWin = entry.getValue().size();
            }
            nbTotalLance +=  entry.getValue().size();
        }

        return new Statistics((float) nbTotalLance / (float) this.history.size(),fewerMoveToWin,mostMoveToWin,nbTotalLance);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      return this.history;
    }

    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      return history.get(player);
    }

}
