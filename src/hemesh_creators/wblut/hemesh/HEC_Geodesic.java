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

import wblut.geom.WB_Geodesic;
import wblut.geom.WB_Sphere;

/**
 *
 */
public class HEC_Geodesic extends HEC_Creator {
	/**
	 *
	 */
	public static final int TETRAHEDRON = 0;
	/**
	 *
	 */
	public static final int OCTAHEDRON = 1;
	/**
	 *
	 */
	public static final int CUBE = 2;
	/**
	 *
	 */
	public static final int DODECAHEDRON = 3;
	/**
	 *
	 */
	public static final int ICOSAHEDRON = 4;
	/**
	 *
	 */
	private double rx, ry, rz;
	/**
	 *
	 */
	private int type;
	/**
	 *
	 */
	private int b;
	/**
	 *
	 */
	private int c;

	/**
	 *
	 */
	public HEC_Geodesic() {
		super();
		rx = ry = rz = 100;
		type = 4;
		b = c = 4;
	}

	/**
	 *
	 *
	 * @param R
	 */
	public HEC_Geodesic(final double R) {
		this();
		rx = ry = rz = R;
		b = c = 4;
	}

	/**
	 *
	 *
	 * @param R
	 * @return
	 */
	public HEC_Geodesic setRadius(final double R) {
		rx = ry = rz = R;
		return this;
	}

	public HEC_Geodesic setSphere(final WB_Sphere S) {
		rx = ry = rz = S.getRadius();
		setCenter(S.getCenter());
		return this;
	}

	/**
	 *
	 *
	 * @param rx
	 * @param ry
	 * @param rz
	 * @return
	 */
	public HEC_Geodesic setRadius(final double rx, final double ry, final double rz) {
		this.rx = rx;
		this.ry = ry;
		this.rz = rz;
		return this;
	}

	/**
	 *
	 *
	 * @param b
	 * @return
	 */
	public HEC_Geodesic setB(final int b) {
		this.b = b;
		return this;
	}

	/**
	 *
	 *
	 * @param c
	 * @return
	 */
	public HEC_Geodesic setC(final int c) {
		this.c = c;
		return this;
	}

	/**
	 *
	 *
	 * @param t
	 * @return
	 */
	public HEC_Geodesic setType(final int t) {
		type = t;
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see wblut.hemesh.HE_Creator#create()
	 */
	@Override
	protected HE_Mesh createBase() {
		final WB_Geodesic geo = new WB_Geodesic(1.0, b, c, type);
		final HE_Mesh mesh = new HE_Mesh(new HEC_FromWBMesh(geo));
		mesh.scaleSelf(rx, ry, rz);
		return mesh;
	}
}
