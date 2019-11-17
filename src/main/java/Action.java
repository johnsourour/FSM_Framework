public abstract class Action {
    private String name;

    Action(String actionName) {
        name = actionName;
    }

    public abstract void execute(Data d);
}
