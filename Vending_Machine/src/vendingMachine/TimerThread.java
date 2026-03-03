package vendingMachine;

// 타이머 스레드 클래스
class TimerThread extends Thread {
    private boolean input = false;

    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                if (input) return;
                System.out.println("남은 시간: " + i + "초");
                Thread.sleep(1000);
            }

            if (!input) {
                System.out.println("\n시간 초과로 인해 거래가 취소되었습니다.");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            // 무시
        }
    }

    public void Received(boolean received) {
        this.input = received;
    }
}
