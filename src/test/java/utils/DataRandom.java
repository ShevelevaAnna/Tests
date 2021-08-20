package utils;

public enum  DataRandom {
    ASCII_CYRILLIC_A("192"),
    ASCII_LATIN_A("65"),
    ASCII_LATIN_a("97"),
    ASCII_NUMBER_ZERO("48"),
    NUMBER_DIGITS("10"),
    CYRILLIC_ALPHABET("32"),
    LATIN_ALPHABET("26"),
    SELECT_ALL_INTEREST("18"),
    NUMBER_INTERESTS("20"),
    NUMBER_DOMAIN("10");

    private final String data;

    DataRandom(String data) {
        this.data = data;
    }

    /**
     * метод осуществляет получение пути
     * @return
     */
    public int getData() {
        return Integer. parseInt(data);
    }
}