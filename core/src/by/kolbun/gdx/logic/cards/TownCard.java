package by.kolbun.gdx.logic.cards;

import by.kolbun.gdx.logic.GameActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TownCard extends GameActor {

    public TownCard(TextureRegion _texture, int _x) {
        super(_texture);
        setName("TownCard");
        setBounds(_x, 30, 60, 100);

//        addListener(); //@TODO добавить листнер клика
    }


}
