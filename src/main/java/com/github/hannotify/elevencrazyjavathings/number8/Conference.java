package com.github.hannotify.elevencrazyjavathings.number8;

import java.time.Year;

public enum Conference {
    JAVA_ONE("JavaOne", 2022, "the USA"),
    J_FALL("J-Fall", 2022, "the Netherlands") { //enum can provide it's own implementation
        @Override
        public String whenIsTheNext() {
            return super.whenIsTheNext() + "It is the best one-day conference we know!";
        }
    },
    DEVOXX_UK("Devoxx UK", 2023, "United Kingdom");

    private final String name;
    private final Year nextEdition;
    private final String country;

    Conference(String name, int nextEdition, String country) {
        this.name = name;
        this.nextEdition = Year.of(nextEdition);
        this.country = country;
    }
    public String whenIsTheNext() {
        return String.format("The next %s will be in %d; it will take place in %s.",
                name, nextEdition.getValue(), country);
    }
}
