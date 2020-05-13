package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;

public class MainScreen implements Screen {

    private MyGdxGame parent;
    private final Stage stage;
    private Sprite sprite;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;

    public MainScreen(MyGdxGame myGdxGame){
        parent = myGdxGame;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }
        @Override
        public void show() {
        //todo esto luego lo movemos al pause por ahora así se queda
            Table table = new Table();
            table.setFillParent(true);
            table.setDebug(true);
            stage.addActor(table);
            Skin skin = new Skin(Gdx.files.internal("skin/neon-ui.json"));

            TextButton resume = new TextButton("Resume", skin);
            TextButton restart = new TextButton("Restart", skin);
            TextButton save = new TextButton("Save", skin);
            TextButton load = new TextButton("Load", skin);
            TextButton quit = new TextButton("Quit", skin);
            TextField pause = new TextField("Pause", skin);

            table.add(pause).fillX().uniformX();
            table.row().pad(10, 0, 0, 0);
            table.add(resume).fillX().uniformX();
            table.row();
            table.add(restart).fillX().uniformX();
            table.row();
            table.add(save).fillX().uniformX();
            table.row();
            table.add(load).fillX().uniformX();
            table.row();
            table.add(quit).fillX().uniformX();

            quit.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    Gdx.app.exit();
                }
            });

            float w = Gdx.graphics.getWidth();
            float h = Gdx.graphics.getHeight();
            camera = new OrthographicCamera(1, h / w);
            batch = new SpriteBatch();
            texture = new Texture(Gdx.files.internal("background.png"));
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            TextureRegion region =
                    new TextureRegion(texture, 0, 0, 800, 420);
            sprite = new Sprite(region);
            sprite.setSize(0.9f,
                    0.9f * sprite.getHeight() / sprite.getWidth() );
            sprite.setOrigin(sprite.getWidth() / 2,
                    sprite.getHeight() / 2);
            sprite.setPosition(-sprite.getWidth() / 2,
                    -sprite.getHeight() / 2);

        }

        @Override
        public void render(float delta) {
            Gdx.gl.glClearColor( 0, 0, 0, 0 );
            Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
            batch.setProjectionMatrix(camera.combined);
            batch.begin();
            sprite.draw(batch);
            batch.end();
            //Gdx.gl.glClearColor(0f, 0f, 0f, 1);
            //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
            stage.draw();
        }

        @Override
        public void resize(int width, int height) {
            stage.getViewport().update(width, height, true);
        }

        @Override
        public void pause() {
            // TODO Auto-generated method stub
        }

        @Override
        public void resume() {
            // TODO Auto-generated method stub
        }

        @Override
        public void hide() {
            // TODO Auto-generated method stub
        }

        @Override
        public void dispose() {
            stage.dispose();
        }

}
