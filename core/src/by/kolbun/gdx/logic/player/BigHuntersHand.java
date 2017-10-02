package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.BigHunter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class BigHuntersHand extends Group {

    public BigHuntersHand(String _parent) {
        setName("BigHuntersHand");

        BigHunter newHunter;
        TextureRegion texture;
        TextureRegion back;

        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().bigHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().bigHuntRed;
                back = ResourceLoader.getLoader().huntPointRed;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().bigHuntYellow;
                back = ResourceLoader.getLoader().huntPointYellow;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().bigHuntBlue;
                back = ResourceLoader.getLoader().huntPointBlue;
                break;
            default:
                texture = ResourceLoader.getLoader().bigHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                break;
        }


        for (int i = 0; i < 6; i++) {
            newHunter = new BigHunter(texture, back);
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
