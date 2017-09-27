package by.kolbun.gdx;

import by.kolbun.gdx.logic.cards.TrophyCard;
import by.kolbun.gdx.logic.cards.TrophyType;
import by.kolbun.gdx.logic.deck.Deck;
import by.kolbun.gdx.logic.player.Player;
import by.kolbun.gdx.logic.towns.Town;
import by.kolbun.gdx.logic.towns.TownTable;
import by.kolbun.gdx.logic.towns.TownType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;


// удалить методы draw() в группах
// заменить спрайты в актерах на TextureRegion
// обработка нажатий и перетаскивание

public class World extends Stage {
    private final int playersCount;

    private ResourceLoader ress;

    private Deck initialDeck;
    private Deck deck;
    private TownTable townTable;
    private Array<Player> players;
    private Array<Player> playersQueue;
    private Player currentPlayer;
    private Actor draggedActor;

    public World(Viewport _viewport, SpriteBatch _batch, int _playersCount, ResourceLoader _ress) {
        super(_viewport, _batch);
        getBatch().setProjectionMatrix(getCamera().combined);

        this.playersCount = _playersCount;
        ress = _ress;

        ress.loadGraphicResources();
        initGameObjects();


    }

    /**
     * Initialize game objects
     * initialDeck
     * deck
     * townTable
     * players
     */
    private void initGameObjects() {
        initialDeck = new Deck(playersCount);
        townTable = new TownTable();
        players = new Array<Player>();
        players.add(new Player(true, "PlayerHuman"));
        players.add(new Player(false, "PlayerRed(2)"));
        players.add(new Player(false, "PlayerBlue(3)"));
        players.add(new Player(false, "PlayerYellow(4)"));

        playersQueue = new Array<Player>();
        playersQueue.addAll(players);

        currentPlayer = players.get(0);

        addActors();

        dealCards();

    }

    /**
     * тасуем колоду
     * раскладываем карты под города
     * сдаем каждому игроку по 5 карт
     */
    private void dealCards() {
        initialDeck.shuffle();
        deck = new Deck(initialDeck);

        Town tmpTown;
        for (Actor twn : townTable.getChildren()) {
            tmpTown = (Town) twn;
            if (tmpTown.getType() == TownType.CAP) continue;
            tmpTown.addUnder(deck.getRandomByTown(tmpTown.getType()));
        }

        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.getHand().getCards().addCard(deck.popCard());
            }
        }

        deck = null;
    }

    /**
     * Updating in-game parameters
     *
     * @param delta time from last render
     */
    public void update(float delta) {
        /*for (Actor actor : this.getActors()) {
            //@TODO
        }*/
    }

    /**
     * !отрисовка всех(!) объектов, как статичных, так и актеров
     */
    @Override
    public void draw() {
        getBatch().begin();

        getBatch().draw(ress.gameField, 0, 0, 800, 480);
        for (Actor actor : this.getActors()) {
            actor.draw(getBatch(), 1f);
        }
        getBatch().end();

    }

    /**
     * Adding actors to game World
     */
    private void addActors() {
        this.addActor(townTable);
        this.addActor(currentPlayer);
    }


    //input

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        draggedActor = hit(screenX, screenY, true);
        if (draggedActor != null) {
            draggedActor.toFront();
        }
        Gdx.app.log("World", "touchDown() (" + screenX + "," + screenY
                + ") actor: " + (draggedActor == null ? "NONE" : draggedActor.toString()));


        if (screenX < 30 && screenY < 30) {
//            townTable.putCard(currentPlayer.getHand().getCards().getRandomCard(), (Town)townTable.getChildren().get(0));
            ((Town) townTable.getChildren().get(0)).addUnder(new TrophyCard(TrophyType.MONEY0, TownType.NUL,
                    ress.priceCardTest, ress.cardBack));
        }//debug

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        super.touchDragged(screenX, screenY, pointer);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        draggedActor = null;

        return true;
    }

    //GAME_METHODS

}
