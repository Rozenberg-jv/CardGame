package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.BigHunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BigHuntersHand extends Group {

    public BigHuntersHand() {
        this.setName(">BigHuntersHand");

        BigHunter newHunter;
        for (int i = 0; i < 6; i++) {
            newHunter = new BigHunter(ResourceLoader.getLoader().bigHunter);
            newHunter.setPosition(i * 50 + 20, 420);
            newHunter.setName("bigHunter#" + i);
            this.addActor(newHunter);
        }

    }

    //@TODO наследовать класс от Actor и наследоваться от него всем актерам, которые draggable??
    //@TODO по примеру сделать для дургих draggable актеров.
    //дать имена всем группам-актерам вниз по иерархии
    //@TODO очередность прорисовки актеров -> Actor.toFront();

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawChildren(batch, parentAlpha);
    }
}
