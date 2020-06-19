package courier;

import client.Client;
import packet.Packet;
import state.CourierState;

public interface Courier {

    void sendPacket(Packet packet);

    Packet returnPacket(Client client);

    CourierState getState();

    void setState(CourierState state);

}
