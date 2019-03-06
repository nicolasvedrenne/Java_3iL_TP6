
public class Forme {
	String type = "NoType";
	private int debutX = 0;
	private int debutY = 0;
	private int finX = 0;
	private int finY = 0;
	private int couleurR = 0;
	private int couleurV = 0;
	private int couleurB = 0;
	
	public Forme() {
		
	}
	public Forme(String type,int debutX,int debutY,int finX,int finY,int couleurR,int couleurV,int couleurB) {
		this.type = type;
		this.debutX = debutX;
		this.debutY = debutY;
		this.finX = finX;
		this.finY = finY;
		this.couleurB = couleurB;
		this.couleurR = couleurR;
		this.couleurV = couleurV;
	}

	@Override
	public String toString() {
		return "Forme [type=" + type + ", debutX=" + debutX + ", debutY=" + debutY + ", finX=" + finX + ", finY=" + finY
				+ ", couleurR=" + couleurR + ", couleurV=" + couleurV + ", couleurB=" + couleurB + "]";
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDebutX() {
		return debutX;
	}

	public void setDebutX(int debutX) {
		this.debutX = debutX;
	}

	public int getDebutY() {
		return debutY;
	}

	public void setDebutY(int debutY) {
		this.debutY = debutY;
	}

	public int getFinX() {
		return finX;
	}

	public void setFinX(int finX) {
		this.finX = finX;
	}

	public int getFinY() {
		return finY;
	}

	public void setFinY(int finY) {
		this.finY = finY;
	}

	public int getCouleurR() {
		return couleurR;
	}

	public void setCouleurR(int couleurR) {
		this.couleurR = couleurR;
	}

	public int getCouleurV() {
		return couleurV;
	}

	public void setCouleurV(int couleurV) {
		this.couleurV = couleurV;
	}

	public int getCouleurB() {
		return couleurB;
	}

	public void setCouleurB(int couleurB) {
		this.couleurB = couleurB;
	}
	
	
}
