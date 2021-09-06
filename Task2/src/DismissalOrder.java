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
                                   "\nСтатус: " + orderStatus.labelRu +
                                   "\nПричина увольнения: " + reason + "\n");
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

    public String getReason () {
        return reason;
    }

    public void setReason (String reason) {
        this.reason = reason;
    }
}
