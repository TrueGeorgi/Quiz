public class Question {

                                            // Instance variables

    String question;
    String optionA;

    String optionB;

    String optionC;

    char correctOption;

    String correctOptionString;

    String createdBy;

                                           // Constructors

    public Question(String question, String optionA, String optionB, String optionC, char correctOption) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correctOption = correctOption;
        if (correctOption == 'A') {
            correctOptionString = optionA;
        } else if (correctOption == 'B') {
            correctOptionString = optionB;
        } else {
            correctOptionString = optionC;
        }
        this.createdBy = "Georgi Iliev";
    }

    public Question(String question, String optionA, String optionB, String optionC, char correctOption, String createdBy) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.correctOption = correctOption;
        if (correctOption == 'A') {
            correctOptionString = optionA;
        } else if (correctOption == 'B') {
            correctOptionString = optionB;
        } else {
            correctOptionString = optionC;
        }
        this.createdBy = createdBy;
    }

                                            // Getters

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public char getCorrectOption() {
        return correctOption;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCorrectOptionString() {
        return correctOptionString;
    }
}
