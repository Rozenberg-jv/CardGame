package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.SmallHunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SmallHuntersHand extends Group{

    public SmallHuntersHand() {
        this.setName(">SmallHuntersHand");

        SmallHunter newHunter;
        for (int i = 0; i < 3; i++) {
            newHunter = new SmallHunter(ResourceLoader.getLoader().bigHunter);
            newHunter.setPosition(i * 40 + 40, 380);
            newHunter.setName("smallHunter#" + i);
            this.addActor(newHunter);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Actor hunter : this.getChildren()) {
            hunter.draw(batch, parentAlpha);
        }
    }
}
