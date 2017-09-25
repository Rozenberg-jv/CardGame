package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Town extends Group {
    private TownType type;
    private TextureRegion texture;

    Town(TownType _type, int _xPos, TextureRegion _texture) {
        type = _type;
        texture = _texture;
        this.setBounds(_xPos, 50, 60, 100);
        this.addActor(new CardsUnder(_xPos));
        this.setName(">Town:" + type.toString());
    }

    public void addUnder(TrophyCard _card) {
        ((CardsUnder)this.getChildren().first()).add(_card);
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
