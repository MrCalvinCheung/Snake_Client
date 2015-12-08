package SDK;

import java.sql.Date;

/**
 * This class is a template from GitHub
 * Has all the variables for what a game needs to contain
 */
public class Game {
    //Creating the variables needed for the game
    private int gameId;
    private Gamer winner;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private String status;
    private Date created;
    private int mapSize;

    public Game(){}

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMapSize() {
        return mapSize;
    }

    /**
     * Sets mapsize of the game platform
     * @param mapSize
     */
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    /**
     * method to get name of the game
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * method to set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  get method to GameID
     * @return Game id
     */
    //Creating get/set method for all the variables, so they can be used by other classes
    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }

    public Gamer getHost(){
        return host;
    }

    /**
     * set the host of the game
     * @param host
     */
    public void setHost(Gamer host){
        this.host = host;
    }

    /**
     * gets opponent
     * @return opponent
     */
    public Gamer getOpponent(){
        return opponent;
    }

    /**
     * set opponent method
     * @param opponent
     */
    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    /**
     * to get the winner of the game
     * @return winner
     */
    public Gamer getWinner() {
        return winner;
    }

    public void setWinner(Gamer winner) {
        this.winner = winner;
    }
} //end of class
