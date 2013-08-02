package bean;

public enum SpeedMode {
  SLOW(1000), FASTER(200);

  private long interval;

  SpeedMode(long millseconds) {
	this.interval = millseconds;
  }

  public long getInterval() {
	return this.interval;
  }
}
