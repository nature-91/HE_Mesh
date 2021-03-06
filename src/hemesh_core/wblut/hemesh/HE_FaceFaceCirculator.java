/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 * 
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 * 
 */
package wblut.hemesh;

import java.util.Iterator;

/**
 *
 */
public class HE_FaceFaceCirculator implements Iterator<HE_Face> {

	/**
	 *
	 */
	private final HE_Halfedge _start;

	/**
	 *
	 */
	private HE_Halfedge _current;

	/**
	 *
	 *
	 * @param f
	 */
	HE_FaceFaceCirculator(final HE_Face f) {
		_start = f.getHalfedge();
		_current = null;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		if (_start == null) {
			return false;
		}
		return ((_current == null) || (_current.getNextInFace() != _start))
				&& (_start != null);
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public HE_Face next() {
		if (_current == null) {
			_current = _start;
		} else {
			_current = _current.getNextInFace();
		}
		return _current.getPair().getFace();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}