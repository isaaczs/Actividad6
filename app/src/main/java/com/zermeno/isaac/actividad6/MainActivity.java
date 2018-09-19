package com.zermeno.isaac.actividad6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Scene mAScene;
    Scene mAnotherScene;
    ViewGroup mSceneRoot;
    Transition transitionMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the scene root for the scenes in this app
        //Este es el FrameLayout = id.scene_root
        mSceneRoot = (ViewGroup)findViewById(R.id.root_layout);

        /**
         * R    .layout         .a_scene
         * R    .transition     .fade_transition
         */

        // Create the scenes
        mAScene =   Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        mAnotherScene = Scene.getSceneForLayout(mSceneRoot, R.layout.another_scene, this);
        transitionMgr  = TransitionInflater.from(this).inflateTransition(R.transition.fade_transition);
    }

    public void boton1(View view) {
        TransitionManager.go(mAScene, transitionMgr);
    }

    public void boton2(View view) {
        TransitionManager.go(mAnotherScene, transitionMgr);
    }

}
