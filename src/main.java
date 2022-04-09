import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static Map<String,Airline> airlines = new HashMap<String,Airline>();
    public static Map<String,Flight> flights = new HashMap<String,Flight>();
    public static Map<String,Plane> planes = new HashMap<String,Plane>();
    public static Map<String,Passenger> passengers = new HashMap<String,Passenger>();


    public static void main(String[] args) {
        addAirline("Ryanair");
        addAirline("Pegasus");

        addPlane("Boeing 495",200);
        addPassenger("Fatihcan Yıldız","13510943286" , 5);

        String code = addFlight("Ryanair","Boeing 495", "1 Oct 2001");
        System.out.println(code);
        code = addFlight("Pegasus","Boeing 495", "2 Oct 2020");
        System.out.println(code);


        buyTicket(code,"13510943286",15);
        buyTicket(code,"13510943286",16);
        System.out.println(getAirline("Pegasus").getFlight(code).getSeat(15).getStatus());
        System.out.println(getPassenger("13510943286").getSeats());
        System.out.println(getPassenger("13510943286"));

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

    public static void addPassenger(String name, String id, int age){
        Passenger tempPassenger = new Passenger(name,id,age);
        passengers.put(tempPassenger.getId(),tempPassenger);
    }
    public static Passenger getPassenger(String id){
        return passengers.get(id);
    }
    //Ticket Operations
    public static void buyTicket(String flight,String id,int seatNumber){
        if (getFlight(flight).getSeat(seatNumber).getStatus()=="Available"){
            getFlight(flight).getSeat(seatNumber).setStatus("Taken");
            getPassenger(id).addSeats(getFlight(flight).getSeat(seatNumber));
        }
        else System.out.println("FAİl!");

    }

}
