class DismissalOrder extends  AbstractDocument {
    final String employee;
    String orderText;
    OrderStatus orderStatus;
    String reason;

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
                                   "\nСтатус: " + orderStatus +
                                   "\nПричина увольнения: " + reason + "\n");
    }
}
