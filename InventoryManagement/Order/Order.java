package InventoryManagement.Order;

import InventoryManagement.Address;
import InventoryManagement.Item.Warehouse;
import InventoryManagement.User.User;

import java.util.Map;

public class Order {

    private String orderId;
    private Map<String,Integer> orderedItems;
    private Warehouse warehouse;
    private Address shippingAddress;
    private User user;
    private Invoice invoice;
    private Payment payment;
    private OrderStatus status;

    public Order(String orderId, Map<String, Integer> orderedItems, Warehouse warehouse, Address shippingAddress, User user, Invoice invoice, Payment payment) {
        this.orderId = orderId;
        this.orderedItems = orderedItems;
        this.warehouse = warehouse;
        this.shippingAddress = shippingAddress;
        this.user = user;
        this.invoice = invoice;
        this.payment = payment;
        status = OrderStatus.CREATED;
    }

    Order(User user, Warehouse warehouse){
        this.user = user;
        this.orderedItems = user.getCart().getProductMap();
        this.warehouse = warehouse;
        this.shippingAddress = user.getAddress();
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkoutOrder(){
        warehouse.removeProducts(orderedItems);
        invoice.generateInvoice(this);
        boolean success = payment.pay(invoice.getTotalAmount());
        if(success) {
            System.out.println("Order placed");
            status = OrderStatus.PLACED;
        }
        else{
            System.out.println("Payment Failed");
            status = OrderStatus.CANCELLED;
            warehouse.addProducts(orderedItems);
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<String, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouse = warehouse;
    }
}
