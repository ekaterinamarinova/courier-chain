package courier.impl;

import courier.CourierOffice;
import packet.Packet;

public class CourierOfficeImpl implements CourierOffice {

    //example chain of resp couriers
    private ForeignPacketCourier foreignPacketCourier = new ForeignPacketCourier(null);
    private CountryPacketCourier countryPacketCourier = new CountryPacketCourier(foreignPacketCourier);
    private CityPacketCourier cityPacketCourier = new CityPacketCourier(countryPacketCourier);

    @Override
    public void requestSendPacket(Packet packet) {
        cityPacketCourier.sendPacket(packet);
    }
}
