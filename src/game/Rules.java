package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    int nbHead = 0;
    for (CoinState tmp: states) {
      if(tmp == CoinState.HEADS){
        nbHead ++;
      }
    }
    return nbHead >= 3 || states.size() - nbHead >= 3;
  }
}