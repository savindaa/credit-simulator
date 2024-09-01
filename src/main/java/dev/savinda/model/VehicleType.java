package dev.savinda.model;

public enum VehicleType {
    CAR("mobil"),
    MOTORCYCLE("motor");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    public static VehicleType fromString(String text) {
        for (VehicleType b : VehicleType.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Tipe kendaraan tidak valid");
    }

    @Override
    public String toString() {
        return value;
    }
}
