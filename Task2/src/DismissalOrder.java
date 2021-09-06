class DismissalOrder extends  AbstractDocument {
    private final String employee;
    private String orderText;
    private OrderStatus orderStatus;
    private String reason;

    DismissalOrder (int number, String employee, String orderText, String reason) {
        super(number, "Приказ об увольнение");
        this.employee = employee;
        this.orderText = orderText;
        orderStatus = OrderStatus.CREATED;
        this.reason = reason;
    }

    void CompleteOrder(){
        if (orderStatus.equals(OrderStatus.CREATED)) orderStatus = OrderStatus.COMPLETED;
    }

    void Print(boolean isSimplePrint){
        super.Print(isSimplePrint);
        if (!isSimplePrint) System.out.println("Сотрудник: " + employee +
                                   "\n" + orderText +
                                   "\nСтатус: " + orderStatus.statusRu +
                                   "\nПричина увольнения: " + reason + "\n");
    }
}
