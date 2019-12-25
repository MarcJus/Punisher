package fr.marcjus.punisher;

public class PlayerManager {
	
	private boolean npb = false;
	private boolean nopvp = false;
	private boolean autodamage = false;
	private boolean nopickup = false;
	private boolean noopenchest = false;
	
	public boolean isNoPlaceBlock() {
		return npb;
	}
	
	public void setNoPlaceBlock(boolean npb) {
		this.npb = npb;
	}
	
	public boolean isNopvp() {
		return nopvp;
	}
	
	public void setNopvp(boolean nopvp) {
		this.nopvp = nopvp;
	}

	public boolean isAutodamage() {
		return autodamage;
	}

	public void setAutodamage(boolean autodamage) {
		this.autodamage = autodamage;
	}

	public boolean isNopickup() {
		return nopickup;
	}

	public void setNopickup(boolean nopickup) {
		this.nopickup = nopickup;
	}

	public boolean isNoopenchest() {
		return noopenchest;
	}

	public void setNoopenchest(boolean noopenchest) {
		this.noopenchest = noopenchest;
	}

}
