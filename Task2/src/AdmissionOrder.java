class AdmissionOrder extends AbstractDocument {
    private final String employee;
    private String orderText;
    private OrderStatus orderStatus;

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
                                   "\nСтатус: " + orderStatus.labelRu + "\n");
    }

    public String getOrderText () {
        return orderText;
    }

    public void setOrderText (String orderText) {
        this.orderText = orderText;
    }

    public OrderStatus getOrderStatus () {
        return orderStatus;
    }

    public void setOrderStatus (OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
