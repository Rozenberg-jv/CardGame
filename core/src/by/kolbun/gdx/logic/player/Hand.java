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
}
