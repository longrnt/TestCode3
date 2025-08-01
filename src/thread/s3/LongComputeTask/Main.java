package thread.s3.LongComputeTask;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(BigInteger.valueOf(2), BigInteger.valueOf(10)));
//        thread.setDaemon(true);
        thread.start();
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            BigInteger result = base;
            for (BigInteger i = BigInteger.ONE; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Prematurely interrupted computation");
//                    return;
//                }
                result = result.multiply(base);
            }

            System.out.println(result);
        }
    }
}
