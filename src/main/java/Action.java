public abstract class Action {
    private String name;
    Action(String actionName) {
        name = actionName;
    }
    public abstract String execute(Data d); //returns result of Action for transition
}
