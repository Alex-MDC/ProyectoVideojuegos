package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.mygdx.game.MyGdxGame;

public class LoadingScreen implements Screen {

    private MyGdxGame parent; // a field to store our orchestrator
    public LoadingScreen(MyGdxGame myGdxGame){
            parent = myGdxGame;     // setting the argument to our field.
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void render(float delta) {
        parent.changeScreen(MyGdxGame.MENU);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
    }
}
