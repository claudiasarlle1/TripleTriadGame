package cat.udl.hyperion.appmobils.tripletriad.viewmodels;



import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.hyperion.appmobils.tripletriad.models.Card;
import cat.udl.hyperion.appmobils.tripletriad.models.Deck;
import cat.udl.hyperion.appmobils.tripletriad.models.Player;

public class DeckViewModel extends ViewModel {
    private MutableLiveData<Deck> deck;
    private Player player;
    private MutableLiveData<Card> selectedCard;
    private static final String TAG = "DeckViewModel";

    public DeckViewModel() {
        Log.d("DeckViewModel", "Creando el DeckViewModel...");
        deck = new MutableLiveData<>();
        deck.setValue(new Deck());
        selectedCard = new MutableLiveData<>();
    }

    public LiveData<Deck> getDeck() {
        Log.d("DeckViewModel", "Obteniendo el DeckViewModel...");
        return deck;
    }

    public void addCardToDeck(Card card) {
        Deck currentDeck = deck.getValue();
        if (currentDeck != null) {
            currentDeck.agregarCarta(card);
            deck.postValue(currentDeck);
        }
    }

    public void removeCardFromDeck(Card card) {
        Deck currentDeck = deck.getValue();
        if (currentDeck != null) {
            currentDeck.eliminarCarta(card);
            deck.postValue(currentDeck);
        }
    }

    public void shuffleDeck() {
        Deck currentDeck = deck.getValue();
        if (currentDeck != null) {
            currentDeck.barajar();
            deck.postValue(currentDeck);
        }
    }

    public void setSelectedCard(Card card) {
        Log.d(TAG, "Estableciendo la carta seleccionada: " + (card != null ? card.getName() : "null"));
        selectedCard.setValue(card);
    }




    public LiveData<Card> getSelectedCard() {
        Log.d(TAG, "Obteniendo la carta seleccionada: " + (selectedCard.getValue() != null ? selectedCard.getValue().getName() : "null"));
        return selectedCard;
    }



}
