package by.kolbun.gdx.logic.hunters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SmallHunter extends Hunter {

    public SmallHunter(TextureRegion _texture, TextureRegion _back) {
        super(_texture, _back);
        this.setBounds(0, 0, 30, 30);

    }

}
