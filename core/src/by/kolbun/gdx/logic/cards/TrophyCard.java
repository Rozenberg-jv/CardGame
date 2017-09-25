package by.kolbun.gdx.logic.cards;

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
    //@TODO не определяется карта под городом
    //@TODO не определяется нажатие на карту в правом нижнем углу

    public TrophyCard(TrophyType trophy, TownType town, TextureRegion _front, TextureRegion _back) {
        trophyType = trophy;
        townType = town;
        front = _front;
        back = _back;

        texture = front;
//        this.setSize(60, 100);
        this.setBounds(0, 0, 60, 100);
        this.setName(">TrophyCard:" + this.townType.toString() + ":" + this.trophyType.toString());

        this.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(getName(), "touchDown() x:" + x + ", y:" + y);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(getName(), "touchUp()");
            }

            Vector2 nPos;

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                nPos = localToStageCoordinates(new Vector2(x, y));
                setPosition(-getWidth() / 2 + nPos.x, -getHeight() / 2 + nPos.y);
//                Gdx.app.log("BigHunter", "touchDragged() x:" + x + ", y:" + y);
//                Gdx.app.log("BigHunter", "current " + localToStageCoordinates(new Vector2(x, y)).toString());
            }
        });

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
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
