package ExtendsProject;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ExtendsDetails {

}

class Computer{
    public String cpu;
    public String rom;
    public String disk;

    public Computer(String cpu, String rom, String disk) {
        this.cpu = cpu;
        this.rom = rom;
        this.disk = disk;
    }

    public void getDetails(){
        System.out.println("CPU is " + cpu + " rom is " + rom + " disk is " + disk);
    }
}

class PC extends Computer{
    private String brand;

    public PC(){
        super("Intel", "16G", "2T");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

class NotePad extends Computer{
    private String color;

    public NotePad(){
        super("AMD", "32G", "1T");
    }
    public void setColor(String color) {
        this.color = color;
    }



}

