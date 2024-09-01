package dev.savinda.model;

public enum VehicleCondition {
    NEW("baru"),
    USED("bekas");

    private final String value;

    VehicleCondition(String value) {
        this.value = value;
    }

    public static VehicleCondition fromString(String text) {
        for (VehicleCondition b : VehicleCondition.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Kondisi kendaraan tidak valid");
    }

    @Override
    public String toString() {
        return value;
    }
}
