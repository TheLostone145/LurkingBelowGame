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
        x = 50;
        y = 50;
    }

    @Override
    public void render() {
        // Handle input
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && y + characterTexture.getHeight() * 2 < Gdx.graphics.getHeight()) {
            y += 50.0F;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && y > 0) {
            y -= 50.0F;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && x > 0) {
            x -= 50.0F;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && x + characterTexture.getWidth() * 2 < Gdx.graphics.getWidth()) {
            x += 50.0F;
        }
        
        
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
