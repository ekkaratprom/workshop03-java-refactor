public class CircularBuffer {
    private int bufferSize ; //1.1 hard code : default size
    private final String[] buffer ;
    private int readPointer;
    private int writePointer;

    //Default constructor
    public CircularBuffer() {
        this(10); //default buffer size
    }

    //overload constructor
    public CircularBuffer(int size) {
        this.bufferSize = size;
        this.buffer = new String[bufferSize];
    }

    public boolean isEmpty() {
        return readPointer == writePointer; //read กับ write อยู่ตำแหน่งเดียวกัน
    } //1.2

    public void writeData(String input) {
        if(writePointer == 10){
            writePointer = 0;
        }
        this.buffer[((writePointer++) % this.buffer.length -1 ) + 1 ] = input ;
    }

    public boolean isFull() {
        return writePointer >= bufferSize ; //3 ทุกช่องถูก write จนเต็ม
    }

    public String readData() {
        return this.buffer[((readPointer++) % this.buffer.length - 1 ) + 1 ]  ;
    }

    public void setBufferSize(int input) {
        this.bufferSize = input;
    }
}
