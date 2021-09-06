abstract class AbstractDocument {
    private final int number;
    private String  name;

    AbstractDocument (int number, String name){
        this.number = number;
        this.name = name;
    }

    void Print(boolean isSimplePrint){
        System.out.print("\nНомер документа: " + number
                                 + "\nИмя документа: " + name  + "\n");
    }

}
