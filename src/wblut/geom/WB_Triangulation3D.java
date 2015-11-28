/*
 * 
 */
package wblut.geom;

/**
 * 
 */
public class WB_Triangulation3D {
    
    /**
     * 
     */
    private int[] _tetrahedra;

    /**
     * 
     */
    public WB_Triangulation3D() {
    }

    /**
     * 
     *
     * @param tetra 
     */
    public WB_Triangulation3D(final int[] tetra) {
	_tetrahedra = tetra;
    }
    
    public WB_Triangulation3D(final int[][] tetra) {
    	_tetrahedra = new int[tetra.length*4];
    	for(int i=0;i<tetra.length;i++){
    		_tetrahedra[4*i]=tetra[i][0];
    		_tetrahedra[4*i+1]=tetra[i][1];
    		_tetrahedra[4*i+2]=tetra[i][2];
    		_tetrahedra[4*i+3]=tetra[i][3];
    	}
        }

    /**
     * 
     *
     * @return 
     */
    public int[] getTetrahedra() {
	return _tetrahedra;
    }
}