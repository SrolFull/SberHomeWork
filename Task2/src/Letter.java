class Letter extends AbstractDocument{
    String from;
    String to;

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
}
