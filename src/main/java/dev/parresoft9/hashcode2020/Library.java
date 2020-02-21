package dev.parresoft9.hashcode2020;

import java.util.ArrayList;

public class Library {
	
	private ArrayList<Integer> libros;
	private int bookPerday;
	private int score;
	private int scanningTime;
	public Library(ArrayList<Integer> libros, int bookPerday, int scanningTime, int score) {
		super(); 
		this.libros = libros;
		this.bookPerday = bookPerday;
		this.score = score;
		this.scanningTime = scanningTime;
	}
	public ArrayList<Integer> getLibros() {
		return libros;
	}
	public void setLibros(ArrayList<Integer> libros) {
		this.libros = libros;
	}
	public int getBookPerday() {
		return bookPerday;
	}
	public void setBookPerday(int bookPerday) {
		this.bookPerday = bookPerday;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScanningTime() {
		return scanningTime;
	}
	public void setScanningTime(int scanningTime) {
		this.scanningTime = scanningTime;
	}
	

}
