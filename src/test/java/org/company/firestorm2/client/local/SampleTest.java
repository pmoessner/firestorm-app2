package org.company.firestorm2.client.local;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.jboss.perfrunner.Axis;
import org.jboss.perfrunner.PerfRunner;
import org.jboss.perfrunner.Varying;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PerfRunner.class)       
public class SampleTest {
	

	@Test  
	public void numTest (
	@Varying(name = "MB", axis=Axis.X, from = 1, to = 1000000,step = 250000)int numMax)throws Exception{
	
		String content = "0";     
		FileWriter fstream = new FileWriter("out.txt");    
		BufferedWriter out = new BufferedWriter(fstream);
		for(int num=0; num < numMax; num++){   
    
		out.write(content);
		}
		out.close();
	}    

	 @Test    

	 public void perThread (
	 @Varying(axis=Axis.SERIES, name = "Megabyte",from = 10000, to = 100000, step= 10000) final int megabyte,
	@Varying(name = "thread", axis = Axis.X, from = 1, to = 10, step = 1) final int threadCount) throws InterruptedException {
 
	 // First define the task that needs to be done.
      
	        

	 Runnable task = new Runnable() {

	 @Override

	 public void run() {
             
  try{
			
      // create temporary file with extension suffix
		 File file1 = null;

	 file1 = File.createTempFile("PerThreadTest", ".javatemp");

	 BufferedWriter out = new BufferedWriter(new FileWriter(file1));

//	 System.out.println(file1.getAbsolutePath());

	 for (int i = 1; i < megabyte; i++) {

		out.write('a');
	
	   }
        out.close() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	 }

	 }; 
 
	 // Now define the executor service that will execute the above task

	 ExecutorService exec = Executors.newFixedThreadPool(threadCount);

	 // Submit the task 10 times 

	 for (int i = 0; i < 10; i++) {

	 exec.submit(task);

	 }

	 // Finally, wait for all the submitted tasks to complete (1 hour should be way more than enough!)

	 exec.awaitTermination(1, TimeUnit.SECONDS);

	 // Free the threads that were created by Executors.newFixedThreadPool(threadCount) above

	 exec.shutdown();
 
	 }



@Test
public void perfthread2 
(@Varying (axis=Axis.SERIES, name="", from= 1000 , to = 10000, step = 1000)final int maxNum,
 @Varying (axis = Axis.X, name="thread",from = 1, to = 10, step =1)final int threadCount )throws Exception{
		
	Runnable task = new Runnable() {

		 @Override

		 public void run() {

	       int num = 1;
	       for( int i = 1; i < maxNum; i++ ) {
	       System.out.print(num);
	        }
		
		 }

		 };
		  
		 // Now define the executor service that will execute the above task

		 ExecutorService exec = Executors.newFixedThreadPool(threadCount);

		 // Submit the task 10 times (total data written will be 10MB)

		 for (int i = 0; i < 10; i++) {

		 exec.submit(task);

		 }

		 // Finally, wait for all the submitted tasks to complete (1 hour should be way more than enough!)

		 exec.awaitTermination(1, TimeUnit.SECONDS);

		 // Free the threads that were created by Executors.newFixedThreadPool(threadCount) above

		 exec.shutdown();

	
}

}	
	



	





