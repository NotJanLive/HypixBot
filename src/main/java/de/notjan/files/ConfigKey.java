package de.notjan.files;

public enum ConfigKey {
    TOKEN("Token");
    public final String name;

    ConfigKey(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}