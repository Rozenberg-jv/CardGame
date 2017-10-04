package by.kolbun.gdx.logic.cards;

import by.kolbun.gdx.logic.util.DragHandler;
import by.kolbun.gdx.logic.GameActor;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TrophyCard extends GameActor {
    private TrophyType trophyType;
    private TownType townType;

    private TextureRegion front;
    private TextureRegion back;

    private boolean isShown;

    // не двигаются карты из руки
    // не определяется карта под городом при нажатии
    // не определяется нажатие на карту в правом нижнем углу

    public TrophyCard(TrophyType trophy, TownType town, TextureRegion _front, TextureRegion _back) {
        super(_back);
        trophyType = trophy;
        townType = town;
        front = _front;
        back = _back;

        this.setBounds(0, 0, 60, 100);
        this.setName(">TrophyCard:" + this.townType.toString() + ":" + this.trophyType.toString());

        this.addListener(new DragHandler());

    }

    //gs

    public TrophyType getTrophyType() {
        return trophyType;
    }

    public TownType getTownType() {
        return townType;
    }

    public boolean isShown() {
        return isShown;
    }


    public void setShown(boolean shown) {
        isShown = shown;
        if (isShown) {
            texture = front;
        } else texture = back;
    }


}
