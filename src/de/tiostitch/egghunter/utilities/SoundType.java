package de.tiostitch.egghunter.utilities;

public enum SoundType {
    PICKUP("assets/sounds/pickup.wav"),
    MAXED("assets/sounds/maxedAll.wav");

    String location;
    SoundType(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}