package cat.udl.hyperion.appmobils.tripletriad.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import cat.udl.hyperion.appmobils.tripletriad.R;
import cat.udl.hyperion.appmobils.tripletriad.models.Card;
import cat.udl.hyperion.appmobils.tripletriad.models.Cell;

public class CellViewModel extends ViewModel {
    private MutableLiveData<Cell> cell;
    private MutableLiveData<Card> card;

    private MutableLiveData<Integer> imageResource;

    public CellViewModel(Cell cell) {
        this.cell = new MutableLiveData<>(cell);
        this.card = new MutableLiveData<>(cell.getCard());

        imageResource = new MutableLiveData<>();
        updateImageResource();
    }

    public LiveData<Cell> getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell.setValue(cell);
        this.card.setValue(cell.getCard());
    }

    public LiveData<Card> getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card.setValue(card);
        updateImageResource();
    }

    private void updateImageResource() {
        if (card.getValue() != null) {
            imageResource.setValue(card.getValue().getImageResource());
        } else {
            imageResource.setValue(R.drawable.card_placeholder);
        }
    }

    public LiveData<Integer> getImageResource() {
        return imageResource;
    }
}
