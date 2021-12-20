package pl.piocom.enums;

public enum Role {
    USER("USER"), ADMIN("ADMIN");

    public String displayValue;

    Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
