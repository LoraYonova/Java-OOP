package WorkingWithAbstraction.HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int season;

     Season(int season) {
         this.season = season;
    }

    public int getSeason() {
        return season;
    }

}
