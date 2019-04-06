package integrationTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.Main;

public class integrationTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;

	@Before
	public void setUpStream()
	{
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStream()
	{
	    System.setOut(originalOut);
	}
	
	@Test
	public void test1() throws IOException
	{
		ByteArrayInputStream in1 = new ByteArrayInputStream("K\n".getBytes());
		Main.setScannerSysIn(new Scanner(in1));
		
		Main.main(null);
		
		String expect1 = "******************************\n" 
					   + "Fantastic Console Grade System\n" 
					   + "******************************\n"
					   + "Enter commands:\n"
					   + "[ID]: a 9-digits number\n" 
					   + "K: Kill the program\n";
		assertEquals(expect1, outContent.toString());
	}

}
