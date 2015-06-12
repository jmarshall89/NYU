import java.util.Random;

public class RandomGrade {

    private Random random = new Random();
    private double mean;
    private double stdev;

    public RandomGrade(double mean, double stdev) {
        this.mean = mean;
        this.stdev = stdev;
    }

    public int classGrade(){
        double theGrade;
        theGrade =  mean + (stdev * random.nextGaussian());
        return (int) theGrade;
    }
}
