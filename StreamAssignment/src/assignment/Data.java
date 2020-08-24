package assignment;

import java.time.LocalDate;

public class Data {
	
	private String transId;
	private String accId;
	private LocalDate postingDate;
	private double postAmount;
	public Data(String transId, String accId, LocalDate postingDate, double postAmount) {
		super();
		this.transId = transId;
		this.accId = accId;
		this.postingDate = postingDate;
		this.postAmount = postAmount;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getAccId() {
		return accId;
	}
	public void setAccId(String accId) {
		this.accId = accId;
	}
	public LocalDate getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(LocalDate postingDate) {
		this.postingDate = postingDate;
	}
	public double getPostAmount() {
		return postAmount;
	}
	public void setPostAmount(double postAmount) {
		this.postAmount = postAmount;
	}
	@Override
	public String toString() {
		return "Data [transId=" + transId + ", accId=" + accId + ", postingDate=" + postingDate + ", postAmount="
				+ postAmount + "]";
	}
	
	
	

}
