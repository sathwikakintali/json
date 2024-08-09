package org.example;
public class ThreadInterruptExample {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread numberThread = new Thread(new NumberPrinter(printer));
        Thread letterThread = new Thread(new LetterPrinter(printer));

        numberThread.start();
        letterThread.start();
    }
}



class NumberPrinter implements Runnable {
    private final Printer printer;

    public NumberPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printNumbers();
    }
}

class LetterPrinter implements Runnable {
    private final Printer printer;

    public LetterPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printLetters();
    }
}
