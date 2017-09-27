package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
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

    Town(TownType _type, int _xPos, TextureRegion _texture) {
        type = _type;
        texture = _texture;
        this.setPosition(_xPos, 50);
        this.setName(">Town:" + _type.toString());
    }

    public void addUnder(TrophyCard _card) {
        if (_card.getTownType() != this.getType()) return;

        _card.setShown(true);
        this.addActor(_card);
        _card.setPosition(this.getX(), this.getY() + 20 * this.getChildren().size);

    }

    public void clear() {
        this.clearChildren();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int i = this.getChildren().size - 1; i >= 0; i--) {
            this.getChildren().get(i).draw(batch, parentAlpha);
        }
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }


    //gs

    public TownType getType() {
        return type;
    }

}
