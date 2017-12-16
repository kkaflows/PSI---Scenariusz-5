
/**
 * Created by Lenovo on 2017-12-13.
 */
public class Main {

    public static void main(String[] args) {
        Network network = new Network(0.1, 30, 10000);
        network.learn();
        network.testing();
    }
}
