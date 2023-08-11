package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {
    
    private ArrayList<Player> players;
    private ArrayList<Card> deck;
    private ArrayList<Card> discardDeck;
    private Card rulerCard;

    public Game() {
        this.players = new ArrayList<>();
        this.deck = new ArrayList<>();
        generateDeck();
        shuffleDeck();
        this.discardDeck = new ArrayList<>();
        generateRulerCard();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDiscardDeck() {
        return discardDeck;
    }

    public void setDiscardDeck(ArrayList<Card> discardDeck) {
        this.discardDeck = discardDeck;
    }

    public Card getRulerCard() {
        return rulerCard;
    }

    public void setRulerCard(Card rulerCard) {
        this.rulerCard = rulerCard;
    }
    
    private void generateDeck(){
        for(int i=0; i<4; i++){
            for(int j=1; j<=12; j++){
                if(j==8 || j==9)
                    continue;
                switch(i){
                    case 0:
                        deck.add(new Card(j, CardSuit.SWORD));
                        break;
                    case 1:
                        deck.add(new Card(j, CardSuit.CUP));
                        break;
                    case 2:
                        deck.add(new Card(j, CardSuit.COIN));
                        break;
                    case 3:
                        deck.add(new Card(j, CardSuit.CLUB));
                        break;
                }
            }
        }
    }
    
    private void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    private void generateRulerCard(){
        Random random = new Random();
        int index = random.nextInt(0, this.deck.size());
        this.rulerCard = deck.remove(index);
    }
    
    public void addPlayer(String name){
        Player player = new Player();
        player.setName(name);
        player.setHand(new Hand());
        generatePlayerHand(player);
        this.players.add(player);
    }
    
    private void generatePlayerHand(Player player){
        Random random = new Random();
        int index = 0;
        for(int i=0; i<5; i++){
            index = random.nextInt(0, this.deck.size());
            player.getHand().add(deck.remove(index));
        }
    }
    
    public boolean drawFromDeck(Player player){
        if(!deck.isEmpty()){
            player.getHand().add(deck.remove(0));
            return true;
        }
        return false;
    }
    
    public boolean drawFormDiscard(Player player){
        if(!discardDeck.isEmpty()){
            player.getHand().addAll(discardDeck);
            cleanDiscard();
            return true;
        }
        return false;
    }
    
    public void cleanDiscard(){
        discardDeck.clear();
    }

    @Override
    public String toString() {
        return "Game{" + "players=" + players + ", deck=" + deck + ", discardDeck=" + discardDeck + ", rulerCard=" + rulerCard + '}';
    }
}
