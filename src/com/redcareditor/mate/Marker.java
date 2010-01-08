package com.redcareditor.mate;

import com.redcareditor.onig.Match;

public class Marker {
	public boolean isCloseScope;
	public Pattern pattern;
	public Match match;
	public int from;  // the line offset where it begins
	public int hint;  // ??
	
	public int length() {
		return match.getCapture(0).end - from;
	}
	
	// Return the most urgent Marker to process. The criteria
	// is earliest, longest markers.
	public Marker bestOf(Marker current) {
		if (current == null) return this;
		if (current.from <= from) { // ||
//			(other.from == from && other.length() == 0) ||
//			(other.from == from && other.length() > length() && length() != 0)) {
			return current;
		}
		else {
			return this;
		}
	}
}
