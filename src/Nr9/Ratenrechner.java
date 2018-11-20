package Nr9;

import javax.sound.midi.Soundbank;

public class Ratenrechner {



	private boolean nachschuessig;
	private double barwert;
	private double jahreszinssatz;
	private int laufzeitInJahren;
	private int ratenProJahr;
	private double rate;





	public void setRate(String s) throws RatenRechnenException{
		try{
			double i = Double.parseDouble(s);

			if(i>0){
				rate = i;
			}else {
				throw new RatenRechnenException();
			}
		}catch (NumberFormatException e){
			throw new RatenRechnenException();
		}
	}

	public String getRate(){
		return rate+"";
	}

	public void setJahreszinssatz(String s) throws RatenRechnenException{
		try{
			double i = Double.parseDouble(s);

			if(i>0){
				jahreszinssatz = (i*0.01);
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
	
	public void setNachschuessig(boolean a){
		nachschuessig = a;
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
	
	public void berechneBarwert() {
		if (nachschuessig) {
			barwert = this.rate / (Math.pow(1 + (this.jahreszinssatz ) / this.ratenProJahr, this.ratenProJahr * this.laufzeitInJahren) * ((this.jahreszinssatz ) / this.ratenProJahr) / (Math.pow(1 + (this.jahreszinssatz ) / this.ratenProJahr, this.ratenProJahr * this.laufzeitInJahren) - 1));
		}else {
			berechneBarwertv();
		}
	}
	
	public void berechneBarwertv() {
		barwert= this.rate*((this.laufzeitInJahren*this.ratenProJahr)+(this.jahreszinssatz/this.ratenProJahr)*((this.laufzeitInJahren*this.ratenProJahr)+1));
	}
	
	public void berechneRate() {
		if(nachschuessig){
		rate = this.barwert*(Math.pow(1+(this.jahreszinssatz)/this.ratenProJahr,this.ratenProJahr*this.laufzeitInJahren)*((this.jahreszinssatz)/this.ratenProJahr)/(Math.pow(1+(this.jahreszinssatz)/this.ratenProJahr, this.ratenProJahr*this.laufzeitInJahren)-1));
		}else {
			berechneRatev();
		}
		rate = Math.floor(rate*100)/100.0;
	}
	
	public void berechneRatev() {
		rate = (this.barwert*((1+this.jahreszinssatz/this.ratenProJahr)-1))/(Math.pow(1+this.jahreszinssatz/this.ratenProJahr,1)*(Math.pow(1+this.jahreszinssatz/this.ratenProJahr, this.laufzeitInJahren*this.ratenProJahr)-1));
	}
	
	public void berechneLaufzeit() {
		if(nachschuessig){
			laufzeitInJahren = (int) -((Math.log(1-(((jahreszinssatz)*barwert)/(rate*ratenProJahr))))/(Math.log(1+(jahreszinssatz))));
		}else {
			berechneLaufzeitv();
		}
	}
	
	public void berechneLaufzeitv() {
		laufzeitInJahren = (int) ((int) (Math.log((this.barwert*((1+this.jahreszinssatz/this.ratenProJahr)-1)/(this.rate*Math.pow((1+this.jahreszinssatz/this.ratenProJahr), 1)))+1))/(Math.log((1+this.jahreszinssatz/this.ratenProJahr))));
	}

	public String getTilgungsplan() throws RatenRechnenException{
		String ret = "";

		ret = "<!DOCTYPE html> <html> <head> <title>This is document title</title> </head> <body>";

		ret +=  "<h1>Tilgungsplan</h1> <table  border=1 cellpadding=12> <tr> <td>Zahlungsart:</td>";

		if (nachschuessig) {
			ret = ret + "<td>Nachschüssig</td> </tr>";
		} else {
			ret = ret + "<td>Vorschüssig</td> </tr>";
		}

		ret += "<tr> <td>Barwert: </td> <td>" + getBarwert() + "</td>";

		ret += "<tr> <td>Jahreszinssatz: </td> <td>" + jahreszinssatz *100+ "%</td>";

		ret += "<tr> <td>Laufzeit in Jahren: </td> <td>" + getLaufzeitInJahren() + "</td>";
		if(ratenProJahr>1) {
			ret += "<tr> <td>Rückzahlungsart: </td> <td>" + getRatenProJahr() + " Raten pro Jahr</td>";
		}else {
			ret += "<tr> <td>Rückzahlungsart: </td> <td>" + getRatenProJahr() + " Rate pro Jahr</td>";
		}

		ret += "<tr> <td>Rate: </td> <td>" + rate + "</td>";


		ret+="</table>";
		ret = ret + "" +
					" <table  border=1 cellpadding=12> <tr> <th>Periode</th> <th>Rate</th> <th>Restkapital</th> <th>Zinsen</th> </tr>";
		double zinzen, kapital;
		kapital=barwert;


		for (int i = 1; i < laufzeitInJahren*ratenProJahr; i++) {
			zinzen=this.runden( kapital*(jahreszinssatz/ratenProJahr));


			kapital -= (rate-zinzen);
			ret = ret + " <tr> <td>" + i + "</td> <td>"+rate+"</td> <td>"+kapital+"</td> <td>"+zinzen+"</td> </tr> ";





		}

		ret+="</table>";
		ret = ret + "</body> </html>";

		return ret;
	}


	private double runden(double i){
		int a = (int)(i *100);

		return a / 100.0;
	}



}
