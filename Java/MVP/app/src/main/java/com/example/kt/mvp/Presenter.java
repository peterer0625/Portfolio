package com.example.kt.mvp;

/**
 * Created by KT on 2018/1/29.
 */

public class Presenter
{
    private MainViewInterface mMainViewInferface = null;
    private Model mModel = null;

    public Presenter(MainViewInterface mainViewInterface)
    {
        this.mMainViewInferface = mainViewInterface;
        this.mModel = new Model();
    }

    public void onButtonClick()
    {
        // When button click

        // Get text from model
        String text = this.mModel.getText();

        // Update text to main view interface
        this.mMainViewInferface.updateTextView(text);
    }

}
