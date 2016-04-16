package application;

public class Start {
	public static void main(String[] args) {
		boolean isUI=false;
		for(String cmd:args){
			if(cmd.equals("-consol")||cmd.equals("-c"))
				System.out.println("Console");
			if(cmd.equals("-interface")||cmd.equals("-i")){
				isUI=true;
				new Main().launch(args);
			}
		}
	}
}
