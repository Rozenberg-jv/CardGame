package by.kolbun.gdx.logic;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameActor extends Actor {
    protected TextureRegion texture;

    public GameActor(TextureRegion _texture) {
        texture = _texture;
        setSize(texture.getRegionWidth(), texture.getRegionHeight());
        setBounds(0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
       batch.draw(texture, getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(), getHeight(),
                getScaleX(), getScaleY(),
                getRotation());
    }
}
