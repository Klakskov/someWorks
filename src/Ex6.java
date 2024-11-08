public class Ex6 {

    public static void main(String[] args) throws InterruptedException {
        carThread audi  = new carThread("Audi");
        carThread bmw  = new carThread("BMW");

        Thread audiThread = new Thread(audi);
        Thread bmwThread = new Thread(bmw);
        audiThread.start();
        bmwThread.start();

        System.out.println("carThreads are running...");
        Thread.sleep(800);

        audiThread.interrupt();
        bmwThread.interrupt();

        audiThread.join();
        bmwThread.join();
        System.out.println("carThreads stopped ...");

    }

    public static class carThread implements Runnable {
        final String brand;
       // final String model; should be useed?
        //final double price; should be useed?

        public carThread(String brand ) {
            this.brand = brand;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println("hello my name is " +this.brand);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }



    }
}