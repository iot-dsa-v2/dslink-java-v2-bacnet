package org.iot.dsa.dslink.bacnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.iot.dsa.dslink.bacnet.utils.Constants;
import org.iot.dsa.dslink.dframework.DFDeviceNode;
import org.iot.dsa.dslink.dframework.DFPointNode;
import org.iot.dsa.dslink.dframework.DFUtil;
import org.iot.dsa.dslink.dframework.ParameterDefinition;
import org.iot.dsa.dslink.dframework.bounds.DoubleBounds;
import org.iot.dsa.node.DSDouble;
import org.iot.dsa.node.DSElement;
import org.iot.dsa.node.DSMap;

public class BacnetDeviceNode extends DFDeviceNode {
    
    public static List<ParameterDefinition> parameterDefinitions = new ArrayList<ParameterDefinition>();
    
    static {
        parameterDefinitions.add(ParameterDefinition.makeParamWithBoundsAndDef(Constants.PING_RATE, DSDouble.valueOf(Constants.DEFAULT_PING_RATE), new DoubleBounds(.001, Double.MAX_VALUE),"interval between pings, in seconds", null));
    }
    
    @Override
    public List<ParameterDefinition> getParameterDefinitions() {
        return parameterDefinitions;
    }
    
    public BacnetDeviceNode() {
    }
    
    public BacnetDeviceNode(DSMap parameters) {
        this.parameters = parameters;
    }
    
    @Override
    protected void declareDefaults() {
        super.declareDefaults();
        declareDefault(Constants.ACTION_ADD_POINT, DFUtil.getAddAction(BacnetObjectNode.class));
    }
    
    /* ================================================================== */

    @Override
    public boolean createConnection() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ping() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void closeConnection() {
        // TODO Auto-generated method stub

    }
    
    @Override
    public Map<DFPointNode, Boolean> batchPoll(Set<DFPointNode> points) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public long getPingRate() {
        DSElement rate = parameters.get(Constants.PING_RATE);
        double seconds = Constants.DEFAULT_PING_RATE;
        if (rate != null && rate.isNumber()) {
            seconds = rate.toDouble();
        }
        return (long) (seconds * 1000);
    }
    
    @Override
    public double getReconnectDelayMultiplier() {
        return getMainNode().getLink().getConfig().getConfig(Constants.CONFIG_RECONNECT_DELAY_MULTIPLIER, super.getReconnectDelayMultiplier());
    }
}
