package synchronization;

class Counter {
    private int count = 0;

  public synchronized void increment() {
    //	public  void increment() {
        count++;
    }
  
    public int getCount() {
        return count;
    }
}