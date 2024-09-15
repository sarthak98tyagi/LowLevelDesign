package InventoryManagement;

import InventoryManagement.Item.Inventory;
import InventoryManagement.Item.Product;
import InventoryManagement.Item.Warehouse;
import InventoryManagement.Item.WarehouseController;
import InventoryManagement.Order.Order;
import InventoryManagement.Order.OrderController;
import InventoryManagement.User.Cart;
import InventoryManagement.User.User;
import InventoryManagement.User.UserController;

import java.util.List;

public class SystemController {

    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    public SystemController(List<User> userList, List<Warehouse> warehouseList){
        userController = new UserController();
        warehouseController = new WarehouseController(warehouseList);
        orderController = new OrderController();
    }

    //get user object
    public User getUser(String userId){
        return userController.getUser(userId);
    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.getInventory();

    }

    public void addProductToCart(User user, Product product, int count){
        Cart cart = user.getCart();
        cart.addProduct(product, count);
    }

    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkoutOrder();
    }




}
