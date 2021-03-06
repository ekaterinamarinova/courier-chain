package courier.impl;

import client.Client;
import courier.Courier;
import packet.Packet;
import packet.impl.CountryPacket;
import state.CourierState;
import warehouse.StorageWorker;
import warehouse.impl.StorageWorkerImpl;

import java.util.logging.Logger;

public class CountryPacketCourier implements Courier {
    private static final Logger LOGGER = Logger.getLogger( CountryPacketCourier.class.getName() );
    private static CourierState state = CourierState.FREE;
    private StorageWorker storageWorker = new StorageWorkerImpl(this);

    private Courier next;

    public CountryPacketCourier(Courier courier) {
        this.next = courier;
    }

    @Override
    public void sendPacket(Packet packet) {
        LOGGER.fine("Sending packet...");
        if (packet instanceof CountryPacket) {
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
