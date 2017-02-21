package com.project.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shaomiao on 2017/2/21.
 * 一个自定义的状态栏
 *
 * 最外层布局是Relativelayout
 * 最左边一个ImageView
 * 中间是标题 上下左右居中
 * 最右边是两个ImageView 默认隐藏
 *
 */

public class StateBar extends RelativeLayout {

    private ImageView mLeftImage, mRightImage1, mRightImage2;
    private TextView mTitleView;

    /////////////////////////////////////////////


    private float titleTextSize;
    private String title;
    private int titleTextColor;

    private int leftImageViewWidth,leftImageViewHeigth,
            leftImageViewPaddingLeft,leftImageViewPaddingTop,leftImageViewPaddingRight,
            leftImageViewPaddingBottom,leftImageViewMarginLeft,
            leftImageViewMarginTop,leftImageViewMarginRight,leftImageViewMarginBottom;

    private int right1ImageViewWidth,right1ImageViewHeigth,
            right1ImageViewPaddingLeft,right1ImageViewPaddingTop,right1ImageViewPaddingRight,
            right1ImageViewPaddingBottom,right1ImageViewMarginLeft,
            right1ImageViewMarginTop,right1ImageViewMarginRight,right1ImageViewMarginBottom;

    private int right2ImageViewWidth,right2ImageViewHeigth,
            right2ImageViewPaddingLeft,right2ImageViewPaddingTop,right2ImageViewPaddingRight,
            right2ImageViewPaddingBottom,right2ImageViewMarginLeft,
            right2ImageViewMarginTop,right2ImageViewMarginRight,right2ImageViewMarginBottom;

    private int leftImageViewSrc,right1ImageViewSrc,right2ImageViewSrc;


    private LayoutParams leftLayoutParams, titleLayoutParams;

//    private topBarClickListenter topBarListenter;

    private topBarLeftImageViewClickListenter leftImageViewClickListenter;

    private topBarRight1ImageViewClickListenter right1ImageViewClickListenter;

    private topBarRight2ImageViewClickListenter right2ImageViewClickListenter;

    public void setTopBarLeftImageViewListenter(topBarLeftImageViewClickListenter listenter) {
        this.leftImageViewClickListenter = listenter;
    }

    public void setTopBarRight1ClickListenter(topBarRight1ImageViewClickListenter listenter) {
        this.right1ImageViewClickListenter = listenter;
    }

    public void setTopBarRight2ClickListenter(topBarRight2ImageViewClickListenter listenter){
        this.right2ImageViewClickListenter = listenter;
    }

//    public void setTopBarClickListenter(topBarClickListenter topBarClickListenter) {
//        this.topBarListenter = topBarClickListenter;
//    }

    private static final String TAG = "StateBar";

    public StateBar(Context context) {
        super(context);
    }

