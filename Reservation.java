public class Reservation {
    private String pnr;
    private String name;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String pnr, String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.pnr = pnr;
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + "\n" +
                "Name: " + name + "\n" +
                "Train Number: " + trainNumber + "\n" +
                "Train Name: " + trainName + "\n" +
                "Class Type: " + classType + "\n" +
                "Date of Journey: " + dateOfJourney + "\n" +
                "From: " + from + "\n" +
                "To: " + to;
    }
}
