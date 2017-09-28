package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.logic.DraggHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BigHunter extends Hunter {
    private TextureRegion texture;

    public BigHunter(TextureRegion _texture) {
        texture = _texture;
        this.setBounds(0, 0, 40, 40);

        this.addListener(new DraggHandler());
        /*this.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(getName(), "touchDown() x:" + x + ", y:" + y);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.app.log(getName(), "touchUp()");
            }

            Vector2 nPos;

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                nPos = localToStageCoordinates(new Vector2(x, y));
                setPosition(-getWidth() / 2 + nPos.x, -getWidth() / 2 + nPos.y);
//                Gdx.app.log("BigHunter", "touchDragged() x:" + x + ", y:" + y);
//                Gdx.app.log("BigHunter", "current " + localToStageCoordinates(new Vector2(x, y)).toString());
            }
        });*/
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    //gs


}
