package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.logic.player.OwnerType;
import by.kolbun.gdx.logic.util.DragHandler;
import by.kolbun.gdx.logic.GameActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hunter extends GameActor {

    private TextureRegion front;
    private TextureRegion back;
    private OwnerType owner;

    public Hunter(TextureRegion _texture, TextureRegion _back, OwnerType _owner) {
        super(_texture);
        front = _texture;
        back = _back;
        owner = _owner;
        this.addListener(new DragHandler());
    }


    public void toggleTexture() {
        if (texture == front) {
            texture = back;
        } else {
            texture = front;
        }
    }


    //gs


    public OwnerType getOwner() {
        return owner;
    }
}
