package holding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {

	public static void main(String[] args) {

		List<Command> list = new ArrayList<Command>();
		for (String s : args) {
			list.add(new Command(s));
		}
		Queue<Command> q = Fill.fill(list.toArray());
		new Display().display(q);
		
		PriorityQueue<Simple> dpq = new PriorityQueue<Simple>();
		Random rand = new Random(47);
		for(int i = 0 ; i< 10 ;i++) {
			dpq.offer(new Simple());
		}
		
		while(!dpq.isEmpty()) {
			System.out.println(dpq.poll());
		}
	}
}

class Simple extends Object{
	
}

class Command{
	private String s;
	
	public Command(String s) {
		this.s = s;
	}
	public void opereation() {
		System.out.println(this.s);
	}
}

class Fill{
	
	public static Queue<Command> fill(Object[] c) {
		Queue<Command> q = new LinkedList<>();
		for (Object command : c) {
			q.add((Command) command);
		}
		return q;
	}
}

class Display{
	
	public void display(Queue<Command> q) {
		for (Command command : q) {
			command.opereation();
		}
	}
}