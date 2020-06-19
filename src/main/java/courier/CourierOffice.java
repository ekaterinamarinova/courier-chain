package courier;

import packet.Packet;

public interface CourierOffice {
    void requestSendPacket(Packet packet);
}
