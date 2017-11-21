package by.kolbun.gdx;

import static by.kolbun.gdx.logic.player.OwnerType.*;

import by.kolbun.gdx.logic.player.OwnerType;
import by.kolbun.gdx.logic.util.Deck;
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
    private static World world;

    private final int playersCount;

    private ResourceLoader ress;

    private Deck deck;
    private TownTable townTable;
    private Array<Player> players;
    private Array<Player> playersQueue;
    private Player currentPlayer;
    private Actor touchedActor;

    private World(Viewport _viewport, SpriteBatch _batch, int _playersCount, ResourceLoader _ress) {
        super(_viewport, _batch);
        getBatch().setProjectionMatrix(getCamera().combined);

        playersCount = _playersCount;
        ress = _ress;

        ress.loadGraphicResources();
        initGameObjects();
    }

    public static World initInstance(Viewport _viewport, SpriteBatch _batch, int _playersCount, ResourceLoader _ress) {
        if (world == null) {
            world = new World(_viewport, _batch, _playersCount, _ress);
        }
        return world;
    }

    public static World getInstance() {
        return world;
    }

    private void initGameObjects() {
        townTable = new TownTable();
        players = new Array<Player>();
        playersQueue = new Array<Player>();
        players.add(new Player(true, "PlayerGreen", GREEN));
        players.add(new Player(false, "PlayerRed", RED));
        players.add(new Player(false, "PlayerBlue", BLUE));
        players.add(new Player(false, "PlayerYellow", YELLOW));

        addActors();

//        startGame();
    }

    /**
     * тасуем колоду
     * раскладываем карты под города
     * сдаем каждому игроку по 5 карт
     */
    private void dealCards() {
        deck = new Deck(playersCount);
        deck.shuffle();

        Town tmpTown;
        for (Actor twn : townTable.getChildren()) {
            tmpTown = (Town) twn;
            if (tmpTown.getType() == TownType.CAP) continue;
            tmpTown.addSimpleUnder(deck.getRandomByTown(tmpTown.getType()));
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

    private void addActors() {
        this.addActor(townTable);
        for (Player player : players)
            this.addActor(player);
    }



    /*-----------------------------------------------------------------------*/

    //GAME_FLOW

    public void startGame() {
        Gdx.app.log(this.getClass().getSimpleName(), "startGame()");
        startRound();
        //5th round
    }

    private int roundsLeft = 5;
    private void startRound() {
        if (roundsLeft-- == 0) {
            endGame();
        }

        Gdx.app.log(this.getClass().getSimpleName(), "startRound()");

        dealCards();
        startCircle();
    }

    private void startCircle() {
        if (AllCardHandsAreEmpty()) {
            giveTrophies();
            resetNewRound();
            startRound();
            return;
        }

        Gdx.app.log(this.getClass().getSimpleName(), "startCircle()");

        playersQueue.addAll(players);
        playersQueue.reverse();
        for (Player player : playersQueue) {
            player.setVisible(false);
        }

        startTurn();
    }

    private void startTurn() {
        Gdx.app.log(this.getClass().getSimpleName(), "startTurn()");

        if (currentPlayer != null)
            currentPlayer.setVisible(false);
        currentPlayer = playersQueue.pop();
        currentPlayer.setVisible(true);
        currentPlayer.setTurnDone(false);
    }

    private void endTurn() {
        if (playersQueue.size == 0) {
            startCircle();
            return;
        }

        startTurn();
    }

    private void endGame() {
        Gdx.app.log("GameFlow", "Game is done.");
    }

    //game flow - utils

    private void giveTrophies() {

    }

    // TODO: 07.10.2017 можно написать класс для очереди игроков, включить методы для удобства листания по кругу
    private void resetNewRound() {
        players.insert(4, players.get(0));
        players.removeIndex(0);

        for (Player player : players) {
            player.resetNewRound();
        }
        townTable.resetNewRound();
    }


    //input

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touchedActor = hit(screenX, screenY, true);
/*
        StringBuilder sb = new StringBuilder();
        Actor par = null;
        if (touchedActor != null)
            par = touchedActor.getParent();
        sb.append(touchedActor.getName()).append("<");
        while (par != null) {
            sb.append(par.getName()).append("<");
            par = par.getParent();
        }*/
        Gdx.app.log("World", "touchDown() (" + screenX + "," + screenY
                + ") actor: " + (touchedActor == null ? "NONE" : touchedActor.getName()));
  /*      Gdx.app.log("World", "touchDown() (" + screenX + "," + screenY
                + ") actor: " + sb.toString());*/


        /*if (screenX < 30 && screenY < 30) {
//            townTable.putCard(currentPlayer.getHand().getCards().getRandomCard(), (Town)townTable.getChildren().get(0));
            ((Town) townTable.getChildren().get(0)).addUnder(new TrophyCard(TrophyType.MONEY0, TownType.NUL,
                    ress.priceCardTest, ress.cardBack));
        }//debug - добавляет трофи-Money0 под город-0*/

        /*if (screenX < 30 && screenY < 30) {
            currentPlayer = players.get(1);
            ((Town)townTable.getChildren().get(0)).addHunter(new SmallHunter(
                    ress.smallHuntRed, ress.huntPointRed, OwnerType.RED));
            currentPlayer = players.get(0);
        }//debug - добавляет хантеров в 0-город от красного игрока*/

        if (screenX > 770 && screenY > 450) {
            if (!currentPlayer.isTurnDone()) {
                Gdx.app.log("Debug", "Вы не совершили действий, перенесите карту");
            } else {
                endTurn();
            }

        } //debug - переход хода

        if (screenX < 30 && screenY > 450) {
            Gdx.app.log("Debug", "Принудительное начало нового раунда");
            resetNewRound();
            startRound();

        } //debug - новый раунд

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

        touchedActor = null;

        return true;
    }

    //GAME_METHODS

    public String getName() {
        return "World";
    }

    public TownTable getTownTable() {
        return townTable;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Array<Player> getPlayersQueue() {
        return playersQueue;
    }

    private boolean AllCardHandsAreEmpty() {
        for (Player player : players) {
            if (player.getHand().getCards().hasChildren()) return false;
        }
        return true;
    }

    public Player getPlayerByOwner(OwnerType owner) {
        for (Player player : players) {
            if (player.getOwner() == owner) return player;
        }
        return null;
    }
}
// наследовать класс от Actor и наследоваться от него всем актерам, которые draggable??
// по примеру сделать для дургих draggable актеров.
// дать имена всем группам-актерам вниз по иерархии
// очередность прорисовки актеров -> Actor.toFront();
