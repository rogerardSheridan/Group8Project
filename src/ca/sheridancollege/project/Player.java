package ca.sheridancollege.project;

public class Player {
    
    private String name;
    private Hand hand;

    public Player() {
    }

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", hand=" + hand + '}';
    }
    
}
