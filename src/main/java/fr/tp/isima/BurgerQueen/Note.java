package fr.tp.isima.BurgerQueen;

import java.io.Serializable;

public class Note implements Serializable {
	public static final int NOTE_MAX = 5;

	private float note = 0.0f;
	private int votes = 0;

	public float getNote() {
		return note;
	}

	public int getVotes() {
		return votes;
	}

	public void vote(int note) {
		if (note < 0 || note > NOTE_MAX) {
			throw new IllegalArgumentException("Note invalide");
		}

		this.note = (votes * this.note + note) / (votes + 1);
		++votes;
	}
}
