package org.iot.dsa.dslink.bacnet;

import java.util.ArrayList;
import java.util.List;
import org.iot.dsa.dslink.dframework.ParameterDefinition;
import org.iot.dsa.node.DSMap;

public class SerialConnectionNode extends BacnetConnectionNode {
    protected static List<ParameterDefinition> parameterDefinitions = new ArrayList<ParameterDefinition>();
    
    static {
        
        BacnetConnectionNode.addCommonParameterDefinitions(parameterDefinitions);
    }
    
    @Override
    public List<ParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }
    
    public SerialConnectionNode() {
        super();
    }
    
    public SerialConnectionNode(DSMap parameters) {
        super(parameters);
    }
    
    @Override
    public boolean createConnection() {
        
        return super.createConnection();
    }

}
