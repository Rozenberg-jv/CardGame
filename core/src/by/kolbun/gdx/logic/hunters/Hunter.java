package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.logic.util.DragHandler;
import by.kolbun.gdx.logic.GameActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hunter extends GameActor {

    public Hunter(TextureRegion _texture) {
        super(_texture);
        this.addListener(new DragHandler());
    }

}
