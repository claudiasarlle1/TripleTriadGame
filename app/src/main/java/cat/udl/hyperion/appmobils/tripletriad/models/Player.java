package cat.udl.hyperion.appmobils.tripletriad.models;

import androidx.databinding.ObservableField;


import cat.udl.hyperion.appmobils.tripletriad.viewmodels.PlayerViewModel;

public class Player {
    private String name;
    private ObservableField<Deck> deck;
    private ObservableField<Integer> points;

    public Player(String name){
        this.name = name;
        this.points = new ObservableField<>(0);
        deck = new ObservableField<>(new Deck());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return deck.get();
    }

    public void setDeck(Deck deck) {
        this.deck.set(deck);
    }

    public ObservableField<Deck> getDeckField() {
        return deck;
    }

    public int getPoints() {
        return points.get();
    }

    public void setPoints(int points) {
        this.points.set(points);
    }

    public ObservableField<Integer> getPointsField() {
        return points;
    }

    public void notifyPropertyChanged(int fieldId) {
        deck.notifyChange();
        points.notifyChange();
    }

    public void addCardToDeck(Card card) {
        Deck currentDeck = deck.get();
        currentDeck.agregarCarta(card);
        deck.set(currentDeck);
       //TODO: notifyPropertyChanged(BR.DeckFragment);
    }

    public void removeCardFromDeck(Card card) {
        Deck currentDeck = deck.get();
        currentDeck.eliminarCarta(card);
        deck.set(currentDeck);
        //TODO: Notify?
    }

    public void shuffleDeck() {
        Deck currentDeck = deck.get();
        currentDeck.barajar();
        deck.set(currentDeck);
        //TODO NOTIFY
    }

    public void increasePoints(int points) {
        int currentPoints = this.points.get();
        currentPoints += points;
        this.points.set(currentPoints);
        //TODO: notifyPropertyChanged(BR.points);
    }

}
