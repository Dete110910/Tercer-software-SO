package models;

import java.util.ArrayList;

public class ProcessManager {

    private final int PROCESS_TIME = 5;

    private ArrayList<Process> inQueue, ready, dispatch, expiration, execution, wait, block, endIOBlockReady,
                                suspendBlockToSuspendBlock, resumeSuspendBlockToBlock, suspendBlock, endIOSuspendBlockToSuspendReady,
                                suspendReady, resumeSuspendReadyToReady, suspendReadyToSuspendReady, suspendExecutionToSuspendReady;
    public ProcessManager(){
        this.inQueue = new ArrayList<>();
        this.ready = new ArrayList<>();
        this.dispatch = new ArrayList<>();
        this.expiration = new ArrayList<>();
        this.execution = new ArrayList<>();
        this.wait = new ArrayList<>();
        this.block = new ArrayList<>();
        this.endIOBlockReady = new ArrayList<>();
        this.suspendBlockToSuspendBlock = new ArrayList<>();
        this.resumeSuspendBlockToBlock = new ArrayList<>();
        this.suspendBlock = new ArrayList<>();
        this.endIOSuspendBlockToSuspendReady = new ArrayList<>();
        this.suspendReady = new ArrayList<>();
        this.resumeSuspendReadyToReady = new ArrayList<>();
        this.suspendReadyToSuspendReady = new ArrayList<>();
        this.suspendExecutionToSuspendReady = new ArrayList<>();
    }

    public void addToInQueue(Process process){
        this.inQueue.add(process);
    }

    public boolean isAlreadyName(String nameProcess) {
        for (Process process : inQueue) {
            if (process.getName().equals(nameProcess))
                return true;
        }
        return false;
    }

    public Object[][] getListAsMatrixObject(ArrayList<Process> list){
        return this.parseArrayListToMatrixObject(list);
    }

    private Object[][] parseArrayListToMatrixObject(ArrayList<Process> list){
        int sizeQueue = list.size();
        Object[][] processList = new Object[sizeQueue][5];

        for(int i = 0; i < sizeQueue; i++){
            processList[i][0] = list.get(i).getName();
            processList[i][1] = list.get(i).getTime();
            processList[i][2] = list.get(i).isBlock();
            processList[i][3] = list.get(i).isSuspend();
            processList[i][4] = list.get(i).isResume();
        }

        return processList;
    }


    public ArrayList<Process> getInQueue() {
        return inQueue;
    }

    public ArrayList<Process> getReady() {
        return ready;
    }

    public ArrayList<Process> getDispatch() {
        return dispatch;
    }

    public ArrayList<Process> getExpiration() {
        return expiration;
    }

    public ArrayList<Process> getExecution() {
        return execution;
    }

    public ArrayList<Process> getWait() {
        return wait;
    }

    public ArrayList<Process> getBlock() {
        return block;
    }

    public ArrayList<Process> getEndIOBlockReady() {
        return endIOBlockReady;
    }

    public ArrayList<Process> getSuspendBlockToSuspendBlock() {
        return suspendBlockToSuspendBlock;
    }

    public ArrayList<Process> getResumeSuspendBlockToBlock() {
        return resumeSuspendBlockToBlock;
    }

    public ArrayList<Process> getSuspendBlock() {
        return suspendBlock;
    }

    public ArrayList<Process> getEndIOSuspendBlockToSuspendReady() {
        return endIOSuspendBlockToSuspendReady;
    }

    public ArrayList<Process> getSuspendReady() {
        return suspendReady;
    }

    public ArrayList<Process> getResumeSuspendReadyToReady() {
        return resumeSuspendReadyToReady;
    }

    public ArrayList<Process> getSuspendReadyToSuspendReady() {
        return suspendReadyToSuspendReady;
    }

    public ArrayList<Process> getSuspendExecutionToSuspendReady() {
        return suspendExecutionToSuspendReady;
    }
}
