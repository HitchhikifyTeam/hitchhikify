package org.hitchhikify;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hlib on 28.01.18.
 */

public class Tile extends LinearLayout {

    private Drawable mDrawable;
    private String mText;

    private TextView textView;

    public Tile(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View rootView = inflate(context, R.layout.tile, this);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Tile,
                0, 0);

        try {
            mDrawable = typedArray.getDrawable(R.styleable.Tile_image_src);
            mText = typedArray.getString(R.styleable.Tile_text);
        } finally {
            typedArray.recycle();
        }

        textView = (TextView) rootView.findViewById(R.id.tile_text_view);
        textView.setText(mText);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.tile_image_view);
        imageView.setImageDrawable(mDrawable);
    }

    public void setText(String text) {
        textView.setText(text);
        invalidate();
        requestLayout();
    }
}
