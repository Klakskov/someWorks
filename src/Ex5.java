import java.util.Random;

public class Ex5 {

    static class MovingRunnable implements Runnable {
        private final Random random = new Random();
        private final String moveAction1;
        private final String moveAction2;

        MovingRunnable(String moveAction1, String moveAction2) {
            this.moveAction1 = moveAction1;
            this.moveAction2 = moveAction2;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    int direction = random.nextInt(2);
                    if (direction == 0) {
                        System.out.println(moveAction1);
                    } else {
                        System.out.println(moveAction2);
                    }
                    Thread.sleep(random.nextInt(500) + 500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
    public static void main(String[] args)throws InterruptedException {
        Robot.start();

        Thread.sleep(4000);

        Robot.stop();

    }

    public static class Robot {
        private static final Thread horizontalThread = new Thread(new MovingRunnable("left", "right"));
        private static final Thread verticalThread = new Thread(new MovingRunnable("forward", "backward"));

        public static void start() {
            horizontalThread.start();
            verticalThread.start();
        }

        public static void stop() throws InterruptedException {
            horizontalThread.interrupt();
            verticalThread.interrupt();

            horizontalThread.join();
            verticalThread.join();
        }
    }

}
