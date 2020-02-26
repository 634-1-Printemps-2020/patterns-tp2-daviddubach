package materials;

import java.util.Random;

public class Coin {

  private CoinState coinState;
  private Random r = new Random();
  private static Coin instance;

  private Coin(){}

  public static Coin getInstance(){
    if(instance == null){
      instance = new Coin();
    }
    return instance;
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    this.coinState =  (r.nextInt(2) == 0) ? CoinState.HEADS : CoinState.TAILS;
  }

  public CoinState getState() {
    return coinState;
  }
}
