package courier.impl;

import client.Client;
import courier.Courier;
import packet.Packet;
import packet.impl.ForeignPacket;
import state.CourierState;
import warehouse.StorageWorker;
import warehouse.impl.StorageWorkerImpl;

import java.util.logging.Logger;

public class ForeignPacketCourier implements Courier {
    private static final Logger LOGGER = Logger.getLogger( ForeignPacketCourier.class.getName() );
    private static CourierState state = CourierState.FREE;
    private StorageWorker storageWorker = new StorageWorkerImpl(this);

    private Courier next;

    public ForeignPacketCourier(Courier next) {
        this.next = next;
    }

    @Override
    public void sendPacket(Packet packet) {
        LOGGER.info("Sending packet...");
        if (packet instanceof ForeignPacket) {
            //initialize warehouse storing
            state = CourierState.PROCESSING;
            storageWorker.store(packet);
        } else {
            LOGGER.info("Wrong courier. Forwarding packet...");
            next.sendPacket(packet);
        }
    }

    @Override
    public Packet returnPacket(Client client) {
        return null;
    }

    @Override
    public CourierState getState() {
        return state;
    }

    @Override
    public void setState(CourierState newState) {
        state = newState;
    }
}
