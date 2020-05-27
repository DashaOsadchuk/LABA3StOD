package com.company;

import java.util.Scanner;

public class Main {

    QueueMassiv queueM = new QueueMassiv();
    QueueDoubleList<MyClass> queueL = new QueueDoubleList<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        userInput(false);
    }

    private void userInput(boolean exit) {
        if (exit) return;
        System.out.println("Используйте (m) чтобы работать с массивом, (d) чтобы работать с двусвязным списком");
        Scanner input = new Scanner(System.in);
        char in = ' ';
        while (true) {
            in = input.nextLine().charAt(0);
            if (in == 'm' || in == 'd') {
                break;
            } else {
                System.out.println("Неправильный ввод, используйте d/m.");
            }
        }
        boolean _exit = false;
        switch (in) {
            case 'm': {
                System.out.println("Что делать с массивом?\n- заполнить 1000 случайных чисел и случайных приоритетво(r)\n- добавить число и приоритет в очередь(a)\n- очистить очередь(c)\n- вывести очередь в консоль(p)\n- пройтись по очереди(n)\n- закончить редактировать очередь(e)");
                while (!_exit) {
                    char inn_ = input.nextLine().charAt(0);
                    switch (inn_) {
                        case 'r': {
                            randomFillArray(true);
                            break;
                        }
                        case 'a': {
                            int[] ints = new int[2];
                            System.out.println("Введите число:");
                            String in_ = input.nextLine();
                            ints[0] = Integer.parseInt(in_);
                            System.out.println("Введите приоритет:");
                            in_ = input.nextLine();
                            ints[1] = Integer.parseInt(in_);
                            queueM.add(new MyClass(ints[0]), ints[1]);
                            break;
                        }
                        case 'c': {
                            int size = queueM.size();
                            queueM.clear();
                            System.out.println("Очищено " + size + " объектов.");
                            break;
                        }
                        case 'p': {
                            queueM.showList();
                            break;
                        }
                        case 'n': {
                            MyClass m = (MyClass) queueM.removeFirst();
                            if (m != null) {
                                System.out.println("Очередь сдвинута на 1 единицу, значение элемента который отработал: " + m.x);
                            }
                            break;
                        }
                        case 'e': {
                            _exit = true;
                            break;
                        }
                    }
                }
            }
            case 'd': {
                System.out.println("Что делать со списоком?\n- заполнить 1000 случайных чисел и случайных приоритетво(r)\n- добавить число и приоритет в список(a)\n- очистить список(c)\n- вывести список в консоль(p)\n- пройтись по списку(n)\n- закончить редактировать список(e)");
                while (!_exit) {
                    char inn_ = input.nextLine().charAt(0);
                    switch (inn_) {
                        case 'r': {
                            randomFillArray(false);
                            break;
                        }
                        case 'a': {
                            int[] ints = new int[2];
                            System.out.println("Введите число:");
                            String in_ = input.nextLine();
                            ints[0] = Integer.parseInt(in_);
                            System.out.println("Введите приоритет:");
                            in_ = input.nextLine();
                            ints[1] = Integer.parseInt(in_);
                            queueL.add(new MyClass(ints[0]), ints[1]);
                            break;
                        }
                        case 'c': {
                            int size = queueL.size();
                            queueL.clear();
                            System.out.println("Очищено " + size + " объектов.");
                            break;
                        }
                        case 'p': {
                            queueL.showList();
                            break;
                        }
                        case 'n': {
                            MyClass m = queueL.removeFirst();
                            if (m != null) {
                                System.out.println("Очередь сдвинута на 1 единицу, значение элемента который отработал: " + m.x);
                            }
                            break;
                        }
                        case 'e': {
                            _exit = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Завершить работу?(y/n)");
        char inn = input.nextLine().charAt(0);
        if (inn == 'y') {
            userInput(true);
        } else {
            userInput(false);
        }
    }

    private void randomFillArray(boolean isArray) {
        for (int i = 0; i < 1000; i++) {
            if (isArray) {
                queueM.add(new MyClass((int) (Math.random() * 1000)), (int)(Math.random()*1000));
            } else {
                queueL.add(new MyClass((int) (Math.random() * 1000)), (int)(Math.random()*1000));
            }
        }
    }

    private static class MyClass {
        public int x;
        public MyClass(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return new String("Значение: "+this.x);
        }
    }
}
