package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class CardsHand extends Group {

    int num = 0;

    public CardsHand() {
        this.setName(">CardsHand");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Actor card : this.getChildren()) {
            card.draw(batch, parentAlpha);
        }
    }

    //@TODO
    public TrophyCard getRandomCard() {
        TrophyCard card;

        for (Actor cardd : this.getChildren()) {
            card = (TrophyCard) cardd;
            if (card.getTownType() == TownType.NUL) return card;
        }

        return null;
    }

    public void addCard(TrophyCard _card) {
        _card.setPosition(400 + num++ * 70, 350);
        _card.setShown(true);
        this.addActor(_card);
    }
}
