package com.azoft.carousellayoutmanager.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.azoft.carousellayoutmanager.ExpandableItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author ThomasWang
 * @since 2017/9/21 21:31
 */

public class MoviePosterView extends RelativeLayout implements ExpandableItem {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.text_layout)
    LinearLayout textLayout;

    private static final float EXPAND_RATIO = 258 / 375.0f;
    private static final float FOLD_RATIO = 110 / 375.0f;

    public MoviePosterView(Context context) {
        this(context, null);
    }

    public MoviePosterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoviePosterView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        int height = (int) (width * EXPAND_RATIO);
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }

    @Override
    public int getExpandSize() {
        return (int) (getMeasuredWidth() * EXPAND_RATIO);
    }

    @Override
    public int getFoldSize() {
        return (int) (getMeasuredWidth() * FOLD_RATIO);
    }
}
