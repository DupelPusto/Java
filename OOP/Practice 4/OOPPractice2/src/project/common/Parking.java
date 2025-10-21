package project.common;

public class Parking {
    private boolean isFree = true;
    private boolean isPaid = false;
    private short id;
    private Transport transport;



    public Parking(boolean isFree, boolean isPaid, Transport transport, short id){
        setFree(isFree);
        setPaid(isPaid);
        this.id = id;

    }


    public void setFree(boolean free) {
        isFree = free;
    }

    public void setTransport(Transport transport) { this.transport = transport; }

    public void setPaid(boolean paid) { isPaid = paid; }


    public boolean isFree() { return isFree; }

    public short getId() { return id; }

    public Transport getTransport() { return transport; }
}
