package by.kolbun.gdx.screens;

import by.kolbun.gdx.ResourceLoader;
import by.kolbun.gdx.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ResourceLoader resources;

    private int worldWidth = 800;
    private int worldHeight = 480;
    private float w = Gdx.graphics.getWidth();
    private float h = Gdx.graphics.getHeight();

    private int playersCount = 4;

    private World world;


    public GameScreen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(true, w, h);
        batch = new SpriteBatch();
        resources = ResourceLoader.getLoader();
        world = new World(new StretchViewport(worldWidth, worldHeight, camera), batch, playersCount, resources);

        Gdx.input.setInputProcessor(world);
    }

    /**
     * Called when this screen becomes the current screen for a Game.
     */
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(10 / 255.0f, 15 / 255.0f, 230 / 255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.update(delta);
        world.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
