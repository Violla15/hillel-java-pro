package ua.ithillel.lectures.lecture_18.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReader {

    public void read(String path) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = accessFile.getChannel();

        // create buffer with capacity of 48 bytes
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = fileChannel.read(buffer);

        while (bytesRead != -1) {
            buffer.flip(); // make buffer ready for read

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get()); // read 1 byte at a time
            }

            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }
        accessFile.close();
    }
}

