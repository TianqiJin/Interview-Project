import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args){
		myModel mymodel = new myModel();
		mySubscriber mysubscriber1 = new mySubscriber();
		mySubscriber mysubscriber2 = new mySubscriber();
		
		mymodel.register(mysubscriber1);
		mymodel.register(mysubscriber2);
		
	   mysubscriber1.setSubject(mymodel);
	   mysubscriber2.setSubject(mymodel);
		mymodel.setMessage("message 1");
		mymodel.setMessage("message 2");
	}
}

abstract class subject{
	abstract void register(object obj);
	abstract void unregister(object obj);
	abstract void notifyAllObjects();
	abstract String getUpdate();
}

abstract class object{
	abstract void update();
	abstract void setSubject(subject sub);
}

class myModel extends subject{
	private List<object> objects;
	private String string;
	myModel(){
		objects = new ArrayList<object>();
	}
	public void register(object obj){
		objects.add(obj);
	}
	public void unregister(object obj){
		objects.remove(obj);
	}
	public String getUpdate(){
		return this.string;
	}
	public void notifyAllObjects(){
		for(object obj: objects){
			obj.update();
		}
	}
	public void setMessage(String inputString){
		this.string = inputString;
		notifyAllObjects();
	}
}

class mySubscriber extends object{
	private subject model;

	public void setSubject(subject sub){
		this.model = sub;
	}
	public void update(){
		String string;
		string = model.getUpdate();
		System.out.println(string);
	}
}