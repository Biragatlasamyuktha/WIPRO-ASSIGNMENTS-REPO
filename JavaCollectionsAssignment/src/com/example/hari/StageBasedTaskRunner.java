package com.example.hari;

import java.util.concurrent.LinkedBlockingQueue;

//Task class
class Task {
int id;

public Task(int id) {
   this.id = id;
}

public int getId() {
   return id;
}

public String toString() {
   return "Task{" + "id=" + id + '}';
}
}

public class StageBasedTaskRunner {
	private final LinkedBlockingQueue<Task> stage1Queue = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<Task> stage2Queue = new LinkedBlockingQueue<>();

    public void submitTask(Task task) {
        stage1Queue.offer(task);
    }

    public void startProcessing() {
        Thread stage1Processor = new Thread(() -> {
            try {
                while (true) {
                    Task task = stage1Queue.take();
                    System.out.println("Stage 1 processing: " + task);
                    if (task.getId() % 2 == 0) {
                        stage2Queue.offer(task);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread stage2Processor = new Thread(() -> {
            try {
                while (true) {
                    Task task = stage2Queue.take();
                    System.out.println("Stage 2 processing: " + task);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        stage1Processor.start();
        stage2Processor.start();
    }

    // For demo
    public static void main(String[] args) throws InterruptedException {
        StageBasedTaskRunner runner = new StageBasedTaskRunner();

        runner.startProcessing();

        for (int i = 1; i <= 10; i++) {
            runner.submitTask(new Task(i));
            Thread.sleep(100); // simulate time between submissions
        }
    }

}
