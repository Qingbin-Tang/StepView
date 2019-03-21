package com.example.stepview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stepview.R;

public class StepView extends FrameLayout {
    TextView tv_step; //第几步
    View line_top,line_bottom;//上下的线条
    private int stepPos;//对应的步数
    private int textColor;//中间的字体颜色
    public StepView(Context context, AttributeSet attributeSet) {

        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.view_step,this);
        tv_step =(TextView)findViewById(R.id.tv_step);
        line_top = (View) findViewById(R.id.line_top);
        line_bottom = (View)findViewById(R.id.line_bottom);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet,
                R.styleable.StepView);
        if (typedArray!=null){
            stepPos  = typedArray.getInt(R.styleable.StepView_stepPos,0);
//            textColor = typedArray.getColor(R.styleable.StepView_textColor,0);
        }
        if (stepPos == 0){
            line_top.setVisibility(GONE);
            line_bottom.setVisibility(VISIBLE);
            textColor= context.getResources().getColor(R.color.app_blue);
            tv_step.setBackgroundResource(R.mipmap.icon_ring);

        }else{
            line_top.setVisibility(VISIBLE);
            line_bottom.setVisibility(VISIBLE);
            textColor = context.getResources().getColor(R.color.app_white);
            tv_step.setBackgroundResource(R.mipmap.icon_circle);
        }
        tv_step.setText(stepPos+1+"");
        tv_step.setTextColor(textColor);
    }

    private void initView(Context context, AttributeSet attributeSet){

    }



    /**
     * 从布局中判断该view是否是最后一个  如果是最后一个不显示bottom
     */
    public void setStepView(){
        line_bottom.setVisibility(GONE);
    }
}
