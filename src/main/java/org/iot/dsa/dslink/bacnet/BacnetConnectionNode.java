package org.iot.dsa.dslink.bacnet;

import java.util.List;
import org.iot.dsa.dslink.bacnet.utils.Constants;
import org.iot.dsa.dslink.dframework.DFConnectionNode;
import org.iot.dsa.dslink.dframework.DFUtil;
import org.iot.dsa.dslink.dframework.ParameterDefinition;
import org.iot.dsa.dslink.dframework.bounds.DoubleBounds;
import org.iot.dsa.dslink.dframework.bounds.IntegerBounds;
import org.iot.dsa.node.DSDouble;
import org.iot.dsa.node.DSElement;
import org.iot.dsa.node.DSInt;
import org.iot.dsa.node.DSMap;

public abstract class BacnetConnectionNode extends DFConnectionNode {
    
    protected static void addCommonParameterDefinitions(List<ParameterDefinition> definitions) {
        definitions.add(ParameterDefinition.makeParamWithBoundsAndDef(
                Constants.PING_RATE,
                DSDouble.valueOf(Constants.DEFAULT_PING_RATE),
                new DoubleBounds(.001, Double.MAX_VALUE),
                "interval between pings, in seconds",
                null)
        );
        definitions.add(ParameterDefinition.makeParamWithBoundsAndDef(
                Constants.TIMEOUT,
                DSInt.valueOf(Constants.DEFAULT_TIMEOUT),
                new IntegerBounds(100, 10000), //Integer.MAX_VALUE
                null,
                null)
        );
        definitions.add(ParameterDefinition.makeParamWithBoundsAndDef(
                Constants.RETRIES,
                DSInt.valueOf(Constants.DEFAULT_RETRIES),
                new IntegerBounds(0, 100), //Integer.MAX_VALUE
                null,
                null)
        );
    }
    
    public BacnetConnectionNode() {
    }
    
    public BacnetConnectionNode(DSMap parameters) {
        this.parameters = parameters;
    }
    
    @Override
    protected void declareDefaults() {
        super.declareDefaults();
        declareDefault(Constants.ACTION_ADD_DEVICE, DFUtil.getAddAction(BacnetDeviceNode.class));
    }
    
    /* ==================================================================== */

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
        return getMainNode().getLink().getOptions().getConfig(Constants.CONFIG_RECONNECT_DELAY_MULTIPLIER, super.getReconnectDelayMultiplier());
    }

}
