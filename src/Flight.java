import java.util.Arrays;

public class Flight {
    String code;
    Plane plane;
    String dateAndTime;
    String[] seatStatus;

    public Flight(Plane plane,String dateAndTime){
        this.code = "ASFWNNNNW10"; // TODO uniqe code generate -static last code
        this.dateAndTime = dateAndTime;
        this.plane = plane;
        this.seatStatus= new String[plane.seat];
        Arrays.fill(seatStatus,"Available");
    }

    public String toString(){
        return "Flight: "+plane + " " + "Time:"+dateAndTime ;
    }
}
