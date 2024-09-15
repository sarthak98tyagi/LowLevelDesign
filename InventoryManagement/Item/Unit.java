package InventoryManagement.Item;

import java.time.LocalDate;

public class Unit {

    private String unitId;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;

    public Unit(String unitId, LocalDate manufacturingDate, LocalDate expiryDate) {
        this.unitId = unitId;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

}
