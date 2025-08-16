package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private List<MemoryBlock> memoryBlocks;
    private int totalMemory;

    public MemoryManager(int totalMemory) {
        this.totalMemory = totalMemory;
        this.memoryBlocks = new ArrayList<>();
        initializeMemory();
    }

    private void initializeMemory() {
        memoryBlocks.add(new MemoryBlock(totalMemory, true)); // Initial free block
    }

    public boolean allocateMemory(Process process) {
        for (MemoryBlock block : memoryBlocks) {
            if (block.isFree() && block.getSize() >= process.getMemoryRequired()) {
                block.allocate(process);
                return true;
            }
        }
        return false; // Not enough memory available
    }

    public void releaseMemory(Process process) {
        for (MemoryBlock block : memoryBlocks) {
            if (!block.isFree() && block.getAllocatedProcess().equals(process)) {
                block.release();
                break;
            }
        }
    }

    public List<MemoryBlock> getMemoryBlocks() {
        return memoryBlocks;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public int getUsedMemory() {
        return memoryBlocks.stream().mapToInt(block -> block.isFree() ? 0 : block.getSize()).sum();
    }

    public int getFreeMemory() {
        return totalMemory - getUsedMemory();
    }
}