package org.iot.dsa.dslink.bacnet;

import java.util.ArrayList;
import java.util.List;
import org.iot.dsa.dslink.bacnet.utils.Constants;
import org.iot.dsa.dslink.dframework.DFPointNode;
import org.iot.dsa.dslink.dframework.ParameterDefinition;
import org.iot.dsa.dslink.dframework.bounds.DoubleBounds;
import org.iot.dsa.node.DSDouble;
import org.iot.dsa.node.DSElement;
import org.iot.dsa.node.DSIValue;
import org.iot.dsa.node.DSMap;

public class BacnetObjectNode extends DFPointNode {
    
    public static List<ParameterDefinition> parameterDefinitions = new ArrayList<ParameterDefinition>();
    
    static {
        
        parameterDefinitions.add(ParameterDefinition.makeParamWithBoundsAndDef(Constants.POLL_RATE, DSDouble.valueOf(Constants.DEFAULT_PING_RATE), new DoubleBounds(0.001, Double.MAX_VALUE), "polling rate in seconds", null));
    }
    
    @Override
    public List<ParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }
    
    public BacnetObjectNode() {
        
    }
    
    public BacnetObjectNode(DSMap parameters) {
        this.parameters = parameters;
    }
    
    @Override
    public void onValueSet(DSIValue value) {
        
    }
    
    /* ================================================================== */

    
    @Override
    public long getPollRate() {
        DSElement rate = parameters.get(Constants.POLL_RATE);
        double seconds = Constants.DEFAULT_PING_RATE;
        if (rate != null && rate.isNumber()) {
            seconds = rate.toDouble();
        }
        return (long) (seconds * 1000);
    }
}
