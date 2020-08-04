import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {

    CircularBuffer cb = new CircularBuffer();

    @Test
    public void create_new_buffer_with_size() {
        CircularBuffer cb = new CircularBuffer();
    }

    @Test
    public void create_new_buffer_should_empty() {
        boolean result = cb.isEmpty();
        assertTrue("Buffer not empty", result);
    }

    @Test
    public void create_new_buffer_with_default_size_should_be_10() {
        for (int i = 0; i < 10; i++) { //2
            cb.writeData("A" + i);
        }
        boolean result = cb.isFull();
        assertTrue("Buffer not Full", result);

    }

    @Test
    public void write_A_B_to_buffer_should_read_A_B() {
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }

    @Test
    public void write_until_full_and_write_Z_new_data_override_by_Z(){
        for (int i = 0; i < 10; i++) { //2
            cb.writeData("A" + i);
        }
        boolean result = cb.isFull();
        cb.writeData("Z");
        assertTrue("Buffer not Full", result);
        assertEquals("Don't have Z","Z", cb.readData());

    }

    @Test
    public void write_until_full_and_write_C_new_data_should_be_C_next_to_Z(){
        for (int i = 0; i < 10; i++) {
            cb.writeData("A" + i);
        }
        boolean result = cb.isFull();
        cb.writeData("Z");
        cb.writeData("C");
        assertTrue("Buffer not Full", result);
        assertEquals("Don't have Z","Z", cb.readData());
        assertEquals("Don't have C","C", cb.readData());

    }

    @Test
    public void create_new_buffer_by_custom_size_6(){
        cb.setBufferSize(6);
        for (int i = 0; i < 6; i++) {
            cb.writeData("A" + i);
        }
        boolean result = cb.isFull();
        assertTrue("Buffer not Full", result);
    }


}