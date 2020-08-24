package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataReconcilationEngine {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String str[];
		
		DataOperation dop=new DataOperation();
		
		List<Data> xlist= new ArrayList<Data>();
		List<Data> ylist = new ArrayList<Data>(); 
		
		File xfile = new File("x.txt");
		
		BufferedReader xbr = new BufferedReader(new FileReader(xfile));
		String s="";
		while((s=xbr.readLine())!= null) {
			
			str = s.split("; ");
			
			Data xdata= new Data();
			
			xdata.setTransId(str[0]);
			xdata.setAccId(str[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate date = LocalDate.parse(str[2], formatter);
			xdata.setPostingDate(date);
			xdata.setPostAmount(Double.parseDouble(str[3]));
			
			xlist.add(xdata);
		}
		
		File yfile = new File("y.txt");		 
		
		BufferedReader ybr = new BufferedReader(new FileReader(yfile));
		String[] stry;
		while((s=ybr.readLine())!= null) {
			
			stry = s.split("; ");
			
			Data ydata = new Data();
			
			ydata.setTransId(stry[0]);
			ydata.setAccId(stry[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDate date = LocalDate.parse(stry[2], formatter);
			ydata.setPostingDate(date);
			ydata.setPostAmount(Double.parseDouble(stry[3]));
			
			ylist.add(ydata);
		}
		xbr.close(); 
		ybr.close();
		
		dop.dataComparing(xlist, ylist);
		
		System.out.println("Report \n# XY exact Matches");
		System.out.println("equals "+dop.exact);
		System.out.println("weak "+dop.weak);
		
		System.out.println("xbreaks "+dop.xbreak);
		System.out.println("ybreaks "+dop.ybreak);
	
	
	}

}
