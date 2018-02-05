import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FlightTest {

    @Test
    public void testFlightGetName() {
        Flight f = new Flight("AC123", "12-09-2017");
        assertEquals("AC123", f.getName());
    }

    @Test
    public void testFlightGetDate() {
        Flight f = new Flight("AC123", "12-09-2017");
        assertEquals("12-09-2017", f.getDate());
    }

    @Test
    public void testAirportGetName() {
        Airport a = new Airport("YYZ");
        assertEquals("YYZ", a.getName());
    }

    @Test
    public void testAirportWasVisitedBy() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a = new Airport("YYZ");
        f.addAirport(a);
        assertTrue(a.wasVisitedBy(f));
    }

    @Test
    public void testAirportNotVisitedBy() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a = new Airport("YYZ");
        assertFalse(a.wasVisitedBy(f));
    }

    @Test
    public void testGetAirportOneFlightNoAirport() {
        Flight f = new Flight("AC123", "12-09-2017");
        assertTrue(f.getAirports().size() == 0);
    }

    @Test
    public void testOneFlightAddAirportGetAirports() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a = new Airport("YYZ");
        f.addAirport(a);
        assertTrue(f.getAirports().size() == 1);
        assertTrue(f.getAirports().contains(a));
    }

    @Test
    public void testOneFlightAddFlightGetAirports() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a = new Airport("YYZ");
        a.addFlight(f);
        assertTrue(f.getAirports().size() == 1);
        assertTrue(f.getAirports().contains(a));
        assertTrue(a.wasVisitedBy(f));
    }

    @Test
    public void testOnSameFlight() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YVR");
        f.addAirport(a1);
        f.addAirport(a2);
        assertTrue(a1.onSameFlight(a2));
    }

    @Test
    public void testNotOnSameFlight() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YVR");
        assertFalse(a1.onSameFlight(a2));
    }

    @Test
    public void testOneFlightTwoAirports() {
        Flight f = new Flight("AC123", "12-09-2017");
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YVR");
        f.addAirport(a1);
        a2.addFlight(f);

        // Does f contain both airports?
        assertTrue(f.getAirports().size() == 2);
        assertTrue(f.getAirports().contains(a1));
        assertTrue(f.getAirports().contains(a2));

        // Was each airport visited by the flight?
        assertTrue(a1.wasVisitedBy(f));
        assertTrue(a2.wasVisitedBy(f));

        // Were a1 and a2 visited by the same flight?
        assertTrue(a1.onSameFlight(a2));
        assertTrue(a2.onSameFlight(a1));
    }

    @Test
    public void testFlightEquals() {
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("AC123", "12-09-2017");
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFlightEqualsDifferentAirports() {
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("AC123", "12-09-2017");
        Airport a = new Airport("YYZ");
        f1.addAirport(a);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFlightNotEqualsName() {
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        assertFalse(f1.equals(f2));
    }

    @Test
    public void testFlightNotEqualsDate() {
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        assertFalse(f1.equals(f2));
    }

    @Test
    public void testAirportEqualsNoFlights() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YYZ");
        assertTrue(a1.equals(a2));
    }

    @Test
    public void testAirportNotEqualsTwoAirports() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YVR");
        assertFalse(a1.equals(a2));
    }

    @Test
    public void testAirportNotEqualsNonAirport() {
        Airport a1 = new Airport("YYZ");
        assertFalse(a1.equals("Not an Airport"));
    }

    @Test
    public void testAirportEqualsTwoFlights() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        a1.addFlight(f1);
        a1.addFlight(f2);
        a2.addFlight(f1);
        a2.addFlight(f2);
        assertTrue(a1.equals(a2));
    }

    @Test
    public void testAirportEqualsTwoFlightsDifferentOrder() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        a1.addFlight(f1);
        a1.addFlight(f2);
        a2.addFlight(f2);
        a2.addFlight(f1);
        assertTrue(a1.equals(a2));
    }

    @Test
    public void testAirportNotEqualsExtraFlight() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        Flight f3 = new Flight("WS887", "14-11-2018");
        a1.addFlight(f1);
        a1.addFlight(f2);
        a2.addFlight(f2);
        a2.addFlight(f1);
        a2.addFlight(f3);
        assertFalse(a1.equals(a2));
    }

    @Test
    public void testAirportToStringNoFlights() {
        Airport a1 = new Airport("YYZ");
        String res = a1.toString();
        String exp = "YYZ ()";
        assertEquals(exp, res);
    }

    @Test
    public void testAirportToStringOneFlight() {
        Airport a1 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        a1.addFlight(f1);
        String res = a1.toString();
        String exp = "YYZ (AC123)";
        assertEquals(exp, res);
    }

    @Test
    public void testAirportToStringThreeFlights() {
        Airport a1 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        Flight f2 = new Flight("WJ329", "13-10-2017");
        Flight f3 = new Flight("WS887", "14-11-2018");
        a1.addFlight(f1);
        a1.addFlight(f2);
        a1.addFlight(f3);
        String res = a1.toString();
        String exp = "YYZ (AC123, WJ329, WS887)";
        assertEquals(exp, res);
    }

    @Test
    public void testFlightToStringNoAirports() {
        Flight f1 = new Flight("AC123", "12-09-2017");
        String res = f1.toString();
        String exp = "AC123, 12-09-2017";
        assertEquals(exp, res);
    }

    @Test
    public void testFlightToStringOneFlight() {
        Airport a1 = new Airport("YYZ");
        Flight f1 = new Flight("AC123", "12-09-2017");
        f1.addAirport(a1);
        String res = f1.toString();
        String exp = "AC123, 12-09-2017" + System.lineSeparator() + a1.getName();
        assertEquals(exp, res);
    }

    @Test
    public void testFlightToStringFourAirports() {
        Airport a1 = new Airport("YYZ");
        Airport a2 = new Airport("YVR");
        Airport a3 = new Airport("YHZ");
        Airport a4 = new Airport("YUL");
        Flight f1 = new Flight("AC123", "12-09-2017");
        f1.addAirport(a1);
        f1.addAirport(a2);
        f1.addAirport(a3);
        f1.addAirport(a4);
        String res = f1.toString();
        String exp = "AC123, 12-09-2017" + System.lineSeparator() + a1.getName() + System.lineSeparator() + a2.getName()
                + System.lineSeparator() + a3.getName() + System.lineSeparator() + a4.getName();
        assertEquals(exp, res);
    }

}
