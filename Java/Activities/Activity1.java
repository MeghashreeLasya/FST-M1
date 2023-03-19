package activities;

public class Activity1 {

    public static void main(String[] args)
    {
        Car baleno = new Car();
        baleno.make = 2014;
        baleno.color = "Black";
        baleno.transmission = "Manual";

        baleno.displayCharacteristics();
        baleno.accelerate();
        baleno.brake();
    }
}
