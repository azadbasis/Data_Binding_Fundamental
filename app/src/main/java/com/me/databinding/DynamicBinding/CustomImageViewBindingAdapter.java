package com.me.databinding.DynamicBinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;


public class CustomImageViewBindingAdapter {

    private static Picasso picasso;

    private static Picasso getPicasso(Context context) {
        if (picasso == null){
            picasso = Picasso.get();
        }
        return picasso;
    }

    @BindingAdapter("bind:imageUrl")
    public static void setImage(ImageView view, String imageUrl)
    {
        Picasso picasso = getPicasso(view.getContext());
        picasso.load(imageUrl).into(view);
    }

    @BindingAdapter({"bind:imageUrl", "bind:imagePlaceholder", "bind:imageError"})
    public static void setImage(ImageView view, String imageUrl, Drawable imagePlaceholder,
                                Drawable imageError)
    {
        Picasso picasso = getPicasso(view.getContext());
        picasso.load(imageUrl)
                .placeholder(imagePlaceholder)
                .error(imageError)
                .into(view);
    }
}
