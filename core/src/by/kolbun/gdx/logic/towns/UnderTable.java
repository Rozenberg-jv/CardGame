package by.kolbun.gdx.logic.towns;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class UnderTable extends Group {

    public UnderTable(float x, float y) {
        this.setName(">UnderTable");

//        this.setPosition(0, 0);
    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
//        super.drawChildren(batch, parentAlpha);
        for (int i = this.getChildren().size - 1; i >= 0; i--) {
            this.getChildren().get(i).draw(batch, parentAlpha);
        }
    }

}
