package dev.parresoft9.hashcode2020.roundFinal;

import java.util.List;

public class Library {
	
	private int id;
	private int puntuacion;
	private int realPoints;
	private int N; //number books
	private int numberBookReal; //number books
	private int timeRegister; //tiempo register
	private int sendPerDay; //ritmo al que enviar los libros per day
	private List<Book> books;
	private double ratio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public int getRealPoints() {
		return realPoints;
	}
	public void setRealPoints(int realPoints) {
		this.realPoints = realPoints;
	}
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
	public int getNumberBookReal() {
		return numberBookReal;
	}
	public void setNumberBookReal(int numberBookReal) {
		this.numberBookReal = numberBookReal;
	}
	public int getTimeRegister() {
		return timeRegister;
	}
	public void setTimeRegister(int timeRegister) {
		this.timeRegister = timeRegister;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	
	

}
