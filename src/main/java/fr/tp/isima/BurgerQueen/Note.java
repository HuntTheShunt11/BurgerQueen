package fr.tp.isima.BurgerQueen;
import java.io.Serializable;

public class Note implements Serializable {
	private float note = 0.0f;
	private final int votes = 0;

	public float getNote() {
		return note;
	}

	public int getVotes() {
		return votes;
	}

	public void vote(float note) {
		this.note = (votes * this.note + note) / (votes + 1);
	}
}
