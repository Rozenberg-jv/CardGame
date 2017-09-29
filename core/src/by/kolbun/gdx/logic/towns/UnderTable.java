package by.kolbun.gdx.logic.towns;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class UnderTable extends Group {

    public UnderTable() {
        this.setName(">UnderTable");

    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        for (int i = this.getChildren().size - 1; i >= 0; i--) {
            this.getChildren().get(i).draw(batch, parentAlpha);
        }
    }

}
