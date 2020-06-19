package warehouse;

import packet.Packet;

public interface StorageWorker {
    void store(Packet packet);

    Packet retrieve();
}
