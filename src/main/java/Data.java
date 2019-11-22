import java.util.HashMap;
import java.util.Map;

public class Data {
    private Map<String,Object> vars;

    Data() {
        vars = new HashMap<>();
    }

    public void addVariable(String name, Object val) {
        vars.put(name, val);
    }

    public boolean changeVariable(String name, Object val) {
        if(vars.containsKey(name)){
            vars.replace(name, val);
            return true;
        }
        return false;
    }

    public void removeVariable(String name){
        vars.remove(name);
    }
    public Object getVariable(String name) {
        return vars.get(name);
    }
}
