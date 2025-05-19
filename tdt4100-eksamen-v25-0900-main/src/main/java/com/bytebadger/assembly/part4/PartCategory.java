package com.bytebadger.assembly.part4;

import java.util.Collection;
import java.util.HashSet;

import no.ntnu.tdt4100.bytebadger.IComputerPart;

/**
 * Implement the class PartCategory.
 * It represents a part category within a hierarchy.
 * 
 * A category can have a single parent category, and any number of children. The
 * parent of a parent, and so on is called an ancestor, and the children of any
 * children is called a descendant. The structure of this part hierarchy is
 * similar to how a folder (a PartCategory object) on your PC can contain
 * multiple subfolders (children PartCategory objects).
 * 
 * Every category should also be able to hold a {@link Collection} of
 * {@link IComputerPart} objects contained within it, similar to how each folder can
 * contain multiple files.
 */

public class PartCategory {

    PartCategory parent;
    Collection<PartCategory> children = new HashSet<>();
    Collection<IComputerPart> parts = new HashSet<>();

    private String name;

    /**
     * Creates a new part category.
     * 
     * @param name The name of the category.
     */
    public PartCategory(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if <code>this</code> object is a descendant of the
     * <code>partCategory</code> argument, either directly with it being
     * <code>this</code> object's parent, or through any number of parents.
     * 
     * You do not need to consider the case where <code>partCategory</code> is
     * null.
     *
     * @param partCategory The {@link PartCategory} object to check against.
     * @return A primitive boolean, that is true if <code>this</code> is a
     *         descendant of <code>partCategory</code>, and false otherwise.
     * 
     * @see PartCategory#parent
     */
    public boolean isDescendantOf(PartCategory partCategory) {

        if(this.parent == null) return false;

        if(this.parent.equals(partCategory)) return true;

        return parent.isDescendantOf(partCategory);

    }

    /**
     * Adds <code>partCategory</code> to <code>this</code> category's list of
     * children. Accordingly, the parent of <code>partCategory</code> should also
     * be set to <code>this</code> category.
     *
     * @param partCategory The partCategory to add as a child, of type
     *                        {@link PartCategory}.
     * @throws IllegalArgumentException If the <code>partCategory</code> is the
     *                                  same object instance as the category itself,
     *                                  or if <code>this</code> category is itself a
     *                                  descendant of the
     *                                  <code>partCategory</code>
     * 
     * @see PartCategory#children
     * @see PartCategory#parent
     */
    public void addChildCategory(PartCategory partCategory) {

        if(partCategory.equals(this) || this.isDescendantOf(partCategory))
            throw new IllegalArgumentException();

        children.add(partCategory);
        partCategory.setParent(this);
    }

    /**
     * Removes <code>partCategory</code> from <code>this</code> category's
     * list of children. If this list does not contain <code>partCategory</code>,
     * then it should throw an {@link IllegalArgumentException}. If no exception
     * occurs, the parent of <code>partCategory</code> should also be set to
     * <code>null</code> accordingly.
     *
     * @param partCategory The partCategory to remove as a child, of type
     *                        {@link PartCategory}.
     * @throws IllegalArgumentException If the <code>partCategory</code> is not
     *                                  in <code>this</code> category's list of
     *                                  children.
     * 
     * @see Collection#contains(PartCategory)
     * @see PartCategory#children
     * @see PartCategory#parent
     */
    public void removeChildCategory(PartCategory partCategory) {

        if(!this.children.contains(partCategory))
            throw new IllegalArgumentException();

        children.remove(partCategory);

    }

    /**
     * Adds a computer part to <code>this</code> category's list of parts
     *
     * @param part The computer part to add, of type {@link IComputerPart}.
     */
    public void addPart(IComputerPart part) {

        this.parts.add(part);
    }

    /**
     * Returns a {@link Collection} of all parts in the category. This should
     * return the parts within <code>this</code> category as well as within any
     * of the children in {@link PartCategory#children}, and any of their
     * descendants. The parts in the parent and other ancestors should not be
     * included.
     * 
     * Parts need not be unique or ordered in any particular way.
     *
     * @return A {@link Collection} of all parts, of type {@link IComputerPart}.
     * 
     * @see Collection#addAll(Collection)
     */
    public Collection<IComputerPart> getAllParts() {

        Collection<IComputerPart> allParts = new HashSet<>();

        this.parts.forEach(part -> allParts.add(part));

        this.children.forEach(child -> child.getAllParts().forEach(part -> allParts.add(part)));

        return allParts;

    }

    public void setParent(PartCategory partCategory) {
        if(partCategory.isDescendantOf(this) || partCategory.equals(this))
            throw new IllegalArgumentException();

        this.parent = partCategory;
    }

    public void removeParent(PartCategory partCategory) {
        if(!this.parent.equals(partCategory))
            throw new IllegalArgumentException();

        this.parent = null;
    }
}
