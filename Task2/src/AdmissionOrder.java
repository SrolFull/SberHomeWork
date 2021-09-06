class AdmissionOrder extends AbstractDocument {
    final String employee;
    String orderText;
    OrderStatus orderStatus;

    AdmissionOrder (int number, String employee, String orderText) {
        super(number, "Приказ о приёме на работу");
        this.employee = employee;
        this.orderText = orderText;
        orderStatus = OrderStatus.CREATED;
    }

    void CompleteOrder(){
        if (orderStatus.equals(OrderStatus.CREATED)) orderStatus = OrderStatus.COMPLETED;
    }

    void Print(boolean isSimplePrint){
        super.Print(isSimplePrint);
        if (!isSimplePrint) System.out.println("Сотрудник: " + employee +
                                   "\n" + orderText +
                                   "\nСтатус: " + orderStatus + "\n");
    }

}
