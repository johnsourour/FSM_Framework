public class Transition {

    private State destination;

    Transition(State dest) {
        destination = dest;
    }

    public State getDestination() {
        return destination;
    }

}
