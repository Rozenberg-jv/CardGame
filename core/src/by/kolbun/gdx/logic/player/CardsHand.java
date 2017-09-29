package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class CardsHand extends Group {

    private int num = 0;

    public CardsHand() {
        this.setName(">CardsHand");
    }


    public void addCard(TrophyCard _card) {
        _card.setPosition(400 + num++ * 70, 350);
        _card.setShown(true);
        this.addActor(_card);
    }
}
