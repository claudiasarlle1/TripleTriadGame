package cat.udl.hyperion.appmobils.tripletriad;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.udl.hyperion.appmobils.tripletriad.databinding.ItemCardBinding;
import cat.udl.hyperion.appmobils.tripletriad.models.Card;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Card> cards;
    private OnCardClickListener onCardClickListener;

    public CardAdapter(List<Card> cards, OnCardClickListener onCardClickListener) {
        this.cards = cards;
        this.onCardClickListener = onCardClickListener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_card, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.binding.setItemCard(card);
        holder.binding.cardImage.setOnClickListener((v -> onCardClickListener.onCardClick(card)));
        //TODO: Revisar que no s'hagi de crear un objecte cardImageButton
        //holder.binding.cardImageButton.setOnClickListener(v -> onCardClickListener.onCardClick(card));
    }

    @Override
    public int getItemCount() {
        return cards != null ? cards.size() : 0;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ItemCardBinding binding;

        public CardViewHolder(ItemCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
