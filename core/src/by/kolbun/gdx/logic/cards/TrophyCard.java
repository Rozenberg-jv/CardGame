package by.kolbun.gdx.logic.cards;

import by.kolbun.gdx.logic.DraggHandler;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class TrophyCard extends Actor {
    private TrophyType trophyType;
    private TownType townType;

    private TextureRegion texture;
    private TextureRegion front;
    private TextureRegion back;

    private boolean isShown;

    // не двигаются карты из руки
    // @TODO не определяется карта под городом при нажатии
    // не определяется нажатие на карту в правом нижнем углу

    public TrophyCard(TrophyType trophy, TownType town, TextureRegion _front, TextureRegion _back) {
        trophyType = trophy;
        townType = town;
        front = _front;
        back = _back;

        texture = front;
        this.setBounds(0, 0, 60, 100);
        this.setName(">TrophyCard:" + this.townType.toString() + ":" + this.trophyType.toString());

        this.addListener(new DraggHandler());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY(), this.getWidth(), this.getHeight());
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
