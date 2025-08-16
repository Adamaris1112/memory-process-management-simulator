import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemoryManagerTest {
    private MemoryManager memoryManager;

    @BeforeEach
    void setUp() {
        memoryManager = new MemoryManager();
    }

    @Test
    void testAllocateMemory() {
        Process process = new Process(1, "Process1", 50, 10);
        assertTrue(memoryManager.allocateMemory(process));
        assertEquals(50, memoryManager.getAllocatedMemory());
    }

    @Test
    void testDeallocateMemory() {
        Process process = new Process(1, "Process1", 50, 10);
        memoryManager.allocateMemory(process);
        memoryManager.deallocateMemory(process);
        assertEquals(0, memoryManager.getAllocatedMemory());
    }

    @Test
    void testAllocateMemoryInsufficient() {
        Process process1 = new Process(1, "Process1", 100, 10);
        Process process2 = new Process(2, "Process2", 200, 10);
        assertTrue(memoryManager.allocateMemory(process1));
        assertFalse(memoryManager.allocateMemory(process2));
    }

    @Test
    void testReleaseMemory() {
        Process process = new Process(1, "Process1", 50, 10);
        memoryManager.allocateMemory(process);
        memoryManager.releaseMemory(process);
        assertEquals(0, memoryManager.getAllocatedMemory());
    }
}