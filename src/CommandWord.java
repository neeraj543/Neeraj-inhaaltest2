public enum CommandWord {
    GO("go"), BACK("back"), LOOK("look"), TAKE("take"), DROP("drop"), EAT("eat"),
    HELP("?"), QUIT("stop"), UNKNOWN(""), USE("use");
    private String word;

    CommandWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
