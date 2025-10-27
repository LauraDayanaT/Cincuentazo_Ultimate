package com.cincuentazo._0zo.modelo;

public class Carta {
    private final String cara;

    public Carta(String cara) {
        this.cara = cara;
    }

    public String getCara() {
        return cara;
    }

    public int[] obtenerValores() {
        switch (cara) {
            case "A": return new int[]{1, 10};
            case "9": return new int[]{0};
            case "J": case "Q": case "K": return new int[]{-10};
            case "10": return new int[]{10};
            default:
                try {
                    return new int[]{Integer.parseInt(cara)};
                } catch (NumberFormatException e) {
                    return new int[]{0};
                }
        }
    }

    @Override
    public String toString() {
        return cara;
    }
}
