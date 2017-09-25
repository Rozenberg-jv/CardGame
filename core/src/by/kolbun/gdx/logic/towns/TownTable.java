package by.kolbun.gdx.logic.towns;

import by.kolbun.gdx.logic.cards.TrophyCard;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class TownTable extends Group {

    public TownTable() {
        this.setName(">TownTable");
        initTownTable();
    }

    private void initTownTable() {
        for (TownType type : TownType.values()) {
            this.addActor(new Town(type, type.getX(), type.getTexture()));
        }
    }

    public void putCard(TrophyCard _card, Town _town) {
        if (_card.getTownType() == _town.getType()) {
            Gdx.app.log(getName(), "putCard()");

            _town.addUnder(_card);
        }
    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        super.drawChildren(batch, parentAlpha);
    }

    //gs

}
