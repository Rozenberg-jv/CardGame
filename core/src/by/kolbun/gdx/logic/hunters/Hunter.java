package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.logic.util.DragHandler;
import by.kolbun.gdx.logic.GameActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hunter extends GameActor {

    private TextureRegion front;
    private TextureRegion back;

    public Hunter(TextureRegion _texture, TextureRegion _back) {
        super(_texture);
        front = _texture;
        back = _back;
        this.addListener(new DragHandler());
    }


    public void toggleTexture() {
        if (texture == front) {
            texture = back;
        } else {
            texture = front;
        }
    }
}
