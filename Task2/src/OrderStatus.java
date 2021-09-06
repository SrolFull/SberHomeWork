enum OrderStatus {
    CREATED("Создано"),
    COMPLETED("Выполнено");

    public final String labelRu;

    OrderStatus(String labelRu){
        this.labelRu = labelRu;
    }
}
