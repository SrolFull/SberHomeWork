import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task2Main {
    private static List<AbstractDocument> listDocuments = new ArrayList<>();
    private static boolean isSimplePrint = false;


    public static void main (String[] args) {
        if (Arrays.asList(args).contains("-simple")) isSimplePrint = true;
        FillDocumentsList();
        PrintDocuments();
        ChangeAllOrderStatus();
        PrintDocuments();
    }

    private static void FillDocumentsList(){
        listDocuments.add(new AdmissionOrder(0,"Егор Егорович", "Принят на работу, так как красивый"));
        listDocuments.add(new DismissalOrder(1,"Егор Егорович","уволить работника","Разонравился"));
        listDocuments.add(new Letter(2,"Роман Романович","Сергей Сергеевич"));
    }

    private static void PrintDocuments(){
            listDocuments.forEach(doc -> doc.Print(isSimplePrint));
    }

    private static void ChangeAllOrderStatus(){
        listDocuments.forEach(document -> {
            if (document.getClass().equals(AdmissionOrder.class))
                ((AdmissionOrder) document).CompleteOrder();
            if (document.getClass().equals(DismissalOrder.class))
                ((DismissalOrder) document).CompleteOrder();
        });
    }

}
