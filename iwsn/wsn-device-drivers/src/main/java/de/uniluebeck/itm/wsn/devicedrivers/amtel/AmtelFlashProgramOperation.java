package de.uniluebeck.itm.wsn.devicedrivers.amtel;

import de.uniluebeck.itm.wsn.devicedrivers.generic.GenericDevice;
import de.uniluebeck.itm.wsn.devicedrivers.generic.GenericDeviceOperation;
import de.uniluebeck.itm.wsn.devicedrivers.generic.Operation;

/**
 * @author massel
 * 
 */
public class AmtelFlashProgramOperation extends GenericDeviceOperation{

	public AmtelFlashProgramOperation(GenericDevice device) {
		super(device);
		
	}

	@Override
	public Operation getOperation() {
		return Operation.PROGRAM;
	}

	/* (non-Javadoc)
	 * @see de.uniluebeck.itm.wsn.devicedrivers.generic.GenericDeviceOperation#run()
	 */
	@Override
	public void run() {
		//TODO FMA Auto-generated method stub
		
	}

	

}
