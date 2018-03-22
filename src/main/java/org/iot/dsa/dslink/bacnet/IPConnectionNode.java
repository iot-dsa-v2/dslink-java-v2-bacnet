package org.iot.dsa.dslink.bacnet;

import java.util.ArrayList;
import java.util.List;
import org.iot.dsa.dslink.dframework.ParameterDefinition;
import org.iot.dsa.node.DSMap;

public class IPConnectionNode extends BacnetConnectionNode {

    protected static List<ParameterDefinition> parameterDefinitions = new ArrayList<ParameterDefinition>();
    
    static {
        
    }
    
    @Override
    public List<ParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }
    
    public IPConnectionNode() {
        super();
    }

    public IPConnectionNode(DSMap parameters) {
        super(parameters);
    }
    
    @Override
    public boolean createConnection() {
        
        
        return super.createConnection();
    }

}
