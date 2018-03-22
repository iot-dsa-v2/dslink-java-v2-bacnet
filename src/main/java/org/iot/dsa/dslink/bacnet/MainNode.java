package org.iot.dsa.dslink.bacnet;

import org.iot.dsa.dslink.DSMainNode;
import org.iot.dsa.dslink.bacnet.utils.Constants;
import org.iot.dsa.dslink.dframework.DFUtil;

public class MainNode extends DSMainNode {
    
    @Override
    protected void declareDefaults() {
        super.declareDefaults();
        declareDefault(Constants.ACTION_ADD_IP, DFUtil.getAddAction(IPConnectionNode.class));
        declareDefault(Constants.ACTION_ADD_SERIAL, DFUtil.getAddAction(SerialConnectionNode.class));
//        declareDefault(Constants.ACTION_RESCAN_PORTS, getRescanAction());
    }

}
