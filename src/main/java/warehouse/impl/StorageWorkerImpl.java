package warehouse.impl;

import courier.Courier;
import packet.Packet;
import state.CourierState;
import warehouse.StorageWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StorageWorkerImpl implements StorageWorker {
    private static final Logger LOGGER = Logger.getLogger( StorageWorkerImpl.class.getName() );

    private Courier courier;
    private List<Packet> packets = new ArrayList<>();

    public StorageWorkerImpl(Courier courier) {
        this.courier = courier;
    }

    @Override
    public void store(Packet packet) {
        courier.setState(CourierState.FREE);
        packets.add(packet);
        LOGGER.info("Packet successfully stored. Courier state restored.");
    }

    @Override
    public Packet retrieve() {
        return null;
    }
}
