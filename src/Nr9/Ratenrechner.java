package Nr9;

import java.util.ArrayList;
public class Ratenrechner {


	private double nachschuessig;
	private double barwert;
	private double jahreszinssatz;
	private int laufzeitInJahren;
	private int ratenProJahr;
	private double rate;




	public void setJahreszinssatz(String s) throws RatenRechnenException{
		try{
			double i = Double.parseDouble(s);
			if(i>0){
				i = jahreszinssatz;
			}else {
				throw new RatenRechnenException();
			}
		}catch (NumberFormatException e){
			throw new RatenRechnenException();
		}



	}

	public String getNachschuessig() throws RatenRechnenException{
		return (nachschuessig+"");
	}
	
	public void setNachschuessig(String nachschuessig) throws RatenRechnenException{
		try {
			double i = Double.parseDouble(nachschuessig);
			if(i <= 0) {
				throw new RatenRechnenException();
			}else {
				this.nachschuessig = i;
			}
		}catch(NumberFormatException e){
			throw new RatenRechnenException();
		}
	}
	
	public String getBarwert() throws RatenRechnenException{
		return (barwert+"");
	}
	
	public void setBarwert(String barwert) throws RatenRechnenException{
		try {
			double wert = Double.parseDouble(barwert);
			if(wert <= 0) {
				throw new RatenRechnenException();
			}else {
				this.barwert = wert;
			}
		}catch(NumberFormatException e){
			throw new RatenRechnenException();
		}	
	}
	
	public String getLaufzeitInJahren() throws RatenRechnenException{
		return (laufzeitInJahren+"");
	}
	
	public void setLaufzeitInJahren(String laufzeitInJahren) throws RatenRechnenException{
		try {
			int wert = Integer.parseInt(laufzeitInJahren);
			if(wert <= 0) {
				throw new RatenRechnenException();
			}else {
				this.laufzeitInJahren = wert;
			}
		}catch(NumberFormatException e){
			throw new RatenRechnenException();
		}
	}
	
	public String getRatenProJahr() throws RatenRechnenException{
		return (ratenProJahr+"");
	}
	
	public void setRatenProJahr(String ratenpj) throws RatenRechnenException{
		try {
			int wert = Integer.parseInt(ratenpj);
			if(wert <= 0) {
				throw new RatenRechnenException();
			}else {
				this.ratenProJahr = wert;
			}
		}catch(NumberFormatException e){
			throw new RatenRechnenException();
		}
	}
	
	public double berechneBarwert() {
		return this.rate/(Math.pow(1+(this.jahreszinssatz/100)/this.ratenProJahr,this.ratenProJahr*this.laufzeitInJahren)*((this.jahreszinssatz/100)/this.ratenProJahr)/(Math.pow(1+(this.jahreszinssatz/100)/this.ratenProJahr, this.ratenProJahr*this.laufzeitInJahren)-1));
	}
	
	public double berechneBarwertv() {
		return this.rate*((this.laufzeitInJahren*this.ratenProJahr)+(this.jahreszinssatz/100/this.ratenProJahr)*((this.laufzeitInJahren*this.ratenProJahr)+1));
	}
	
	public double berechneRate() {
		return this.barwert*(Math.pow(1+(this.jahreszinssatz/100)/this.ratenProJahr,this.ratenProJahr*this.laufzeitInJahren)*((this.jahreszinssatz/100)/this.ratenProJahr)/(Math.pow(1+(this.jahreszinssatz/100)/this.ratenProJahr, this.ratenProJahr*this.laufzeitInJahren)-1));
	}
	
	public double berechneRatev() {
		return (this.barwert*((1+this.jahreszinssatz/100/this.ratenProJahr)-1))/(Math.pow(1+this.jahreszinssatz/100/this.ratenProJahr,1)*(Math.pow(1+this.jahreszinssatz/100/this.ratenProJahr, this.laufzeitInJahren*this.ratenProJahr)-1));
	}
	
	public int berechneLaufzeit() {
		return (int) -((Math.log(1-(((jahreszinssatz/100)*barwert)/(rate*ratenProJahr))))/(Math.log(1+(jahreszinssatz/100))));
	}
	
	public int berechneLaufzeitv() {
		return (int) ((int) (Math.log((this.barwert*((1+this.jahreszinssatz/100/this.ratenProJahr)-1)/(this.rate*Math.pow((1+this.jahreszinssatz/100/this.ratenProJahr), 1)))+1))/(Math.log((1+this.jahreszinssatz/100/this.ratenProJahr))));
	}

	
	public ArrayList<Integer> getPeriode() {
		ArrayList <Integer> ret = new ArrayList();
		for(int i = 1;i <= this.laufzeitInJahren*this.ratenProJahr;i++) {
			ret.add(i);
		}
		return ret;
	}

}
