package io.github.LurkingBelow.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture characterTexture;
    private float x, y;
    private float speed = 200; // pixels per second

    @Override
    public void create() {
        batch = new SpriteBatch();
        characterTexture = new Texture("character.png"); // Make sure character.png is in assets
        x = 100;
        y = 100;
    }

    @Override
    public void render() {
        // Handle input
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += speed * Gdx.graphics.getDeltaTime();

        // Render the character
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        batch.begin();
        batch.draw(characterTexture, x, y, characterTexture.getWidth() * 2, characterTexture.getHeight() * 2);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        characterTexture.dispose();
    }
}
