package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.hunters.Hunter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;

//@TODO

/**
 * Town - группа, первой добавляется карта TownCard, рисуется всегда последней,
 * добавляются карты TrophyCard, пример см. CardsHand,
 * реализовать х-координату, зависит от положения Town в массиве TownTable
 */

public class Town extends Group {
    private TownType type;
    private TextureRegion texture;
    private UnderTable under;
    private HuntersTable hunters;

    Town(TownType _type, int _xPos, TextureRegion _texture) {
        type = _type;
        texture = _texture;
//        this.setPosition(_xPos, 50);
        this.setBounds(_xPos, 50, 60, 100);
        this.setName(">Town");

        hunters = new HuntersTable(getX(), getY());
        under = new UnderTable(getX(), getY());
        this.addActor(hunters);
        this.addActor(under);
    }

    public void addUnder(TrophyCard _card) {
        if (_card.getTownType() != this.getType()) {
            Gdx.app.log(this.getName(), "Попытка сброса карты под несоответствующий тип города.");
            return;
        }

        _card.setPosition(this.getX(), this.getY() + 20);
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
        this.clearChildren();
    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        //nothing - handle in draw() method
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.drawChildren(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }


    //gs

    public TownType getType() {
        return type;
    }

}
