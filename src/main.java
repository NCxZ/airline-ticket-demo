import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static Map<String,Airline> airlines = new HashMap<String,Airline>();
    public static Map<String,Flight> flights = new HashMap<String,Flight>();
    public static Map<String,Plane> planes = new HashMap<String,Plane>();


    public static void main(String[] args) {
        addAirline("Ryanair");
        addPlane("Boeing 495",200);
        String code = addFlight("Ryanair","Boeing 495", "1 Oct 2001");
        System.out.println(getAirline("Ryanair").getFlight(code).seatStatus[15]);
        addAirline("Pegasus");
        code = addFlight("Pegasus","Boeing 495", "2 Oct 2020");
        System.out.println(getAirline("Ryanair").getFlight(code).seatStatus[15]);

    }

    public static void addPlane(String model,int seat){
        planes.put(model,new Plane(model,seat));
    }
    private static Plane getPlane(String model) {
        return planes.get(model);
    }

    public static Airline getAirline(String name){
        return airlines.get(name);
    }
    public static void addAirline(String name){
        airlines.put(name,new Airline(name));
    }

    public static String addFlight(String airlane,String plane,String date){
        return getAirline(airlane).addFlight(getPlane(plane),date);
    }

    public static Flight getFlight(String code){
        return flights.get(code);
    }
    //Ticket Operations
    public void buyTicket(String flight){

    }

}
