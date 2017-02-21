package com.project.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/21.
 */

public class TopBar extends RelativeLayout  {

    private ImageView leftImage, rightImage1,rightImage2;
    private TextView titleView;

    /////////////////////////////////////////////
    private Drawable leftImageDrawable, rightImage1Drawable, rightImage2Drawable;
    private float titleSize;
    private String title;

    private RelativeLayout.LayoutParams leftLayoutParams, titleLayoutParams, rightLayoutParams1,rightLayoutParams2;


    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StateBar);


//        leftImageDrawable = ta.getDrawable(R.styleable.TopBar_leftImageBackgroud);
//        rightImage1Drawable = ta.getDrawable(R.styleable.TopBar_rightImage1Backgroud);
//        rightImage2Drawable = ta.getDrawable(R.styleable.TopBar_rightImage2Backgroud);
        title = ta.getString(R.styleable.StateBar_title);

        ta.recycle();

        leftImage = new ImageView(context);
        rightImage1 = new ImageView(context);
        rightImage2 = new ImageView(context);
        titleView = new TextView(context);

        titleView.setText(title);
        titleView.setTextSize(20);
        titleView.setGravity(Gravity.CENTER);
        leftImage.setBackground(leftImageDrawable);
        rightImage1.setBackground(rightImage1Drawable);
        rightImage2.setBackground(rightImage1Drawable);
        rightImage1.setId(R.id.rightImageid);

        leftLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        addView(leftImage,leftLayoutParams);

        rightLayoutParams1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        rightLayoutParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        addView(rightImage1, rightLayoutParams1);

        rightLayoutParams2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        rightLayoutParams2.addRule(RelativeLayout.ALIGN_PARENT_LEFT, rightImage1.getId());
        addView(rightImage2,rightLayoutParams2);

        titleLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        addView(titleView,titleLayoutParams);


    }


    public void setImageViewVisable(int id, boolean flag) {
        if(flag) {
            // visible
            if (id == R.id.rightImageid) {
                rightImage1.setVisibility(View.VISIBLE);

            }
        } else {
            if (id == R.id.rightImageid) {
                rightImage1.setVisibility(View.GONE);

            }
        }
    }
}
