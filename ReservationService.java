import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static String makeReservation(String name, String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        String pnr = generatePNR();
        Reservation reservation = new Reservation(pnr, name, trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.put(pnr, reservation);
        return pnr;
    }

    public static void cancelReservation(String pnr) {
        reservations.remove(pnr);
    }

    public static String getReservationDetails(String pnr) {
        Reservation reservation = reservations.get(pnr);
        return (reservation != null) ? reservation.toString() : null;
    }

    private static String generatePNR() {
        return "PNR" + (reservations.size() + 1);
    }
}
