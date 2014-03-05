
package javaguibasics;

/** This interface allows my panels, labels, and buttons to find each other. */
public interface ObjectLinker
{
	
	/** Get the next object in the chain. */
	public ObjectLinker nextLink();
	
	/** Get the previous object in the chain. */
	public ObjectLinker prevLink();
	
	/** Insert a new link before this one. */
	public void insertBefore(ObjectLinker obj);
	
	/** Insert a new link after this one. */
	public void insertAfter(ObjectLinker obj);
	
}
