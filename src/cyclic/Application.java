package cyclic;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import cyclic.Dependents;

public class Application {
	private Dependents deps;
	
	public void init() {
		ArrayList<String> depsList = new ArrayList<String>();
		
		try(BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))){
        	String strIn;
            while((strIn=stdin.readLine())!=null){   
            	depsList.add(strIn);
            }
        } catch (IOException e) {
            System.out.println("Reading error");
        }
        
        deps = new Dependents(depsList);
	}
	
    public void run() {
    	try(BufferedWriter stdout = new BufferedWriter(new OutputStreamWriter(System.out))){
    		for(String strOut: deps.getCyclic()){
        		stdout.write(strOut+System.getProperty("line.separator"));
        	}
    	} catch (IOException e) {
            System.out.println("Writing error");
        }
    }
	
	public static void main(String[] args) {
		Application application = new Application();
        application.init();
        application.run();
	}
}
