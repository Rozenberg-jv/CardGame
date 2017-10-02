package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TownCard;
import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.hunters.Hunter;
import by.kolbun.gdx.logic.util.ZoomClickHandler;
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

    private int xPos;

    Town(TownType _type, int _x) {
        type = _type;
        this.setName(">Town");

        xPos = _x;

        hunters = new HuntersTable();
        town = new TownCard(_type.getTexture(), _type.getX());
        under = new UnderTable();

        this.addActor(under);
        this.addActor(town);
        this.addActor(hunters);
    }

    public boolean addUnder(TrophyCard _card) {
        if (_card.getTownType() != this.getType()) {
            Gdx.app.log(this.getName(), "Попытка сброса карты под несоответствующий тип города.");
            return false;
        }

        under.addActor(_card, xPos, town.getY());
        _card.clearListeners();
        _card.addListener(new ZoomClickHandler());
        return true;
    }

    public void addHunter(Hunter _hunter) {
        if (!isHunterAddValid(_hunter)) return;

        hunters.addActor(_hunter);

        _hunter.clearListeners();
        _hunter.addListener(new ZoomClickHandler());
    }

    private boolean isHunterAddValid(Hunter _hunter) {
        //@TODO проверка на соответствие правилам

        return true;
    }

    public void clear() {
        hunters.clear();
        under.clear();
    }

/*
    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        under.draw(batch, parentAlpha);
        town.draw(batch);
    }
*/


    //gs

    public TownType getType() {
        return type;
    }

    public int getXPos() {
        return xPos;
    }

}
