enum OrderStatus {
    CREATED("Создано"),
    COMPLETED("Выполнено");

    public final String statusRu;

    OrderStatus(String statusRu){
        this.statusRu = statusRu;
    }
}
