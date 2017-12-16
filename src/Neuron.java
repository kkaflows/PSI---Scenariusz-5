import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Lenovo on 2017-12-13.
 */
public class Neuron {


    private double learningRate; //Wsp. uczący
    private double weight[]; //Tablica wag
    private int inputCounter; //Ile zmiennych X

    public Neuron(double learningRate, int inputCounter) {
        this.learningRate = learningRate;
        this.inputCounter = inputCounter;

        weight = new double[inputCounter];
        randomiseWeights();
        normaliseWeights();
    }


    private void normaliseWeights() {
        double lengthSquared = weight[0]*weight[0] + weight[1]*weight[1] + weight[2]*weight[2] + weight[3]*weight[3];
        double length = Math.sqrt(lengthSquared);

        weight[0] /= length;
        weight[1] /= length;
        weight[2] /= length;
        weight[3] /= length;
    }

    private void randomiseWeights() {
        for (int i = 0; i < inputCounter; i++) {
            weight[i] = ThreadLocalRandom.current().nextDouble(0.01, 0.1);
        }
    }


    public double calculate(Data input) {
        double signal = signalF(input);
        return signal;
    }

    private double signalF(Data data){
        double signal = 0;
        for(int i=0; i<inputCounter; i++) {
            signal += data.getX(i) * weight[i];
        }

        return signal;
    }

    public void modify(Data data) { //Modyfikacja wag
        for (int i = 0; i < inputCounter; i++) {
            weight[i] = weight[i] + learningRate * (data.getX(i) - weight[i]);
        }

        normaliseWeights();
    }
}
