package by.kolbun.gdx.logic.cards;

import by.kolbun.gdx.logic.GameActor;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TownCard extends GameActor {

    public TownCard(TextureRegion _texture, int _x, TownType _type) {
        super(_texture);
        setName("TownCard:" + _type.ordinal());
        setBounds(_x, 30, 60, 100);

//        addListener(); //@TODO добавить листнер клика
    }


    //gs


}
