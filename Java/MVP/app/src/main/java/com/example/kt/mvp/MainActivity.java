package com.example.kt.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainViewInterface, View.OnClickListener
{
    private Presenter mPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = this.findViewById(R.id.button1);
        button.setOnClickListener(this);

        this.mPresenter = new Presenter(this);
    }

    @Override
    public void updateTextView(String text)
    {
        TextView textView = this.findViewById(R.id.textView1);
        textView.setText(text);
    }

    @Override
    public void onClick(View view)
    {
        this.mPresenter.onButtonClick();
    }
}
