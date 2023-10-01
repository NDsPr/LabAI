package chapter2_agent_Task2;

public class DynamicAction extends Action {
	private String name;
	 public static final Action MOVE_UP = new DynamicAction("UP");
	 public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public DynamicAction(String name) {
		this.name = name;
	}

	@Override
	public boolean isNoOp() {
		return false;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
}
