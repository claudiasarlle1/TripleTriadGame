package cat.udl.hyperion.appmobils.tripletriad;

import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import cat.udl.hyperion.appmobils.tripletriad.models.Card;

public class BindingAdapters {

    @BindingAdapter("card")
    public static void setCardImage(ImageButton imageButton, Card card) {
        if (card == null) {
            return;
        }

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.card_placeholder)
                .error(R.drawable.card_placeholder);

        Glide.with(imageButton.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(card.getImageResource())
                .into(imageButton);
    }

    @BindingAdapter("app:srcCompat")
    public static void setSrcCompat(ImageView view, int resourceId) {
        view.setImageResource(resourceId);
    }
}
