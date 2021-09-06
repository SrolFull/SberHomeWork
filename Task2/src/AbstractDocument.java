abstract class AbstractDocument {
    final int number;
    String name;

    AbstractDocument (int number, String name){
        this.number = number;
        this.name = name;
    }

    void Print(boolean isSimplePrint){
        System.out.print("Номер документа: " + number
                                 + "\nИмя документа: " + name  + "\n\n");
    }

}
