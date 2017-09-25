package by.kolbun.gdx.logic.player;

import com.badlogic.gdx.scenes.scene2d.Group;

public class Hand extends Group {

    private BigHuntersHand bigHunters;
    private SmallHuntersHand smallHunters;
    private CardsHand cards;

    Hand() {
        bigHunters = new BigHuntersHand();
        smallHunters = new SmallHuntersHand();
        cards = new CardsHand();
        this.setName(">Hand");
        initHand();
    }

    private void initHand() {
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
