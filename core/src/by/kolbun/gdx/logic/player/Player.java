package by.kolbun.gdx.logic.player;

import by.kolbun.gdx.World;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Player extends Group {

    private boolean isHuman;
    private boolean isTurnDone;
    private Hand hand;
    private OwnerType owner;

    public Player(boolean isHuman, String _name, OwnerType _owner) {
        this.isHuman = isHuman;
        isTurnDone = false;
        this.setName(_name);
        owner = _owner;
        this.hand = new Hand(_name);

        this.addActor(hand);
    }

    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        if (World.getInstance().getCurrentPlayer() != this) return;
        super.drawChildren(batch, parentAlpha);
    }

    //gs

    public boolean isHuman() {
        return isHuman;
    }

    public Hand getHand() {
        return hand;
    }

    public OwnerType getOwner() {
        return owner;
    }

    public void resetNewRound() {
        hand.resetNewRound();
    }

    public void setTurnDone(boolean is) {
        isTurnDone = is;
    }

    public boolean isTurnDone() {
        return isTurnDone;
    }
}
