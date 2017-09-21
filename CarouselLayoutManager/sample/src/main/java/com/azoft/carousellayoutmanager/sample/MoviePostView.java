package com.azoft.carousellayoutmanager.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ThomasWang
 * @since 2017/9/21 21:31
 */

public class MoviePostView extends RelativeLayout {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.text_layout)
    LinearLayout textLayout;

    private static final float ratio = 258 / 375.0f;

    public MoviePostView(Context context) {
        this(context, null);
    }

    public MoviePostView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoviePostView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_demo, this, true);
        ButterKnife.bind(this, this);
    }

    public ImageView getImage() {
        return image;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width * ratio);
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
