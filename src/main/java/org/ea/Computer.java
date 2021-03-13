package org.ea;

public class Computer {
    private final int END_OF_PROGRAM = 0;
    private final int ACCUMILATOR_INST = 1;
    private final int JUMP_INST = 2;
    private final int NOOP_INST = 3;

    private int[] memory = new int[10000];
    private int accumilator = 0;
    private int processPointer = 0;
    private int memoryFill = 0;

    private int currentOpToTest = 0;
    private int currentOp = 0;
    private boolean testJump = false;

    public void addInstruction(String s) {
        String[] sArr = s.split(" ");
        switch (sArr[0]) {
            case "acc":
                memory[memoryFill] = ACCUMILATOR_INST;
                break;
            case "jmp":
                memory[memoryFill] = JUMP_INST;
                break;
            case "nop":
                memory[memoryFill] = NOOP_INST;
                break;
        }
        memoryFill++;
        memory[memoryFill] = Integer.parseInt(sArr[1]);
        memoryFill++;
    }

    public void runInstruction() {
        switch (memory[processPointer]) {
            case ACCUMILATOR_INST:
                accumilator += memory[processPointer + 1];
                processPointer += 2;
                break;
            case JUMP_INST:
                if(testJump && currentOp == currentOpToTest) {
                    processPointer += 2;
                } else {
                    processPointer += (memory[processPointer + 1] * 2);
                }
                currentOp += testJump ? 1 : 0;
                break;
            case NOOP_INST:
                if(!testJump && currentOp == currentOpToTest) {
                    processPointer += (memory[processPointer + 1] * 2);
                } else {
                    processPointer += 2;
                }
                currentOp += testJump ? 0 : 1;
                break;
            case END_OF_PROGRAM:
                System.out.println("Program ended at " + accumilator);
        }
    }

    public int getAccumilator() {
        return accumilator;
    }

    public int getProcessPointer() {
        return processPointer;
    }

    public void setCurrentOpToTest(int currentOpToTest) {
        this.currentOpToTest = currentOpToTest;
    }

    public void reset() {
        this.processPointer = 0;
        this.currentOp = 0;
        this.accumilator = 0;
    }
}
