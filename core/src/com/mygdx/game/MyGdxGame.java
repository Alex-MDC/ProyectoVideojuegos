package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.views.EndScreen;
import com.mygdx.game.views.LoadingScreen;
import com.mygdx.game.views.MainScreen;
import com.mygdx.game.views.MenuScreen;
import com.mygdx.game.views.PreferencesScreen;

public class MyGdxGame extends Game {
    private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;
    private AppPreferences preferences;

    public final static int MENU = 0;
    public final static int PREFERENCES = 1;
    public final static int APPLICATION = 2;
    public final static int ENDGAME = 3;

    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this); // added (this)
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if(mainScreen == null) mainScreen = new MainScreen(this); //added (this)
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);  // added (this)
                this.setScreen(endScreen);
                break;
        }
    }

    @Override
    public void create () {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
        preferences = new AppPreferences();
    }

    @Override
    public void render () {
        super.render();
    }

    public AppPreferences getPreferences() {
        return this.preferences;
    }
}
