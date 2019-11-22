public class ActionGo extends Action {
    ActionGo(String actionName) {
        super(actionName);
    }

    @Override
    public String execute(Data d) {
        return "CALC";
    }
}
