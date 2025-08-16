public class MemoryBlock {
    private int size;
    private boolean allocated;

    public MemoryBlock(int size) {
        this.size = size;
        this.allocated = false;
    }

    public int getSize() {
        return size;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void allocate() {
        this.allocated = true;
    }

    public void free() {
        this.allocated = false;
    }
}