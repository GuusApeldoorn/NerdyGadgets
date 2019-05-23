package projectkbsdmonitor;

public class Node {
    public float uptime;
    public String name;
    public int timestamp;
    public int diksfree;
    public int diskused;
    public double cpu;


    public Node(float uptime, String name, int timestamp, int diksfree, int diskused, double cpu) {
        this.uptime = uptime;
        this.name = name;
        this.timestamp = timestamp;
        this.diksfree = diksfree;
        this.diskused = diskused;
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Node{" +
                "uptime=" + uptime +
                ", name='" + name + '\'' +
                ", timestamp=" + timestamp +
                ", diksfree=" + diksfree +
                ", diskused=" + diskused +
                ", cpu=" + cpu +
                '}';
    }

    public float getUptime() {
        return uptime;
    }

    public String getName() {
        return name;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getDiksfree() {
        return diksfree;
    }

    public int getDiskused() {
        return diskused;
    }

    public double getCpu() {
        return cpu;
    }
}
