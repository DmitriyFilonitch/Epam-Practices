package ua.nure.filonitch.practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Part5 implements Callable<Object> {

    private static final Object MONITOR = new Object();
    private static final int THREADS = 10;
    private static final int COLUMN = 20;
    private static final int LENGTH = System.lineSeparator().length();
    private static String nameOfFile = "part5.txt";
    private static final String ENCODING = "Cp1251";

    private RandomAccessFile out;
    private int pos;
    private String ch;

    public Part5(RandomAccessFile output, int position, String charToFill, int stringLength) {
        this.out = output;
        this.pos = position;

        StringBuilder strbuild = new StringBuilder(stringLength);
        for (int k = 0; k < COLUMN; k++) {
        	strbuild.append(charToFill);
        }
        strbuild.append(System.lineSeparator());
        ch = strbuild.toString();
    }

    @Override
    public Object call() throws IOException {
        RandomAccessFile r = getRAF();
        synchronized (MONITOR) {
            r.seek(pos);
            r.write(ch.getBytes(ENCODING));
        }
        return null;
    }

    private RandomAccessFile getRAF() {
        return out;
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        Files.deleteIfExists(new File(nameOfFile).toPath());
        File file = new File(nameOfFile);
        RandomAccessFile raf = null;
        try(RandomAccessFile raf1 = new RandomAccessFile(file, "rw")) {
        raf = new RandomAccessFile(file, "rw");

        ExecutorService exe = Executors.newFixedThreadPool(THREADS);

        ArrayList<Future> futures = new ArrayList<>();

        int pos = 0;
        for (int currNum = 0; currNum < THREADS; currNum++) {
            String charToFill = String.valueOf(currNum);
            int chLength = COLUMN * charToFill.length();
            int strLength = chLength + LENGTH;

            Future<?> f = exe.submit(new Part5(raf, pos, charToFill, strLength));
            futures.add(f);

            pos += strLength;
        }

        for (Future<?> future : futures) {
            future.get();
        }
        
        exe.shutdown();
        } finally {
        raf.close();
        }
        System.out.println(new String(Files.readAllBytes(file.toPath()), ENCODING));
    }
}
