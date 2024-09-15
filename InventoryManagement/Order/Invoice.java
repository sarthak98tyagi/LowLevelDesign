package InventoryManagement.Order;

import java.util.UUID;

public class Invoice {

    private String invoiceId;
    private double itemPrice;
    private double taxAmount;
    private double totalAmount;

    public Invoice(){
        this.invoiceId = UUID.randomUUID().toString();
    }

    public void generateInvoice(Order order){
        //generate invoice
        itemPrice = 700;
        taxAmount = 50;
        totalAmount = 750;

    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
