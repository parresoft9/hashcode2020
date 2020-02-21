package dev.parresoft9.hashcode2020.roundFinal;

public class Library {
	
	private int N; //number books
	private int timeRegister; //tiempo register
	private int sendPerDay; //ritmo al que enviar los libros per day
	public int getSendPerDay() {
		return sendPerDay;
	}
	public void setSendPerDay(int sendPerDay) {
		this.sendPerDay = sendPerDay;
	}
	public int getN() {
		return N;
	}
	public void setN(int n) {
		N = n;
	}
	public int getTimeRegister() {
		return timeRegister;
	}
	public void setTimeRegister(int timeRegister) {
		this.timeRegister = timeRegister;
	}
	public int[] getBooks() {
		return books;
	}
	public void setBooks(int[] books) {
		this.books = books;
	}
	private int[] books;
	

}
