package by.kolbun.gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ResourceLoader {

    public TextureRegion gameField;

    public TextureRegion town0;
    public TextureRegion town1;
    public TextureRegion town2;
    public TextureRegion town3;
    public TextureRegion town4;
    public TextureRegion town5;
    public TextureRegion town6;
    public TextureRegion townC;

    public TextureRegion cardBack;
    public TextureRegion priceCardTest;

    public TextureRegion bigHuntRed;
    public TextureRegion bigHuntGreen;
    public TextureRegion bigHuntYellow;
    public TextureRegion bigHuntBlue;

    public TextureRegion smallHuntRed;
    public TextureRegion smallHuntGreen;
    public TextureRegion smallHuntYellow;
    public TextureRegion smallHuntBlue;

    public TextureRegion huntPointRed;
    public TextureRegion huntPointGreen;
    public TextureRegion huntPointYellow;
    public TextureRegion huntPointBlue;

//    public Array<TextureRegion> bigHuntersTx;
//    public Array<TextureRegion> smallHuntersTx;

//    public TextureRegion bigHunter;
//    public TextureRegion smallHunter;

    //singleton
    private ResourceLoader() {
        rs = this;
    }

    private static ResourceLoader rs;

    public static ResourceLoader getLoader() {
        if (rs == null) return new ResourceLoader();
        else return rs;
    }

    public boolean loadGraphicResources() {
        TextureAtlas atlas = new TextureAtlas("atlas.atlas");

        Texture gameFieldTex = new Texture("game_field.png");
        gameField = new TextureRegion(gameFieldTex);
        gameField.flip(false, true);

        town0 = atlas.findRegion("town0");
        town0.flip(false, true);
        town1 = atlas.findRegion("town1");
        town1.flip(false, true);
        town2 = atlas.findRegion("town2");
        town2.flip(false, true);
        town3 = atlas.findRegion("town3");
        town3.flip(false, true);
        town4 = atlas.findRegion("town4");
        town4.flip(false, true);
        town5 = atlas.findRegion("town5");
        town5.flip(false, true);
        town6 = atlas.findRegion("town6");
        town6.flip(false, true);
        townC = atlas.findRegion("townC");
        townC.flip(false, true);

        priceCardTest = atlas.findRegion("price_card_test");
        priceCardTest.flip(false, true);
        cardBack = atlas.findRegion("card_back");
        cardBack.flip(false, true);


        bigHuntRed = atlas.findRegion("impBg_red");
        bigHuntGreen = atlas.findRegion("impBg_green");
        bigHuntYellow = atlas.findRegion("impBg_yellow");
        bigHuntBlue = atlas.findRegion("impBg_blue");

        smallHuntRed = atlas.findRegion("impSm_red");
        smallHuntGreen = atlas.findRegion("impSm_green");
        smallHuntYellow = atlas.findRegion("impSm_yellow");
        smallHuntBlue = atlas.findRegion("impSm_blue");

        huntPointRed = atlas.findRegion("hunt_point_red");
        huntPointGreen = atlas.findRegion("hunt_point_green");
        huntPointYellow = atlas.findRegion("hunt_point_yellow");
        huntPointBlue = atlas.findRegion("hunt_point_blue");

        return true;
    }

}
