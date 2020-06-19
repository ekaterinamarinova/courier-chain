package client.impl;

import client.Client;
import courier.impl.CourierOfficeImpl;
import packet.Packet;
import packet.impl.ForeignPacket;

import java.util.logging.Logger;

public class ClientImpl implements Client {

    private static final Logger LOGGER = Logger.getLogger( ClientImpl.class.getName() );

    private Packet packet = new ForeignPacket();
    private CourierOfficeImpl courierOffice = new CourierOfficeImpl();

    @Override
    public void requestSendPacket() {
        LOGGER.info("Requesting packet sending..");
        courierOffice.requestSendPacket(this.packet);
    }

    @Override
    public void requestReceivePacket() {

    }
}
