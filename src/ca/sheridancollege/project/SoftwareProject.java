package ca.sheridancollege.project;

public class SoftwareProject {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game);
        game.addPlayer("Player1");
        game.addPlayer("Player2");
        System.out.println(game);
        game.drawFromDeck(game.getPlayers().get(0));
        System.out.println(game);
    }
    
}
