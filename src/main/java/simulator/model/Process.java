package simulator.model;

public class Process {
    private int pid;
    private String name;
    private int memoryRequired;
    private int duration;

    public Process(int pid, String name, int memoryRequired, int duration) {
        this.pid = pid;
        this.name = name;
        this.memoryRequired = memoryRequired;
        this.duration = duration;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemoryRequired() {
        return memoryRequired;
    }

    public void setMemoryRequired(int memoryRequired) {
        this.memoryRequired = memoryRequired;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}