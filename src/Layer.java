import java.util.ArrayList;

/**
 * Created by Lenovo on 2017-12-13.
 */
public class Layer {

    private Neuron[] neuron;
    private int inputCounter; //Liczba wejśc na neurony
    private int neuronCounter; //Liczba neuronów
    private double learningRate;
    private Data data;

    public Layer(int inputCounter, int neuronCounter, double learningRate) {
        this.inputCounter = inputCounter;
        this.neuronCounter = neuronCounter;
        this.learningRate = learningRate;

        neuron = new Neuron[neuronCounter];
        for (int i = 0; i < neuronCounter; i++) {
            neuron[i]=new Neuron(learningRate,inputCounter);
        }
    }

    public ArrayList<Double> calculateLayer(Data input){
        ArrayList<Double> results = new ArrayList<Double>();
        this.data = input;

        for (int i=0 ; i < neuron.length; i++){
            results.add(neuron[i].calculate(input));
        }

        return results;
    }

    public void modify(int id){
        neuron[id].modify(data);
    }

}
