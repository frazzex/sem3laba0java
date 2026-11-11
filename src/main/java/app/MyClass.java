package app;

import app.Repeat;

public class MyClass {
    @Repeat(times = 1)
    public void startProcess() {
        System.out.println("Процесс запущен.");
    }

    @Repeat(times = 2)
    public void stopProcess() {
        System.out.println("Процесс остановлен.");
    }

    @Repeat(times = 3)
    public String getStatus() {
        return "Активен";
    }

    @Repeat(times = 1)
    protected void validateInput(String input) {
        System.out.println("Проверка ввода: " + input);
    }

    @Repeat(times = 2)
    protected int calculateScore(int baseScore) {
        return baseScore + 10;
    }

    protected boolean isReady() {
        return true;
    }

    @Repeat(times = 3)
    private void logAction(String action, int code) {
        System.out.println("Действие: " + action + ", код: " + code);
    }

    @Repeat()
    private int adjustValue(int value, boolean boost) {
        return boost ? value * 2 : value;
    }

    @Repeat(times = 5)
    private String formatMessage(String message, String prefix) {
        return prefix + ": " + message;
    }
}