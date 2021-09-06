class Letter extends AbstractDocument{
    private String from;
    private String to;

    Letter (int number, String from, String to) {
        super(number, "Письмо");
        this.from = from;
        this.to = to;
    }

    void Print(boolean isSimplePrint){
        super.Print(isSimplePrint);
        if (!isSimplePrint) System.out.println("От: " + from
                            + "\nКому: " + to + "\n");
    }

    public String getFrom () {
        return from;
    }

    public void setFrom (String from) {
        this.from = from;
    }

    public String getTo () {
        return to;
    }

    public void setTo (String to) {
        this.to = to;
    }
}
