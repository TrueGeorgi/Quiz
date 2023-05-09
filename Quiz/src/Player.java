public class Player {

                                                  // Instance variables

    String username;

    int rightAnswers = 0;

    int wrongAnswers = 0;

                                                 // Constructors


    public Player(String username) {
        this.username = username;
    }

                                                 // Setters


    public void setUsername(String username) {
        this.username = username;
    }

    public void setRightAnswers() {
        this.rightAnswers += 1;
    }

    public void setWrongAnswers() {
        this.wrongAnswers += 1;
    }

                                                 // Getters

    public String getUsername() {
        return username;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }
}
