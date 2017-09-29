package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.BigHunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BigHuntersHand extends Group {

    public BigHuntersHand(String _parent) {
        BigHunter newHunter;
        TextureRegion texture;

        this.setName(">BigHuntersHand");

        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().bigHuntGreen;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().bigHuntRed;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().bigHuntYellow;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().bigHuntBlue;
                break;
            default:
                texture = ResourceLoader.getLoader().bigHuntGreen;
                break;
        }


        for (int i = 0; i < 6; i++) {
            newHunter = new BigHunter(texture);
            newHunter.setPosition(i * 50 + 20, 420);
            newHunter.setName("bigHunter#" + i);
            this.addActor(newHunter);
        }

    }

    // наследовать класс от Actor и наследоваться от него всем актерам, которые draggable??
    // по примеру сделать для дургих draggable актеров.
    // дать имена всем группам-актерам вниз по иерархии
    // очередность прорисовки актеров -> Actor.toFront();

}
