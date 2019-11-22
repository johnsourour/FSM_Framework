public class ActionPrint extends Action {
    String stringName;
    ActionPrint(String actionName, String toPrint) {
        super(actionName);
        stringName = toPrint;
    }

    @Override
    public String execute(Data d) {
        Object toPrint = d.getVariable(stringName);
        if(toPrint == null) {
            return "FAIL";
        }
        else{
            System.out.println(toPrint.toString());
            return "SUCCESS";
        }
    }
}
