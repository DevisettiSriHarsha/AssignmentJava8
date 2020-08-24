package assignment;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DataOperation {
	
	private long dateDiff(LocalDate date1,LocalDate date2) {
		
		Predicate<LocalDate> holidays = (d) -> d.getDayOfWeek() ==DayOfWeek.SATURDAY || d.getDayOfWeek() ==DayOfWeek.SUNDAY;
		
		long diff = Math.abs(date1.compareTo(date2));
		
		BiFunction<LocalDate, LocalDate,LocalDate> startDate = (d1,d2) -> {
			if(date1.compareTo(date2)<0) {
				return date1;
			}else
				return date2;
		};
		
		LocalDate startD = startDate.apply(date1, date2);
		
		Stream<LocalDate> dateStr = Stream.iterate(startD, d -> d.plusDays(1)).limit(diff);
		long d = dateStr.filter(holidays.negate()).count();
		
		return d;
	}

	private double amountDiff(double amount1, double amount2) {
		
		return Double.parseDouble(String.format("%.2f", amount1-amount2));
	}

	StringBuilder exact = new StringBuilder();
	StringBuilder weak = new StringBuilder();
	StringBuilder xbreak = new StringBuilder();
	StringBuilder ybreak = new StringBuilder();

	public void dataComparing(List<Data> xData, List<Data> yData) {
	
	for(int i=0;i<xData.size();i++) {
		Data xdat = xData.get(i);
		Data ydat = yData.get(i);
		
		if(xdat.getAccId().equals(ydat.getAccId()) && xdat.getPostingDate().compareTo(ydat.getPostingDate())==0 
				&& xdat.getPostAmount()==ydat.getPostAmount()) {
			exact.append(xdat.getTransId()).append(ydat.getTransId() + ", ");
		}
		else if(xdat.getAccId().equals(ydat.getAccId())  &&  dateDiff(xdat.getPostingDate(), ydat.getPostingDate()) <=1 && amountDiff(xdat.getPostAmount(), ydat.getPostAmount()) <= .01)
		{
			weak.append(xdat.getTransId()).append(ydat.getTransId() + ", ");
		}
		else 
		{
			xbreak.append(xdat.getTransId() + ", ");
			ybreak.append(ydat.getTransId() + ", ");
		}
	}
}

}
