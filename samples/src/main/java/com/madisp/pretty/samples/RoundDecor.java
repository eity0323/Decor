package com.madisp.pretty.samples;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.TypedValue;
import android.widget.ImageView;

import com.madisp.pretty.AttrsDecor;

import org.jetbrains.annotations.NotNull;

/**
 * Created by cheikhna on 17/02/2015.
 */
public class RoundDecor extends AttrsDecor<ImageView> {

    @NotNull
    @Override
    protected int[] attrs() {
        return new int[] {R.attr.round, R.attr.cornerRadius};
    }

    @NotNull
    @Override
    protected Class<ImageView> clazz() {
        return ImageView.class;
    }

    @Override
    protected void apply(@NonNull ImageView view, int attr, TypedValue value) {
        Bitmap bitmap = BitmapFactory.decodeResource(view.getContext().getResources(), value.resourceId);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                view.getContext().getResources(), bitmap);
        roundedBitmapDrawable.setCornerRadius(TypedValue.complexToDimension(value.data,
                                view.getResources().getDisplayMetrics()));
        view.setImageDrawable(roundedBitmapDrawable);
    }

}