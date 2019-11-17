public class Transition {

    private State destination;
    private String result;

    Transition(State dest, String res) {
        result = res;
        destination = dest;
    }

    public State getDestination() {
        return destination;
    }

    public String getResult() {
        return result;
    }
}
