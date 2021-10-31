package workingWithAbstraction.TrafficLights;

public enum TrafficLight {
    RED("RED"),
    GREEN("GREEN"),
    YELLOW("YELLOW");

    private String light;

    TrafficLight(String light) {
        this.light = light;
    }

    public TrafficLight changeLight(String light) {
        if (light.equals("RED")) {
            return GREEN;
        } else if (light.equals("GREEN")) {
            return YELLOW;
        } else if (light.equals("YELLOW")) {
            return RED;
        }
        throw new NullPointerException();
    }
}
