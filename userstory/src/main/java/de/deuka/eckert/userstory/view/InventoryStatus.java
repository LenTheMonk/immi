package de.deuka.eckert.userstory.view;



public enum InventoryStatus {
    INSTOCK("In Stock"),
    OUTOFSTOCK("Out of Stock"),
    LOWSTOCK("Low Stock");

    private String text;

    InventoryStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}