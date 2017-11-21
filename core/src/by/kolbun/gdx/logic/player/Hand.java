package by.kolbun.gdx.logic.player;

import com.badlogic.gdx.scenes.scene2d.Group;

public class Hand extends Group {

    private BigHuntersHand bigHunters;
    private SmallHuntersHand smallHunters;
    private CardsHand cards;

    Hand(String _parent) {
        this.setName(">Hand");

        bigHunters = new BigHuntersHand(_parent);
        smallHunters = new SmallHuntersHand(_parent);
        cards = new CardsHand();

        this.addActor(bigHunters);
        this.addActor(smallHunters);
        this.addActor(cards);
    }


    //gs

    public BigHuntersHand getBigHunters() {
        return bigHunters;
    }

    public SmallHuntersHand getSmallHunters() {
        return smallHunters;
    }

    public CardsHand getCards() {
        return cards;
    }

    public int getFreeHuntersCount() {
        int i = 0;

        i += bigHunters.getChildren().size;
        i += smallHunters.getChildren().size;

        return i;
    }

    void resetNewRound() {
        cards.resetNewRound();
        // TODO: 05.10.2017 возврат только больших хантеров
    }
}
