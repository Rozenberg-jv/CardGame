package by.kolbun.gdx.logic.hunters;

import by.kolbun.gdx.logic.player.OwnerType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BigHunter extends Hunter {

    public BigHunter(TextureRegion _texture, TextureRegion _back, OwnerType _owner) {
        super(_texture, _back, _owner);
        this.setBounds(0, 0, 40, 40);

    }

}
