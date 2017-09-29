package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TownCard;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.hunters.Hunter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Town - группа, первой добавляется карта TownCard, рисуется всегда последней,
 * добавляются карты TrophyCard, пример см. CardsHand,
 * реализовать х-координату, зависит от положения Town в массиве TownTable
 */

public class Town extends Group {
    private TownType type;
    private UnderTable under;
    private HuntersTable hunters;
    private TownCard town;

    int xPos;

    Town(TownType _type, int _x) {
        type = _type;
        this.setName(">Town");

        xPos = _x;

        hunters = new HuntersTable();
        under = new UnderTable();
        town = new TownCard(_type.getTexture(), _type.getX());

        this.addActor(hunters);
        this.addActor(under);
        this.addActor(town);
    }

    public void addUnder(TrophyCard _card) {
        if (_card.getTownType() != this.getType()) {
            Gdx.app.log(this.getName(), "Попытка сброса карты под несоответствующий тип города.");
            return;
        }

        _card.setPosition(xPos, town.getY() + 20 * (under.getChildren().size + 1));
        under.addActor(_card);
    }

    public void addHunter(Hunter _hunter) {
        if (!isHunterAddValid(_hunter)) return;

        hunters.addActor(_hunter);
    }

    private boolean isHunterAddValid(Hunter _hunter) {
        //@TODO проверка на соответствие правилам

        return true;
    }

    public void clear() {
        hunters.clear();
        under.clear();
    }


    //gs

    public TownType getType() {
        return type;
    }

}
