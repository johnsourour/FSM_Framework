public abstract class Action {
    private String name;
    Action(String actionName) {
        name = actionName;
    }
    //returns result of Action for the next transition
    public abstract String execute(Data d);
}
