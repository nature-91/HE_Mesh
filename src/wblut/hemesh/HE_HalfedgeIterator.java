/*
 *
 */
package wblut.hemesh;

import java.util.Iterator;

/**
 *
 */
public class HE_HalfedgeIterator implements Iterator<HE_Halfedge> {

	/**
	 *
	 */
	Iterator<HE_Halfedge> _itre,_itrhe,_itruhe;

	/**
	 *
	 *
	 * @param mesh
	 */
	HE_HalfedgeIterator(final HE_RAS<HE_Halfedge> edges, final HE_RAS<HE_Halfedge> halfedges,final HE_RAS<HE_Halfedge> unpairedHalfedges) {
		_itre = edges.iterator();
		_itrhe = halfedges.iterator();
		_itruhe = unpairedHalfedges.iterator();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return _itre.hasNext() || _itrhe.hasNext()|| _itruhe.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public HE_Halfedge next() {
		return (_itre.hasNext())?_itre.next():(_itrhe.hasNext())?_itrhe.next():_itruhe.next();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
