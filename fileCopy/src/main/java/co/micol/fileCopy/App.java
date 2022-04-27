package co.micol.fileCopy;

import co.micol.fileCopy.test.ReadTest;
import co.micol.fileCopy.test.WriteTest;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ReadTest rt = new ReadTest();
    	WriteTest wt = new WriteTest();
    	rt.read();
    	
    	wt.write();
    	
    	
    	
    	
    }
}
