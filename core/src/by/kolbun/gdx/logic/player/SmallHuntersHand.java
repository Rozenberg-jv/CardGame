package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.logic.hunters.SmallHunter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class SmallHuntersHand extends Group {

    public SmallHuntersHand(String _parent) {
        setName(">SmallHuntersHand");

        TextureRegion texture;
        TextureRegion back;
        SmallHunter newHunter;

        switch (_parent) {
            case "PlayerGreen":
                texture = ResourceLoader.getLoader().smallHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                break;
            case "PlayerRed":
                texture = ResourceLoader.getLoader().smallHuntRed;
                back = ResourceLoader.getLoader().huntPointRed;
                break;
            case "PlayerYellow":
                texture = ResourceLoader.getLoader().smallHuntYellow;
                back = ResourceLoader.getLoader().huntPointYellow;
                break;
            case "PlayerBlue":
                texture = ResourceLoader.getLoader().smallHuntBlue;
                back = ResourceLoader.getLoader().huntPointBlue;
                break;
            default:
                texture = ResourceLoader.getLoader().smallHuntGreen;
                back = ResourceLoader.getLoader().huntPointGreen;
                break;
        }

        for (int i = 0; i < 3; i++) {
            newHunter = new SmallHunter(texture, back);
            newHunter.setPosition(i * 40 + 40, 380);
            newHunter.setName("smallHunter#" + i);
            this.addActor(newHunter);
        }
    }

}
