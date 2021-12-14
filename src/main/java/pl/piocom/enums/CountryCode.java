package pl.piocom.enums;

public enum CountryCode {
    //Those are only countries used by our freightexchange.
    // Codes are written by code type "ISO 3166-1 alpha-3 codes"
    POL("Poland"),
    CZE("Czechia"),
    SLO("Slovakia"),
    HUN("Hungary"),
    GER("Germany"),
    BEL("Belgium"),
    NLD("Netherlands"),
    FRA("France"),
    ESP("Spain");

    public final String label;

    private CountryCode(String label) {
        this.label = label;
    }
}
