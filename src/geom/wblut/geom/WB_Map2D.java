/*
 * This file is part of HE_Mesh, a library for creating and manipulating meshes.
 * It is dedicated to the public domain. To the extent possible under law,
 * I , Frederik Vanhoutte, have waived all copyright and related or neighboring
 * rights.
 *
 * This work is published from Belgium. (http://creativecommons.org/publicdomain/zero/1.0/)
 *
 */
package wblut.geom;

/**
 *
 * WB_Map2D is an interface for classes that transform between 3D coordinates
 * and 2D coordinates through some form of mapping or projection.
 *
 *
 */
public interface WB_Map2D extends WB_Map {

	/**
	 * Unmap 2D point: map(x,y)->p
	 *
	 * @param p
	 * @param result
	 *            object implementing the WB_MutableCoordinate interface to
	 *            receive the result;
	 */
	public void unmapPoint2D(WB_Coord p, WB_MutableCoord result);

	/**
	 * Unmap 2D point: map(u,v)->p
	 *
	 * @param u
	 * @param v
	 * @param result
	 *            object implementing the WB_MutableCoordinate interface to
	 *            receive the result;
	 */
	public void unmapPoint2D(double u, double v, WB_MutableCoord result);

	/**
	 * Unmap 2D vector: map(x,y)->p
	 *
	 * @param v
	 * @param result
	 *            object implementing the WB_MutableCoordinate interface to
	 *            receive the result;
	 */
	public void unmapVector2D(WB_Coord v, WB_MutableCoord result);

	/**
	 * Unmap 2D vector: map(u,v)->p
	 *
	 * @param u
	 * @param v
	 * @param result
	 *            object implementing the WB_MutableCoordinate interface to
	 *            receive the result;
	 */
	public void unmapVector2D(double u, double v, WB_MutableCoord result);

	/**
	 * Unmap 2D point: map(x,y)->p
	 *
	 * @param p
	 * @return new WB_Coord
	 */
	public WB_Coord unmapPoint2D(WB_Coord p);

	/**
	 * Unmap 2D point: map(u,v)->p
	 *
	 * @param u
	 * @param v
	 * @return new WB_Coord
	 */
	public WB_Coord unmapPoint2D(double u, double v);

	/**
	 * Unmap 2D vector: map(x,y)->p
	 *
	 * @param v
	 * @return new WB_Coord
	 */
	public WB_Coord unmapVector2D(WB_Coord v);

	/**
	 * Unmap 2D vector: map(u,v)->p
	 *
	 * @param u
	 * @param v
	 * @return new WB_Coord
	 */
	public WB_Coord unmapVector2D(double u, double v);
}
