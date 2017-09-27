package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.SnapshotArray;

public class CardsUnder extends Group {
    private int xPos;

    private int number;

    CardsUnder(int _xPos) {
        xPos = _xPos;
        number = 0;
        this.setName(">Under");
//        this.setTouchable(Touchable.childrenOnly);
    }

    public void add(TrophyCard card) {
        this.addActor(card);
        card.setPosition(xPos, 70 + 20 * number++);
        card.setShown(true);
        card.setTouchable(Touchable.disabled);
    }

    public void clear() {
        number = 0;

        this.clearChildren();
    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        super.drawChildren(batch, parentAlpha);
        SnapshotArray<Actor> arr = this.getChildren();
        for (int i = arr.size - 1; i >= 0; i--) {
            arr.get(i).draw(batch, parentAlpha);
        }
    }


    //gs

}
