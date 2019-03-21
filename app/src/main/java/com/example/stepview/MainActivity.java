package com.example.stepview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.stepview.view.StepView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_root = (LinearLayout)findViewById(R.id.ll_root);
        StepView stepView = (StepView) ll_root.getChildAt(ll_root.getChildCount()-1);
        stepView.setStepView();
    }
}
