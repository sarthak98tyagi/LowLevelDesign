package InventoryManagement.Item;

import java.util.ArrayList;
import java.util.List;

public class WarehouseController {

    private List<Warehouse> warehouseList;

    public WarehouseController(){
        warehouseList = new ArrayList<>();
    }

    public WarehouseController(List<Warehouse> warehouseList){
        this.warehouseList = warehouseList;
    }

    public void addWarehouse(Warehouse warehouse){
        System.out.println("Warehouse added: "+warehouse.getWarehouseId());
        warehouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse){}

    public Warehouse getWarehouse(String id){
        for(Warehouse warehouse: warehouseList){
            if(id.equals(warehouse.getWarehouseId()))
                    return warehouse;
        }
        return null;
    }
}
