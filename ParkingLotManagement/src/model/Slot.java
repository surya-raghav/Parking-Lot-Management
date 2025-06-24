package model;

public class Slot {
    private SlotSize size;
    private Vehicle parketVehicle;

    public Slot(SlotSize size) {
        this.size = size;
    }

    public SlotSize getSize() {
        return size;
    }

    public Vehicle getParketVehicle() {
        return parketVehicle;
    }
}
