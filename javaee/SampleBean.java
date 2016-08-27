/*
* A sample Java Bean for starters.
* 
* @author rajat
*/
import java.beans.*;

public class SampleBean {
    private String mName;
    private boolean mRunning;
    private final PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    
    // Turned out that builder tools figure out the bean properties based on 
    // setter/getters pair names, like here, the property name will be "name"
    // even if we change the name of the member field from "mName" to "lol" etc.
    public String getName() {
        return this.mName;
    }
    
    public void setName(String name) {
        String oldName = this.mName;
        this.mName = name;
        mPcs.firePropertyChange("name", oldName, this.mName);
    }
    
    public boolean isRunning() {
        return this.mRunning;
    }
    
    public void setRunning(boolean rn) {
        this.mRunning = rn;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        mPcs.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        mPcs.removePropertyChangeListener(listener);
    }
}