    public StateBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StateBar);

        // 标题默认配置
        title = ta.getString(R.styleable.StateBar_title);
        titleTextSize = ta.getDimension(R.styleable.StateBar_titleTextSize,20);
        titleTextColor = ta.getColor(R.styleable.StateBar_titleTextColor,0x7f040000);

        // 最左边ImageView配置
        leftImageViewWidth = (int) ta.getDimension(R.styleable.StateBar_leftImageViewWidth,20);
        leftImageViewHeigth = (int) ta.getDimension(R.styleable.StateBar_leftImageViewHeigth,20);
        leftImageViewMarginLeft = (int) ta.getDimension(R.styleable.StateBar_leftImageViewMarginLeft,0);
        leftImageViewMarginTop = (int) ta.getDimension(R.styleable.StateBar_leftImageViewMarginTop,0);
        leftImageViewMarginBottom = (int) ta.getDimension(R.styleable.StateBar_leftImageViewMarginBottom,0);
        leftImageViewMarginRight = (int) ta.getDimension(R.styleable.StateBar_leftImageViewMarginRight,0);
        leftImageViewPaddingLeft = (int) ta.getDimension(R.styleable.StateBar_leftImageViewPaddingLeft,0);
        leftImageViewPaddingTop = (int) ta.getDimension(R.styleable.StateBar_leftImageViewPaddingTop,0);
        leftImageViewPaddingRight = (int) ta.getDimension(R.styleable.StateBar_leftImageViewPaddingRight,0);
        leftImageViewPaddingBottom = (int) ta.getDimension(R.styleable.StateBar_leftImageViewPaddingBottom,0);
        leftImageViewSrc = ta.getResourceId(R.styleable.StateBar_leftImageViewSrc,0);

        // 最右边ImageView从左到右第一个 默认配置
        right1ImageViewWidth = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewWidth,20);
        right1ImageViewHeigth = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewHeigth,20);
        right1ImageViewMarginLeft = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewMarginLeft,0);
        right1ImageViewMarginTop = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewMarginTop,0);
        right1ImageViewMarginBottom = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewMarginBottom,0);
        right1ImageViewMarginRight = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewMarginRight,0);
        right1ImageViewPaddingLeft = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewPaddingLeft,0);
        right1ImageViewPaddingTop = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewPaddingTop,0);
        right1ImageViewPaddingRight = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewPaddingRight,0);
        right1ImageViewPaddingBottom = (int) ta.getDimension(R.styleable.StateBar_right1ImageViewPaddingBottom,0);
        right1ImageViewSrc = ta.getResourceId(R.styleable.StateBar_right1ImageViewSrc,0);

        // 最右边第二个ImageView 从左到右第二个 默认配置
        right2ImageViewWidth = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewWidth,20);
        right2ImageViewHeigth = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewHeigth,20);
        right2ImageViewMarginLeft = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewMarginLeft,0);
        right2ImageViewMarginTop = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewMarginTop,0);
        right2ImageViewMarginBottom = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewMarginBottom,0);
        right2ImageViewMarginRight = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewMarginRight,0);
        right2ImageViewPaddingLeft = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewPaddingLeft,0);
        right2ImageViewPaddingTop = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewPaddingTop,0);
        right2ImageViewPaddingRight = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewPaddingRight,0);
        right2ImageViewPaddingBottom = (int) ta.getDimension(R.styleable.StateBar_right2ImageViewPaddingBottom,0);
        right2ImageViewSrc = ta.getResourceId(R.styleable.StateBar_right2ImageViewSrc,0);

        ta.recycle();

        // 初始化控件
        mLeftImage = new ImageView(context);
        mRightImage1 = new ImageView(context);
        mRightImage2 = new ImageView(context);
        mTitleView = new TextView(context);

        mTitleView.setText(title);
        mTitleView.setTextSize(titleTextSize);
        mTitleView.setTextColor(titleTextColor);
        mTitleView.setGravity(Gravity.CENTER_VERTICAL);

        mLeftImage.setImageResource(leftImageViewSrc);
        mLeftImage.setPadding(leftImageViewPaddingLeft,leftImageViewPaddingTop,leftImageViewPaddingRight,leftImageViewPaddingBottom);

        mRightImage1.setImageResource(right1ImageViewSrc);
        mRightImage1.setVisibility(View.VISIBLE);
        mRightImage1.setPadding(right1ImageViewPaddingLeft,right1ImageViewPaddingTop,right1ImageViewPaddingRight,right1ImageViewPaddingBottom);

        mRightImage2.setImageResource(right2ImageViewSrc);
        mRightImage1.setPadding(right2ImageViewPaddingLeft,right2ImageViewPaddingTop,right2ImageViewPaddingRight,right2ImageViewPaddingBottom);

        // 最左边布局
        leftLayoutParams = new LayoutParams(leftImageViewWidth,
                leftImageViewHeigth);
        leftLayoutParams.setMargins(leftImageViewMarginLeft,leftImageViewMarginTop,leftImageViewMarginRight,leftImageViewMarginBottom);

        leftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        // 添加到最外层的RelativeLayout
        addView(mLeftImage,leftLayoutParams);

        // 标题栏布局
        titleLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
        addView(mTitleView,titleLayoutParams);

        LinearLayout linearLayout = new LinearLayout(context);
        LayoutParams linearLayoutParams = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutParams.addRule(LinearLayout.VERTICAL);
        linearLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        LayoutParams rightImage1Params = new LayoutParams(right1ImageViewWidth,right1ImageViewHeigth);
        LayoutParams rightImage2Params = new LayoutParams(right2ImageViewWidth,right2ImageViewHeigth);
        rightImage1Params.setMargins(right1ImageViewMarginLeft,right1ImageViewMarginTop,right1ImageViewMarginRight,right1ImageViewMarginBottom);
        rightImage2Params.setMargins(right2ImageViewMarginLeft,right2ImageViewMarginTop,right2ImageViewMarginRight,right2ImageViewMarginBottom);

        linearLayout.addView(mRightImage1,rightImage1Params);
        linearLayout.addView(mRightImage2,rightImage2Params);

        addView(linearLayout,linearLayoutParams);
        mLeftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftImageViewClickListenter.onClick();
            }
        });
        mRightImage1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                right1ImageViewClickListenter.onClick();
            }
        });
        mRightImage2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                right2ImageViewClickListenter.onClick();
            }
        });
    }


    public void setLeftImageViewVisable(boolean flag){
        if (flag) {
            mLeftImage.setVisibility(View.VISIBLE);
        } else {
            mLeftImage.setVisibility(View.GONE);
        }
    }

    public void setRight1ImageView(boolean flag){
        if (flag) {
            mRightImage1.setVisibility(View.VISIBLE);
        } else {
            mRightImage1.setVisibility(View.GONE);
        }
    }

    public void setRight2ImageView(boolean flag){
        if (flag) {
            mRightImage2.setVisibility(View.VISIBLE);
        } else {
            mRightImage2.setVisibility(View.GONE);
        }
    }

    public void setTitleView(boolean flag){
        if (flag) {
            mTitleView.setVisibility(View.VISIBLE);
        } else {
            mTitleView.setVisibility(View.GONE);
        }
    }

//    public interface topBarClickListenter {
//        void leftClick();
//        void right1Click();
//        void right2Click();
//    }

    public interface topBarLeftImageViewClickListenter {
        void onClick();
    }

    public interface topBarRight1ImageViewClickListenter {
        void onClick();
    }

    public interface topBarRight2ImageViewClickListenter {
        void onClick();
    }

}
